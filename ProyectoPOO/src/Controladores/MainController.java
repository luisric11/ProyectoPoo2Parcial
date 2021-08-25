/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class MainController implements Initializable {

    @FXML
    private TextField ciudad;
    
    @FXML
    private TextField alcalde;
    
    @FXML
    private ComboBox dificultad;
    
    @FXML
    private Text presupuestoText;
    
    @FXML
    private Text gastosText;
    
    @FXML
    private Button boton1;
    
    @FXML
    private Button cambiarServicio;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarDificultad();
        
    }    
    
    private void llenarDificultad(){
        ObservableList<String> cons = FXCollections.observableArrayList();
        cons.add(Clases.Dificultad.FACIL.toString());
        cons.add(Clases.Dificultad.INTERMEDIO.toString());
        cons.add(Clases.Dificultad.DIFICIL.toString());
        dificultad.getItems().addAll(cons);
    }
    
}
