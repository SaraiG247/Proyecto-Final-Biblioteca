/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utilidades.SeguridadUtil;

/**
 *
 * @author Sarai
 */
public class UsuarioControlador {
    private final Connection conexion;

    public UsuarioControlador(Connection conexion) {
        this.conexion = conexion;
    }

    // 🔐 Insertar con nombre de rol (no ID visible)
    public String insertar(Usuario usuario) throws SQLException {
        String contrasenaGenerada = SeguridadUtil.generarContrasenaSegura(10);
        String contrasenaEncriptada;

        try {
            contrasenaEncriptada = SeguridadUtil.encriptar(contrasenaGenerada);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        int idRol = obtenerIdRolPorNombre(usuario.getRol());
        if (idRol == -1) return null;

        String sql = "INSERT INTO usuario (nombre, apellidos, telefono, correo, contrasena, rol) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getTelefono());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, contrasenaEncriptada);
            stmt.setInt(6, idRol);
            if (stmt.executeUpdate() > 0) {
                return contrasenaGenerada;
            }
        }
        return null;
    }

    public boolean actualizar(Usuario usuario) throws SQLException {
        int idRol = obtenerIdRolPorNombre(usuario.getRol());
        if (idRol == -1) return false;

        String sql = "UPDATE usuario SET nombre=?, apellidos=?, telefono=?, rol=? WHERE correo=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getTelefono());
            stmt.setInt(4, idRol);
            stmt.setString(5, usuario.getCorreo());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminarPorCorreo(String correo) throws SQLException {
        String sql = "DELETE FROM usuario WHERE correo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            return stmt.executeUpdate() > 0;
        }
    }

    // 🧠 Login con correo y contraseña
   public Usuario buscarPorCorreoYContrasena(String correo, String contrasenaIngresada) throws SQLException {
    String sql = "SELECT nombre, contrasena FROM usuario WHERE correo = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, correo);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String contrasenaEncriptada = rs.getString("contrasena");

            try {
                String contrasenaDesencriptada = SeguridadUtil.desencriptar(contrasenaEncriptada);


                if (contrasenaDesencriptada.equals(contrasenaIngresada)) {
                    return new Usuario(nombre, null, null, correo, contrasenaEncriptada, null);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    return null;
}




    public Usuario buscarPorCorreo(String correo) throws SQLException {
        String sql = "SELECT u.*, r.TipoRol AS rolNombre FROM usuario u JOIN roles r ON u.rol = r.idRol WHERE u.correo=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getString("rolNombre")
                );
            }
        }
        return null;
    }

    public List<Usuario> buscarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT u.*, r.TipoRol AS rolNombre FROM usuario u JOIN roles r ON u.rol = r.idRol";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getString("rolNombre")
                );
                lista.add(u);
            }
        }
        return lista;
    }

    // 🔍 Obtener ID a partir del nombre del rol
    private int obtenerIdRolPorNombre(String nombreRol) throws SQLException {
        String sql = "SELECT idRol FROM roles WHERE TipoRol = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreRol);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idRol");
            }
        }
        return -1;
    }

    // 📋 Obtener lista de nombres de roles (para ComboBox)
    public List<String> obtenerNombresRoles() throws SQLException {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT TipoRol FROM roles ORDER BY TipoRol";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(rs.getString("TipoRol"));
            }
        }
        return lista;
    }
}

