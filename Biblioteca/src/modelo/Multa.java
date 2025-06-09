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
public class Multa {

    private int idPrestamo;
    private double monto;
    private boolean pagado;
    private Date fechaMulta;

    public Multa() {}

    public Multa(int idPrestamo, double monto, boolean pagado, Date fechaMulta) {
        
        this.idPrestamo = idPrestamo;
        this.monto = monto;
        this.pagado = pagado;
        this.fechaMulta = fechaMulta;
    }

   

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Date getFechaMulta() {
        return fechaMulta;
    }

    public void setFechaMulta(Date fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

    @Override
    public String toString() {
        return "Multa{" + "idPrestamo=" + idPrestamo + ", monto=" + monto + ", pagado=" + pagado + ", fechaMulta=" + fechaMulta + '}';
    }

      
}
