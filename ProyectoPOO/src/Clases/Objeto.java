/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ACER
 */
public class Objeto {
    
    private ImageView imagen;

    public Objeto(String direccion) {
        Image image1 = new Image(getClass().getResourceAsStream(direccion));
        imagen = new ImageView(image1);
    }
    
    
    
    
    
}
