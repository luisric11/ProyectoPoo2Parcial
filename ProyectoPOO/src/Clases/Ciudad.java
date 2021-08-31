/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Enumeration;
import javafx.application.Platform;

/**
 *
 * @author alberto
 */
public class Ciudad {
    
    private String ciudad;
    private String alcalde;
    private Dificultad dificultad;
    private double presupuesto;
    private double gastos;
    private ArrayList<Casilla> casillas;
    private int dia;

    public Ciudad(String ciudad, String alcalde, Dificultad dificultad, double presupuesto, double gastos, ArrayList<Casilla> casillas,int dia) {
        this.ciudad = ciudad;
        this.alcalde = alcalde;
        this.dificultad = dificultad;
        this.presupuesto = presupuesto;
        this.gastos = gastos;
        this.casillas = casillas;
        this.dia = dia;
    }

    public Ciudad(String ciudad, String alcalde, Dificultad dificultad, ArrayList<Casilla> casillas) {
        this.dia = 0;
        this.ciudad = ciudad;
        this.alcalde = alcalde;
        this.dificultad = dificultad;
        obtenerPresupuesto(dificultad);
        this.gastos = 0;
        this.casillas = casillas;
    }
    
    private void obtenerPresupuesto(Dificultad d){
        if(d.equals(Dificultad.FACIL)){
            presupuesto = Administrador.PRESUPUESTO_INICIAL_FACIL;
        }
        else if(d.equals(Dificultad.INTERMEDIO)){
            presupuesto = Administrador.PRESUPUESTO_INICIAL_MEDIO;            
        }
        else if(d.equals(Dificultad.DIFICIL)){
            presupuesto = Administrador.PRESUPUESTO_INICIAL_DIFICIL;
        }
        
    }
    

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAlcalde() {
        return alcalde;
    }

    public void setAlcalde(String alcalde) {
        this.alcalde = alcalde;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
    
    public void reducirPresupuesto(Double valor){
        presupuesto =  presupuesto - valor;
    }
    
    public void aumentarGastoMensual(){
        Double valor=0.0;
        for(Casilla c: casillas){ 
            if(c.getObjeto()!=null){
                valor = valor + c.getObjeto().getCostoTotal();
            }   
        }
        gastos = valor;
    }
    
    public  void aumentarPresupuesto(){
        Double valor=0.0;
        for(Casilla c: casillas){ 
            if(c.getObjeto()!=null){
                valor = valor + c.getObjeto().getIngresoTotal();
            }   
        }
        presupuesto = presupuesto + valor;
    }
    
    public void aumentarDia(){
        dia++;
    }
    
    public void pagarGastoMensual(){
        presupuesto = presupuesto - gastos;
    }
    
    public void posibleResidencia(){
        for(Casilla casilla: casillas){
            ArrayList<String> objetos = new ArrayList<>();
            for(Punto p: casilla.getVecindarioPos()){
                for(Casilla s: Administrador.ciudad.getCasillas()){
                    if(s.getPos().getI() == p.getI() && s.getPos().getJ() ==p.getJ() && s.getObjeto()!=null && casilla.getObjeto()==null){
                        if(s.getObjeto() instanceof Servicio){
                            String nombre = s.getObjeto().getNombre();
                            if(!objetos.contains(nombre)){
                                objetos.add(nombre);
                            }
                        }
                    }
                }
            }
            if(objetos.size()>4){
                int numero = (int)(Math.random()*30+1);
                if(numero<=objetos.size()){
                    Enumeration enu = Administrador.construccionData.keys();
                    while (enu.hasMoreElements()) {
                        if(enu.nextElement().toString().equals("RESIDENCIAL")){
                            System.out.println("residencia");
                            ArrayList<String> data = Administrador.construccionData.get("RESIDENCIAL");
                            Construccion residencia = new Construccion("RESIDENCIAL",data.get(3),Double.valueOf(data.get(0)),Double.valueOf(data.get(1)),Double.valueOf(data.get(2)));
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    casilla.setObjeto(residencia);
                                }
                            });
                            
                            
                            
                        }
                    }
                }
            }
        }
    }
    
    public void posibleComercio(){
        for(Casilla casilla: casillas){
            int contador =0;
            boolean residencia=false;
            boolean hospital_escuela=false;
            ArrayList<String> objetos = new ArrayList<>();
            for(Punto p: casilla.getVecindarioPos()){
                for(Casilla s: Administrador.ciudad.getCasillas()){
                    if(s.getPos().getI() == p.getI() && s.getPos().getJ() ==p.getJ() && s.getObjeto()!=null && casilla.getObjeto()==null){
                        if(s.getObjeto().getNombre().equals("RESIDENCIAL")){
                            residencia=true;
                            contador++;
                        }
                        else if(s.getObjeto().getNombre().equals("HOSPITAL") || s.getObjeto().getNombre().equals("ESCUELA") ){
                            hospital_escuela=true;
                            contador++;
                        }
                    }
                }
            }
            if(residencia && hospital_escuela){
                int numero = (int)(Math.random()*30+1);
                if(numero<=contador){
                    Enumeration enu = Administrador.construccionData.keys();
                    while (enu.hasMoreElements()) {
                        if(enu.nextElement().toString().equals("COMERCIAL")){
                            System.out.println("comercio");
                            ArrayList<String> data = Administrador.construccionData.get("COMERCIAL");
                            Construccion comercio = new Construccion("COMERCIAL",data.get(3),Double.valueOf(data.get(0)),Double.valueOf(data.get(1)),Double.valueOf(data.get(2)));
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    casilla.setObjeto(comercio);
                                }
                            });
                        }
                    }
                }
            }
        }
    }
    
    public void posibleIndustria(){
        for(Casilla casilla: casillas){
            int contador =0;
            boolean luz=false;
            boolean agua=false;
            boolean calle=false;
            boolean noResidencia=true;
            ArrayList<String> objetos = new ArrayList<>();
            for(Punto p: casilla.getVecindarioPos()){
                for(Casilla s: Administrador.ciudad.getCasillas()){
                    if(s.getPos().getI() == p.getI() && s.getPos().getJ() ==p.getJ() && s.getObjeto()!=null && casilla.getObjeto()==null){
                        if(s.getObjeto().getNombre().equals("ELECTRICIDAD")){
                            luz=true;
                            contador++;
                        }
                        else if(s.getObjeto().getNombre().equals("AGUA")){
                            agua=true;
                            contador++;
                        }
                        else if(s.getObjeto().getNombre().equals("CALLE HORIZONTAL") ||s.getObjeto().getNombre().equals("CALLE VERTICAL") ){
                            calle=true;
                            contador++;
                        }
                        else if(s.getObjeto().getNombre().equals("RESIDENCIAL")){
                            noResidencia=false;
                            contador++;
                        }
                    }
                }
            }
            if(luz && agua && calle && noResidencia){
                int numero = (int)(Math.random()*30+1);
                if(numero<=contador){
                    Enumeration enu = Administrador.construccionData.keys();
                    while (enu.hasMoreElements()) {
                        if(enu.nextElement().toString().equals("INDUSTRIAL")){
                            System.out.println("industria");
                            ArrayList<String> data = Administrador.construccionData.get("INDUSTRIAL");
                            Construccion industria = new Construccion("INDUSTRIAL",data.get(3),Double.valueOf(data.get(0)),Double.valueOf(data.get(1)),Double.valueOf(data.get(2)));
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    casilla.setObjeto(industria);
                                }
                            });
                        }
                    }
                }
            }
        }
    }
    
    
    
    
    
}
