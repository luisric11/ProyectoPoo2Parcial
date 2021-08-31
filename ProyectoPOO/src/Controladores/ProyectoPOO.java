/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Administrador;
import Clases.Tiempo;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author ACER
 */
public class ProyectoPOO extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Administrador.cargarServicios();
        Administrador.cargarConstrucciones();
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("INICIO");
        stage.setScene(scene);
        stage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);
        stage.show();
    }
    
    private void closeWindowEvent(WindowEvent event) {
        System.out.println("Window close request ...");
        try {
            Administrador.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
