/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author alberto
 */
public enum Dificultad {
    
    FACIL,
    INTERMEDIO,
    DIFICIL;
    
    public static Dificultad retornoDificultad(String d){
        if(d.equals(Dificultad.FACIL.toString())){
            return FACIL;
        }
        else if(d.equals(Dificultad.INTERMEDIO.toString())){
            return INTERMEDIO;            
        }
        else if(d.equals(Clases.Dificultad.DIFICIL.toString())){
            return DIFICIL;
        }
        return null;
    
    }
}
