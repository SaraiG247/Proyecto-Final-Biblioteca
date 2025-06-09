/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Autor;
import modelo.Categoria;
import modelo.Editorial;

/**
 *
 * @author sarai
 */
public class ControladorACE {
    private Connection conexion;

    public ControladorACE(Connection conexion) {
        this.conexion = conexion;
    }
    
    /*
    *
    *METODOS DEL CONTROLADOR PARA AUTOR
    *
    */
    
    public boolean insertar(Autor autor) throws SQLException {
    String sql = "INSERT INTO autor (nombre) VALUES (?)";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, autor.getNombre());
        return stmt.executeUpdate() > 0;
    }
}
    
   public boolean actualizar(String nombreAnterior, Autor autor) throws SQLException {
    String sql = "UPDATE autor SET nombre=? WHERE nombre=?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, autor.getNombre());       // Nuevo nombre
        stmt.setString(2, nombreAnterior);          // Nombre actual en la BD
        return stmt.executeUpdate() > 0;
    }
}
    
    public boolean eliminarPorNombre(String nombre) throws SQLException {
    String sql = "DELETE FROM autor WHERE nombre = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        return stmt.executeUpdate() > 0;
    }
}
    
    public List<Autor> buscarTodosAutores() throws SQLException {
        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autor";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Autor a = new Autor(
                    rs.getString("nombre")
                );
                lista.add(a);
            }
        }
        return lista;
    }
    
    
    /*
    *
    *METODOS DEL CONTROLADOR PARA CATEGORIA
    *
    */
    
    public boolean insertarCategoria(Categoria categoria) throws SQLException {
    String sql = "INSERT INTO categoria (nombre) VALUES (?)";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, categoria.getNombre());
        return stmt.executeUpdate() > 0;
    }
}
    
   public boolean actualizarCategoria(String nombreAnterior, Categoria categoria) throws SQLException {
    String sql = "UPDATE categoria SET nombre=? WHERE nombre=?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, categoria.getNombre());       // Nuevo nombre
        stmt.setString(2, nombreAnterior);          // Nombre actual en la BD
        return stmt.executeUpdate() > 0;
    }
}
    
    public boolean eliminarPorNombreCat(String nombre) throws SQLException {
    String sql = "DELETE FROM categoria WHERE nombre = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        return stmt.executeUpdate() > 0;
    }
}
    
    public List<Categoria> buscarTodosCategoria() throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
               Categoria c = new Categoria(
                    rs.getString("nombre")
                );
                lista.add(c);
            }
        }
        return lista;
    }
    
     /*
    *
    *METODOS DEL CONTROLADOR PARA EDITORIAL
    *
    */
    
    public boolean insertarEditorial(Editorial editorial) throws SQLException {
    String sql = "INSERT INTO editorial (nombre) VALUES (?)";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, editorial.getNombre());
        return stmt.executeUpdate() > 0;
    }
}
    
   public boolean actualizarEditorial(String nombreAnterior, Editorial editorial) throws SQLException {
    String sql = "UPDATE editorial SET nombre=? WHERE nombre=?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, editorial.getNombre());       // Nuevo nombre
        stmt.setString(2, nombreAnterior);          // Nombre actual en la BD
        return stmt.executeUpdate() > 0;
    }
}
    
    public boolean eliminarPorNombreEd(String nombre) throws SQLException {
    String sql = "DELETE FROM editorial WHERE nombre = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        return stmt.executeUpdate() > 0;
    }
}
    
    public List<Editorial> buscarTodosEditorial() throws SQLException {
        List<Editorial> lista = new ArrayList<>();
        String sql = "SELECT * FROM editorial";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Editorial e = new Editorial(
                    rs.getString("nombre")
                );
                lista.add(e);
            }
        }
        return lista;
    }
}
