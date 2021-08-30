/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class Ciudad {
    
    private String ciudad;
    private String alcalde;
    private Dificultad dificultad;
    private double presupuesto;
    private double gastos;
    private ArrayList<Casilla> casillas;
    private int dia;

    public Ciudad(String ciudad, String alcalde, Dificultad dificultad, double presupuesto, double gastos, ArrayList<Casilla> casillas,int dia) {
        this.ciudad = ciudad;
        this.alcalde = alcalde;
        this.dificultad = dificultad;
        this.presupuesto = presupuesto;
        this.gastos = gastos;
        this.casillas = casillas;
        this.dia = dia;
    }

    public Ciudad(String ciudad, String alcalde, Dificultad dificultad, ArrayList<Casilla> casillas) {
        this.dia = 0;
        this.ciudad = ciudad;
        this.alcalde = alcalde;
        this.dificultad = dificultad;
        obtenerPresupuesto(dificultad);
        this.gastos = 0;
        this.casillas = casillas;
    }
    
    private void obtenerPresupuesto(Dificultad d){
        if(d.equals(Dificultad.FACIL)){
            presupuesto = Administrador.PRESUPUESTO_INICIAL_FACIL;
        }
        else if(d.equals(Dificultad.INTERMEDIO)){
            presupuesto = Administrador.PRESUPUESTO_INICIAL_MEDIO;            
        }
        else if(d.equals(Dificultad.DIFICIL)){
            presupuesto = Administrador.PRESUPUESTO_INICIAL_DIFICIL;
        }
        
    }
    

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAlcalde() {
        return alcalde;
    }

    public void setAlcalde(String alcalde) {
        this.alcalde = alcalde;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
    
    public void reducirPresupuesto(Double valor){
        presupuesto =  presupuesto - valor;
    }
    
    public void aumentarGastoMensual(){
        Double valor=0.0;
        for(Casilla c: casillas){ 
            if(c.getObjeto()!=null){
                valor = valor + c.getObjeto().getCostoTotal();
            }   
        }
        gastos = valor;
    }
    
    public  void aumentarPresupuesto(){
        Double valor=0.0;
        for(Casilla c: casillas){ 
            if(c.getObjeto()!=null){
                valor = valor + c.getObjeto().getIngresoTotal();
            }   
        }
        presupuesto = presupuesto + valor;
    }
    
    public void aumentarDia(){
        dia++;
    }
    
    
    
    
}
