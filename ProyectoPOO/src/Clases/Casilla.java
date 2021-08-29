/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javafx.scene.layout.StackPane;

/**
 *
 * @author homar
 */
public class Casilla {
    
    private StackPane stackPane;
    private Objeto objeto; 

    public Casilla(StackPane stackPane, Objeto objeto) {
        this.stackPane = stackPane;
        this.objeto = objeto;
    }
    
    public Casilla(StackPane stackPane) {
        this.stackPane = stackPane;
        this.objeto = null;
    }
    
    
    
}
