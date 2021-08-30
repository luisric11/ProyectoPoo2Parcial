    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.StackPane;

/**
 *
 * @author ACER
 */
public class Casilla {
    
    private StackPane stackPane;
    private Objeto objeto; 
    private ArrayList<Integer> vecindarioPos;
    private int pos;
    
    public Casilla(StackPane stackPane,Objeto objeto,int pos) {
        this.stackPane = stackPane;
        this.objeto = objeto;
        this.pos = pos;
    }

    public Casilla(StackPane stackPane,int pos) {
        this.stackPane = stackPane;
        this.pos = pos;
        generarVecindario();
    }

    public StackPane getStackPane() {
        return stackPane;
    }

    public void setStackPane(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
        stackPane.getChildren().clear();
        try {
            stackPane.getChildren().add(objeto.generarImagen());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Casilla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generarVecindario(){
        for(int i = -Administrador.VECINDARIO;i==Administrador.VECINDARIO;i++){
            for(int j = -Administrador.VECINDARIO;j==Administrador.VECINDARIO;i++){
                int post = pos - Administrador.FILAS*i -j;
                if(post > -1 && post < Administrador.COLUMNAS*Administrador.FILAS){
                    vecindarioPos.add(post);
                }
            }            
        }
    }
    
    
    
    

    
    
    
}
