/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author ACER
 */
public class Objeto {
    
    private String nombre;
    private String ruta;

    public Objeto(String nombre,String ruta) {
        this.ruta = ruta;
        this.nombre = nombre;
    }
    
    public ImageView generarImagen() throws FileNotFoundException{
        ruta = generarRuta(ruta,nombre);
        Image image = new Image(new FileInputStream(ruta));
        ImageView imagen = new ImageView(image);
        imagen.setFitHeight(40);
        imagen.setFitWidth(40);
        return imagen;
    }
    
        private String generarRuta(String ruta,String nombre){
        if(!(nombre.equals("CALLE HORIZONTAL") || nombre.equals("CALLE VERTICAL"))){
            System.out.println("A");
        }
        return ruta;
    }
    
    
    
    
    
    
    
}
