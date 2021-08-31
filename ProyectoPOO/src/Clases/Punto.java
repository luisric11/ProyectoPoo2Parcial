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
public class Punto {
    
    private int i;
    private int j;

    public Punto(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    public boolean offlimits(){
        if(i>=0 && i<=Administrador.FILAS && j>=0 && j<=Administrador.COLUMNAS ){
            return true;
        }
        return false;
    }
    
}
