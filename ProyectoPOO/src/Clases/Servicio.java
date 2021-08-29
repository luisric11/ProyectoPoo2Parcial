/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author ACER
 */
public class Servicio extends Objeto {
    
    private String nombre;
    private String ruta;
    private Double precioConstruccion;
    private Double costoMensual;

    public Servicio(String nombre, String ruta, Double precioConstruccion, Double costoMensual, String direccion) {
        super(direccion);
        this.nombre = nombre;
        this.ruta = ruta;
        this.precioConstruccion = precioConstruccion;
        this.costoMensual = costoMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Double getPrecioConstruccion() {
        return precioConstruccion;
    }

    public void setPrecioConstruccion(Double precioConstruccion) {
        this.precioConstruccion = precioConstruccion;
    }

    public Double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(Double costoMensual) {
        this.costoMensual = costoMensual;
    }

    
    
    
}
