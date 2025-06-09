package controlador;

import modelo.DetallePrestamo;
import modelo.Prestamo;

import java.sql.*;
import java.util.List;

public class PrestamoControlador {
    private final Connection conexion;

    public PrestamoControlador(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean registrarPrestamo(Prestamo prestamo, List<DetallePrestamo> listaDetalles) throws SQLException {
        if (listaDetalles == null || listaDetalles.isEmpty()) return false;

        int totalLibros = listaDetalles.stream().mapToInt(DetallePrestamo::getCantidad).sum();
        if (totalLibros > 10) {
            throw new IllegalArgumentException("No se pueden prestar más de 10 libros.");
        }

        String sqlPrestamo = "INSERT INTO prestamo (cantidadTotal, fechaPrestamo, fechaDevolucion, status) VALUES (?, ?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalle_prestamo (idPrestamo, idCliente, idLibro, cantidad) VALUES (?, ?, ?, ?)";

        try {
            conexion.setAutoCommit(false); // Inicia transacción

            // Insertar prestamo y recuperar id generado
            int idPrestamoGenerado;
            try (PreparedStatement stmt = conexion.prepareStatement(sqlPrestamo, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, totalLibros);
                stmt.setDate(2, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
                stmt.setDate(3, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
                stmt.setString(4, prestamo.getStatus());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    idPrestamoGenerado = rs.getInt(1);
                } else {
                    conexion.rollback();
                    return false;
                }
            }

            // Insertar detalles
            try (PreparedStatement stmtDetalle = conexion.prepareStatement(sqlDetalle)) {
                for (DetallePrestamo detalle : listaDetalles) {
                    int idCliente = obtenerIdClientePorNombre(detalle.getCliente());
                    int idLibro = obtenerIdLibroPorNombre(detalle.getLibro());

                    if (idCliente == -1 || idLibro == -1) {
                        conexion.rollback();
                        throw new SQLException("Cliente o libro no encontrado.");
                    }

                    stmtDetalle.setInt(1, idPrestamoGenerado);
                    stmtDetalle.setInt(2, idCliente);
                    stmtDetalle.setInt(3, idLibro);
                    stmtDetalle.setInt(4, detalle.getCantidad());
                    stmtDetalle.addBatch();
                    descontarStockLibro(idLibro, detalle.getCantidad());

                }
                stmtDetalle.executeBatch();
            }

            conexion.commit();
            return true;

        } catch (Exception e) {
            conexion.rollback();
            throw e;
        } finally {
            conexion.setAutoCommit(true);
        }
    }

    private int obtenerIdClientePorNombre(String nombreCompleto) throws SQLException {
        String sql = "SELECT idCliente FROM cliente WHERE CONCAT(nombre, ' ', apellidos) = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreCompleto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }

    private int obtenerIdLibroPorNombre(String nombreLibro) throws SQLException {
        String sql = "SELECT idLibro FROM libro WHERE titulo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreLibro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    private void descontarStockLibro(int idLibro, int cantidadPrestada) throws SQLException {
        String sql = "UPDATE libro SET cantidad = cantidad - ? WHERE idLibro = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cantidadPrestada);
            stmt.setInt(2, idLibro);
            stmt.executeUpdate();
        }
    }

    private boolean hayStockDisponible(int idLibro, int cantidadDeseada) throws SQLException {
        String sql = "SELECT cantidad FROM libro WHERE idLibro = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idLibro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cantidad") >= cantidadDeseada;
            }
        }
        return false;
    }

    public boolean marcarComoEntregado(int idPrestamo) throws SQLException {
        String sqlObtenerDetalles = "SELECT idLibro, cantidad FROM detalle_prestamo WHERE idPrestamo = ?";
        String sqlActualizarLibro = "UPDATE libro SET cantidad = cantidad + ? WHERE idLibro = ?";
        String sqlActualizarPrestamo = "UPDATE prestamo SET status = 'Entregado' WHERE idPrestamo = ?";

        try (
                PreparedStatement stmtDetalles = conexion.prepareStatement(sqlObtenerDetalles); PreparedStatement stmtActualizarLibro = conexion.prepareStatement(sqlActualizarLibro); PreparedStatement stmtActualizarPrestamo = conexion.prepareStatement(sqlActualizarPrestamo)) {
            conexion.setAutoCommit(false); // Inicia transacción

            // Obtener todos los libros y cantidades prestadas
            stmtDetalles.setInt(1, idPrestamo);
            ResultSet rs = stmtDetalles.executeQuery();

            while (rs.next()) {
                int idLibro = rs.getInt("idLibro");
                int cantidadDevuelta = rs.getInt("cantidad");

                // Sumar la cantidad al stock del libro
                stmtActualizarLibro.setInt(1, cantidadDevuelta);
                stmtActualizarLibro.setInt(2, idLibro);
                stmtActualizarLibro.addBatch();
            }

            stmtActualizarLibro.executeBatch();

            // Cambiar el estado del préstamo
            stmtActualizarPrestamo.setInt(1, idPrestamo);
            int rowsAffected = stmtActualizarPrestamo.executeUpdate();

            conexion.commit();
            return rowsAffected > 0;

        } catch (Exception e) {
            conexion.rollback();
            throw e;
        } finally {
            conexion.setAutoCommit(true);
        }
    }
 
    public int actualizarPrestamosAMulta() throws SQLException {
    String selectSql = "SELECT idPrestamo FROM prestamo WHERE status = 'Pendiente' AND fechaDevolucion < CURDATE()";
    String updateSql = "UPDATE prestamo SET status = 'Multa' WHERE idPrestamo = ?";
    String insertSql = "INSERT INTO multa (idPrestamo, monto, pagado, fechaMulta) VALUES (?, 500.00, 'NO', CURDATE())";

    int multasGeneradas = 0;

    try (
        PreparedStatement selectStmt = conexion.prepareStatement(selectSql);
        PreparedStatement updateStmt = conexion.prepareStatement(updateSql);
        PreparedStatement insertStmt = conexion.prepareStatement(insertSql);
        ResultSet rs = selectStmt.executeQuery()
    ) {
        while (rs.next()) {
            int idPrestamo = rs.getInt("idPrestamo");

            // Actualizar el estado del préstamo
            updateStmt.setInt(1, idPrestamo);
            updateStmt.executeUpdate();

            // Insertar la multa
            insertStmt.setInt(1, idPrestamo);
            insertStmt.executeUpdate();

            multasGeneradas++;
        }
    }

    return multasGeneradas; // Opcional: devuelve cuántas multas se generaron
}
    
    
    
}
