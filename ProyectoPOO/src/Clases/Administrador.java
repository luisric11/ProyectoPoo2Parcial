/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class Administrador {
    
    public static final int FILAS=18;
    public static final int COLUMNAS=30;
    public static final int PRESUPUESTO_INICIAL_FACIL=20000;
    public static final int PRESUPUESTO_INICIAL_MEDIO=10000;
    public static final int PRESUPUESTO_INICIAL_DIFICIL=5000;
    public static final String PISO= "/recursos/grassTile";
    public static final int DURACION_DIA_SEGUNDOS = 3;
    public static final int DURACION_MES_SEGUNDOS = 90;
    public static final int CONTAMINACION_IMPUESTO= 150;
    public static final int VECINDARIO=3;
    public static final int MESES_QUIEBRA=3;
    public static Dictionary<String, ArrayList<String>> serviciosData;
    public static Dictionary<String, ArrayList<String>> construccionData;
    public static Ciudad ciudad;
    public static boolean permitirCreacion = true;
    public static ArrayList<Casilla> casillas;
    public static boolean jugable=false;
    public static Tiempo tiempo;
    
    public static void cargarServicios(){
        serviciosData = new Hashtable<String, ArrayList<String>>();
        FileReader f = null;
        String cadena;
        try {
            f = new FileReader("src/servicios.txt");
            BufferedReader b = new BufferedReader(f);
            b.readLine();
            while((cadena = b.readLine())!=null) {
                String [] data = cadena.split(";");
                ArrayList<String> servicio = new ArrayList<>();
                servicio.add(data[1]);
                servicio.add(data[2]);
                servicio.add(data[3]);
                serviciosData.put(data[0],servicio);
            }   b.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void cargarConstrucciones(){
        construccionData = new Hashtable<String, ArrayList<String>>();
        FileReader f = null;
        String cadena;
        try {
            f = new FileReader("src/tipoConstruccion.txt");
            BufferedReader b = new BufferedReader(f);
            b.readLine();
            while((cadena = b.readLine())!=null) {
                String [] data = cadena.split(";");
                ArrayList<String> construccion = new ArrayList<>();
                construccion.add(data[1]);
                construccion.add(data[2]);
                construccion.add(data[3]);
                construccion.add(data[4]);
                construccionData.put(data[0],construccion);
            }   b.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void cargarCiudad(){
        
    }
    
    
}
