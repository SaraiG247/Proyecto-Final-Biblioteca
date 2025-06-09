/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 *
 * @author Sarai
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/Biblioteca?serverTimezone=America/Mexico_City&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root"; 
    private static final String CONTRASENA = "1234";

    private static Connection conexion;

    // Constructor privado para evitar instancias externas
    private ConexionDB() {}

    // Método público para obtener la instancia única de conexión
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
                System.out.println("Conexion exitosa a la base de datos.");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Error de conexion: " + e.getMessage());
            }
        }
        return conexion;
    }
}
