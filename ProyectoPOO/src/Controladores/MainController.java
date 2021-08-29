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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import Clases.Administrador;
import Clases.Casilla;
import Clases.Objeto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

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
    private ComboBox servicios;
    
    @FXML
    private Text presupuestoText;
    
    @FXML
    private Text gastosText;
    
    @FXML
    private Button boton1;
    
    @FXML
    private Button cambiarServicio;
    
    @FXML
    private BorderPane pane;
    
    GridPane gridpane;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            gridpane = new GridPane();
            pane.setCenter(gridpane);
            llenarDificultad();
            llenarServicios();
            inicializargridPane();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void llenarDificultad(){
        ObservableList<String> cons = FXCollections.observableArrayList();
        cons.add(Clases.Dificultad.FACIL.toString());
        cons.add(Clases.Dificultad.INTERMEDIO.toString());
        cons.add(Clases.Dificultad.DIFICIL.toString());
        dificultad.getItems().addAll(cons);
    }
    
    private void llenarServicios(){
        ObservableList<String> servs = FXCollections.observableArrayList();
        servs.add("AGUA");
        servs.add("LUZ");
        servs.add("PARQUE");
        servs.add("ESCUELA");
        servicios.getItems().addAll(servs);
    }
    
    private void inicializargridPane() throws FileNotFoundException{
        gridpane.getColumnConstraints().clear();
        for(int i=0;i<Administrador.COLUMNAS;i++){
            for(int j=0;j<Administrador.FILAS;j++){
                try {
                    StackPane stackPane= new StackPane();
                    Image image = new Image(new FileInputStream("src/graphicResources/grassTile.png"));
                    ImageView imagen = new ImageView(image);
                    imagen.setFitHeight(40);
                    imagen.setFitWidth(40);
                    stackPane.getChildren().add(imagen);
                    Casilla casilla = new Casilla(stackPane);
                    gridpane.add(stackPane,i, j);
                    stackPane.setOnMouseClicked(e -> tocarStackPane(casilla));
                } catch (FileNotFoundException ex) {
                    System.exit(0);
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void tocarStackPane(Casilla casilla){
        if(servicios.getSelectionModel().getSelectedItem()!= null){
            switch(servicios.getSelectionModel().getSelectedItem().toString()){
                case "AGUA":
                    System.out.println("agua");
                    break;
                    case "LUZ":
                    System.out.println("LUZ");
                    break;
                    case "PARQUE":
                    System.out.println("PARQUE");
                    break;
                    case "ESCUELA":
                    System.out.println("ESCUELA");
                    break;
            }
        }
    }
    
    private void modificarStackPane(Objeto objeto){
        
    }
    
}
