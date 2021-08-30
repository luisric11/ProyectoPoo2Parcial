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
    
    
    private Double precioConstruccion;
    private Double costoMensual;

    public Servicio(String nombre, String ruta,Double precioConstruccion, Double costoMensual) {
        super(nombre,ruta);
        this.precioConstruccion = precioConstruccion;
        this.costoMensual = costoMensual;
    }
    


   
    
    
    
}
