/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author homar
 */
public class Tiempo extends Thread {
    
    private int tiempo;
    
    public Tiempo(){
    }
    
    public void run() {
      while(true){
          System.out.println("a");
            try {
                Thread.sleep(Administrador.DURACION_DIA_SEGUNDOS*1000);
                Administrador.ciudad.aumentarDia();
                System.out.println(Administrador.ciudad.getDia());
                if(Administrador.ciudad.getDia() % 30== 0){
                    System.out.println("mes");
                }
            } 
            catch (Exception ex) {
            }
      }
   }
}
   