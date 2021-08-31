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
import Clases.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Enumeration;
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
    private Text dia;
    
    @FXML
    private Button boton1;
    
    @FXML
    private Button cambiarServicio;
    
    @FXML
    private BorderPane pane;
    
    GridPane gridpane;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        presupuestoText.setText("0");
        gastosText.setText("0");
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
        cons.add(Dificultad.FACIL.toString());
        cons.add(Dificultad.INTERMEDIO.toString());
        cons.add(Dificultad.DIFICIL.toString());
        dificultad.getItems().addAll(cons);
        dificultad.setOnAction(e ->cambiarPresupuesto());

    }
    
    private void llenarServicios(){
        ObservableList<String> servs = FXCollections.observableArrayList();
        Enumeration enu = Administrador.serviciosData.keys();
        while (enu.hasMoreElements()) {
            servs.add(enu.nextElement().toString());
        }
        servs.add("DEMOLER");
        servicios.getItems().addAll(servs);
    }
    
    private void inicializargridPane() throws FileNotFoundException{
        Administrador.casillas = new ArrayList<>();
        gridpane.getColumnConstraints().clear();
        for(int i=0;i<Administrador.FILAS;i++){
            for(int j=0;j<Administrador.COLUMNAS;j++){
                StackPane stackPane= new StackPane();
                stackPane.getChildren().add(generarCesped());
                Punto p = new Punto(i,j);
                Casilla casilla = new Casilla(stackPane,p);
                gridpane.add(stackPane,j, i);
                stackPane.setOnMouseClicked(e -> tocarStackPane(casilla));
                Administrador.casillas.add(casilla);
            }
        }
    }
    
    private void tocarStackPane(Casilla casilla){
        if(servicios.getSelectionModel().getSelectedItem()!= null && Administrador.jugable){
            Enumeration enu = Administrador.serviciosData.keys();
            String s = servicios.getSelectionModel().getSelectedItem().toString();
            if(s.equals("DEMOLER")){
                if(casilla.getObjeto()!= null){
                    casilla.demoler();
                    casilla.getStackPane().getChildren().add(generarCesped());
                    Administrador.ciudad.aumentarGastoMensual();
                    actualizarDatos();
                }
                
            }
            else{
                while (enu.hasMoreElements()) {
                    if(enu.nextElement().toString().equals(s)){
                        ArrayList<String> data = Administrador.serviciosData.get(s);
                        Servicio servicio = new Servicio(s,data.get(0),Double.valueOf(data.get(1)),Double.valueOf(data.get(2)));
                        if(Administrador.ciudad.getPresupuesto() > servicio.getPrecioConstruccion()){             
                            casilla.setObjeto(servicio); 
                            deducirServicio(servicio.getPrecioConstruccion(), servicio.getCostoMensual());
                            
                        }
                    }                
                }            
            }   
        }
    }
    
    @FXML
    public void presionarBoton(){
        if(Administrador.permitirCreacion && ciudad.getText().length()>1 && alcalde.getText().length()>1 && Administrador.jugable==false){
            if(dificultad.getSelectionModel().getSelectedItem()!= null){
                String s = dificultad.getSelectionModel().getSelectedItem().toString();
                Administrador.ciudad = new Ciudad(ciudad.getText(),alcalde.getText(),Dificultad.retornoDificultad(s),Administrador.casillas);
                Administrador.jugable = true;
                presupuestoText.setText(String.valueOf(Administrador.ciudad.getPresupuesto()));
                Administrador.permitirCreacion = false;
                Administrador.tiempo = new Tiempo(dia,presupuestoText);
                Administrador.tiempo.start();
            }
        }
    }
    
    private void cambiarPresupuesto(){
        if(Administrador.permitirCreacion && dificultad.getSelectionModel().getSelectedItem()!= null ){
            String s = dificultad.getSelectionModel().getSelectedItem().toString();
            if(s.equals(Dificultad.FACIL.toString())){
                presupuestoText.setText(String.valueOf(Administrador.PRESUPUESTO_INICIAL_FACIL));
            }
            else if(s.equals(Dificultad.INTERMEDIO.toString())){
                presupuestoText.setText(String.valueOf(Administrador.PRESUPUESTO_INICIAL_MEDIO));            }
            else if(s.equals(Clases.Dificultad.DIFICIL.toString())){
                presupuestoText.setText(String.valueOf(Administrador.PRESUPUESTO_INICIAL_DIFICIL));            }
        }
    }
    
    private void actualizarDatos(){
        presupuestoText.setText(String.valueOf(Administrador.ciudad.getPresupuesto()));
        gastosText.setText(String.valueOf(Administrador.ciudad.getGastos()));
    }
    
    private void deducirServicio(Double precioConstruccion, Double gastoMensual){
        Administrador.ciudad.reducirPresupuesto(precioConstruccion);    
        Administrador.ciudad.aumentarGastoMensual();
        actualizarDatos();
        
    }
    
    private ImageView generarCesped(){
        try {
            Image image = new Image(new FileInputStream("src/graphicResources/grassTile.png"));
            ImageView imagen = new ImageView(image);
            imagen.setFitHeight(40);
            imagen.setFitWidth(40);
            return imagen;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
