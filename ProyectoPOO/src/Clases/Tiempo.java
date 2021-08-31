/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javafx.scene.text.Text;

/**
 *
 * @author homar
 */
public class Tiempo extends Thread {
    
    public Text dia;
    public Text presupuesto;
    
    public Tiempo(Text dia,Text presupuesto){
        this.dia = dia;
        this.presupuesto = presupuesto;
    }
    
    public void run() {
      while(true){
            try {
                Thread.sleep(Administrador.DURACION_DIA_SEGUNDOS*1000);
                Administrador.ciudad.aumentarDia();
                dia.setText(String.valueOf(Administrador.ciudad.getDia()));
                if(Administrador.ciudad.getDia() % 30== 0){
                    Administrador.ciudad.pagarGastoMensual();
                    Administrador.ciudad.aumentarPresupuesto();
                    Administrador.ciudad.cobrarContaminacion();
                    presupuesto.setText(String.valueOf(Administrador.ciudad.getPresupuesto()));
                    Administrador.ciudad.quebrado();
                }
                Administrador.ciudad.posibleResidencia();
                Administrador.ciudad.posibleComercio();
                Administrador.ciudad.posibleIndustria();
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
      }
   }
}
   