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
public class Construccion extends Objeto {
    
    private Double alumbrado;
    private Double agua;
    private Double impuestoSuelo;

    public Construccion(String nombre, String ruta, Double alumbrado, Double agua, Double impuestoSuelo) {
        super(nombre, ruta);
        this.alumbrado = alumbrado;
        this.agua = agua;
        this.impuestoSuelo = impuestoSuelo;
    }
    
    @Override
    public Double getIngresoTotal(){
        return alumbrado+agua+impuestoSuelo;
    }
    
 
    
}
