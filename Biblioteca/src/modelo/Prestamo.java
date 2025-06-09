/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Sarai
 */
public class Prestamo {
    private int cantidadTotal;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String status; // "Entregado" o "Pendiente" o "Multa"

    public Prestamo(int cantidadTotal, Date fechaPrestamo, Date fechaDevolucion, String status) {
        this.cantidadTotal = cantidadTotal;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.status = status;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getStatus() {
        return status;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "cantidadTotal=" + cantidadTotal + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", status=" + status + '}';
    }


    
}
