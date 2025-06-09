/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;

/**
 *
 * @author sarai
 */
import java.sql.*;
import java.util.*;
import modelo.Libro;

public class LibroControlador {

    private final Connection conexion;

    public LibroControlador(Connection conexion) {
        this.conexion = conexion;
    }

   public boolean insertar(Libro libro) throws SQLException {
    int idAutor = obtenerIdPorNombre("autor", "idAutor", libro.getNombreAutor());
    int idEditorial = obtenerIdPorNombre("editorial", "idEditorial", libro.getNombreEditorial());
    int idCategoria = obtenerIdPorNombre("categoria", "idCategoria", libro.getNombreCategoria());

    String sql = "INSERT INTO libro (titulo, idAutor, idEditorial, idCategoria, cantidad, anioEdicion) "
               + "VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, libro.getTitulo());
        stmt.setInt(2, idAutor);
        stmt.setInt(3, idEditorial);
        stmt.setInt(4, idCategoria);
        stmt.setInt(5, libro.getCantidad());
        stmt.setInt(6, libro.getAnioEdicion());
        return stmt.executeUpdate() > 0;
    }
}
    
    public boolean editar(Libro libro) throws SQLException {
    int idAutor = obtenerIdPorNombre("autor", "idAutor", libro.getNombreAutor());
    int idEditorial = obtenerIdPorNombre("editorial", "idEditorial", libro.getNombreEditorial());
    int idCategoria = obtenerIdPorNombre("categoria", "idCategoria", libro.getNombreCategoria());

    String sql = "UPDATE libro SET idAutor=?, idEditorial=?, idCategoria=?, cantidad=?, anioEdicion=? "
               + "WHERE titulo=?";

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idAutor);
        stmt.setInt(2, idEditorial);
        stmt.setInt(3, idCategoria);
        stmt.setInt(4, libro.getCantidad());
        stmt.setInt(5, libro.getAnioEdicion());

        stmt.setString(6, libro.getTitulo());

        return stmt.executeUpdate() > 0;
    }
}
    
    
    public boolean eliminarLibro(String titulo, String nombreAutor, String nombreEditorial) throws SQLException {
    String sql = "DELETE FROM libro WHERE titulo = ? AND idAutor = (SELECT idAutor FROM autor WHERE nombre = ?)"+
            "AND idEditorial = (SELECT idEditorial FROM editorial WHERE nombre = ?)";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, titulo);
        stmt.setString(2, nombreAutor);
        stmt.setString(3, nombreEditorial);
        return stmt.executeUpdate() > 0;
    }
}
    
    public List<Libro> buscarTodosLibros() throws SQLException {
    List<Libro> lista = new ArrayList<>();

   String sql = "SELECT l.titulo, a.nombre AS autor, e.nombre AS editorial, " +
             "c.nombre AS categoria, l.cantidad, l.anioEdicion "+
             "FROM libro l " +
             "JOIN autor a ON l.idAutor = a.idAutor " +
             "JOIN editorial e ON l.idEditorial = e.idEditorial " +
             "JOIN categoria c ON l.idCategoria = c.idCategoria";




    try (PreparedStatement stmt = conexion.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Libro libro = new Libro(
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("editorial"),
                rs.getString("categoria"),
                rs.getInt("cantidad"),
                rs.getInt("anioEdicion")
            );
            lista.add(libro);
        }
    }

    return lista;
}
    
    public List<String> obtenerNombres(String tabla) throws SQLException {
    List<String> nombres = new ArrayList<>();
    String sql = "SELECT nombre FROM " + tabla;

    try (PreparedStatement stmt = conexion.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            nombres.add(rs.getString("nombre"));
        }
    }

    return nombres;
}
    private int obtenerIdPorNombre(String tabla, String campoId, String nombre) throws SQLException {
    String sql = "SELECT " + campoId + " FROM " + tabla + " WHERE nombre = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            throw new SQLException("No se encontró " + tabla + " con nombre: " + nombre);
        }
    }
}
    
}