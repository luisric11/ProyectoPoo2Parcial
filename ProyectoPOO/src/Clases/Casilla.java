    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileNotFoundException;
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

    public Casilla(StackPane stackPane,Objeto objeto) {
        this.stackPane = stackPane;
        this.objeto = objeto;
    }

    public Casilla(StackPane stackPane) {
        this.stackPane = stackPane;
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
    
    
    
    

    
    
    
}
