/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Sarai
 */

public class Libro {
    private String titulo;
    private String nombreAutor;  // Solo el nombre, no el ID
    private String nombreEditorial;
    private String nombreCategoria;
    private int cantidad;
    private int anioEdicion;

    public Libro() {}

    // Constructor completo
    public Libro(String titulo, String nombreAutor, 
                String nombreEditorial, String nombreCategoria, 
                int cantidad, int anioEdicion) {
       
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.nombreEditorial = nombreEditorial;
        this.nombreCategoria = nombreCategoria;
        this.cantidad = cantidad;
        this.anioEdicion = anioEdicion;
    }

    // Getters y Setters (sin los métodos para IDs)

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }
    
    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + nombreAutor 
                + ", editorial=" + nombreEditorial + ", categoria=" + nombreCategoria 
                + ", cantidad=" + cantidad + ", año=" + anioEdicion + '}';
    }
}