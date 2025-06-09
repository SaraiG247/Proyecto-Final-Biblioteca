package controlador;

import modelo.Multa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utilidades.ConexionDB;

public class MultaControlador {
    private final Connection conexion;

    public MultaControlador(Connection conexion) {
        this.conexion = conexion;
    }

  public List<Multa> listarMultas() throws SQLException {
    List<Multa> multas = new ArrayList<>();
    String sql = "SELECT idPrestamo, monto, pagado, fechaMulta FROM multa";

    try (PreparedStatement stmt = conexion.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Multa multa = new Multa();
            multa.setIdPrestamo(rs.getInt("idPrestamo"));
            multa.setMonto(rs.getInt("monto"));

            // Convertir ENUM a booleano
            String pagadoEnum = rs.getString("pagado");
            multa.setPagado(pagadoEnum.equalsIgnoreCase("SI"));

            multa.setFechaMulta(rs.getDate("fechaMulta"));

            multas.add(multa);
        }
    }

    return multas;
}


   
   public boolean marcarMultaComoPagadaPorPrestamo(int idPrestamo) throws SQLException {
    String sql = "UPDATE multa SET pagado = 'SI' WHERE idPrestamo = ?";

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idPrestamo);
        return stmt.executeUpdate() > 0;
    }
}

}