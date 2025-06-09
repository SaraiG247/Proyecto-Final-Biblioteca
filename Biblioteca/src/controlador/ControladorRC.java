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
import modelo.Cliente;
import modelo.Rol;

/**
 *
 * @author hecto
 */
public class ControladorRC {
    private Connection conexion;

    public ControladorRC(Connection conexion) {
        this.conexion = conexion;
    }
    
    /*
    *
    *METODOS DEL CONTROLADOR PARA ROLES
    *
    */
    
    public boolean insertar(Rol rol) throws SQLException {
    String sql = "INSERT INTO roles (TipoRol) VALUES (?)";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, rol.getNombre());
        return stmt.executeUpdate() > 0;
    }
}
    
   public boolean actualizar(String nombreAnterior, Rol rol) throws SQLException {
    String sql = "UPDATE roles SET TipoRol=? WHERE TipoRol=?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, rol.getNombre());       // Nuevo nombre
        stmt.setString(2, nombreAnterior);          // Nombre actual en la BD
        return stmt.executeUpdate() > 0;
    }
}
    
    public boolean eliminarPorNombre(String nombre) throws SQLException {
    String sql = "DELETE FROM roles WHERE TipoRol = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        return stmt.executeUpdate() > 0;
    }
}
    
    public List<Rol> buscarTodosRoles() throws SQLException {
        List<Rol> lista = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Rol r = new Rol(
                    rs.getString("TipoRol")
                );
                lista.add(r);
            }
        }
        return lista;
    }
    
    
    /*
    *
    *METODOS DEL CONTROLADOR PARA CLIENTES
    *
    */
    
    public boolean insertarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, apellidos, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getTelefono());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean actualizarCliente(String nombreAnterior, String apellidosAnteriores, String telefonoAnterior, Cliente clienteNuevo) throws SQLException {
        String sql = "UPDATE cliente SET nombre = ?, apellidos = ?, telefono = ? WHERE nombre = ? AND apellidos = ? AND telefono = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, clienteNuevo.getNombre());
            stmt.setString(2, clienteNuevo.getApellidos());
            stmt.setString(3, clienteNuevo.getTelefono());
            stmt.setString(4, nombreAnterior);
            stmt.setString(5, apellidosAnteriores);
            stmt.setString(6, telefonoAnterior);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminarCliente(String nombre, String apellidos, String telefono) throws SQLException {
        String sql = "DELETE FROM cliente WHERE nombre = ? AND apellidos = ? AND telefono = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, telefono);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Cliente> buscarTodosClientes() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("telefono")
                );
                lista.add(c);
            }
        }
        return lista;
    }
}
