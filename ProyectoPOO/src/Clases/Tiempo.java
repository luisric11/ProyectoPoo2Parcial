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
    
    public Tiempo(Text dia){
        this.dia = dia;
    }
    
    public void run() {
      while(true){
            try {
                Thread.sleep(Administrador.DURACION_DIA_SEGUNDOS*1000);
                Administrador.ciudad.aumentarDia();
                dia.setText(String.valueOf(Administrador.ciudad.getDia()));
                System.out.println(Administrador.ciudad.getDia());
                if(Administrador.ciudad.getDia() % 30== 0){
                    System.out.println("mes");
                }
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
      }
   }
}
   