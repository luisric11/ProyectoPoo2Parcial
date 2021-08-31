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
    private ArrayList<Punto> vecindarioPos;
    private Punto pos;
    
    public Casilla(StackPane stackPane,Objeto objeto,Punto pos) {
        this.stackPane = stackPane;
        this.objeto = objeto;
        this.pos = pos;
    }

    public Casilla(StackPane stackPane,Punto pos) {
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
            //pruebaCero();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Casilla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void demoler(){
        this.objeto=null;
    }

    public Punto getPos() {
        return pos;
    }

    public void setPos(Punto pos) {
        this.pos = pos;
    }

    public ArrayList<Punto> getVecindarioPos() {
        return vecindarioPos;
    }

    public void setVecindarioPos(ArrayList<Punto> vecindarioPos) {
        this.vecindarioPos = vecindarioPos;
    }
    
    
    
    public void generarVecindario(){
        vecindarioPos =  new ArrayList<>();
        for(int i = 1-Administrador.VECINDARIO;i<Administrador.VECINDARIO;i++){
            for(int j = 1-Administrador.VECINDARIO;j<Administrador.VECINDARIO;j++){
                Punto p =  new Punto(pos.getI()-j,pos.getJ()-i);
                if(p.offlimits() &&(pos.getI()!=p.getI() || pos.getJ()!=p.getJ())){
                    vecindarioPos.add(p);
                }
            }            
        }
    }
    
    public void pruebaCero(){
        for(Punto p: vecindarioPos){
            for(Casilla s: Administrador.ciudad.getCasillas()){
                if(s.getPos().getI() == p.getI() && s.getPos().getJ() ==p.getJ()){
                    s.getStackPane().getChildren().clear();
                }
            }
        }
    }
    
}
