/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hecto
 */
public class DetallePrestamo {
    private String cliente;
    private String libro;
    private int cantidad;

    public DetallePrestamo(String cliente, String libro, int cantidad) {
        this.cliente = cliente;
        this.libro = libro;
        this.cantidad = cantidad;
    }

    public String getCliente() {
        return cliente;
    }

    public String getLibro() {
        return libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetallePrestamo{" + "cliente=" + cliente + ", libro=" + libro + ", cantidad=" + cantidad + '}';
    }
    
    
}
