/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Dora
 */
public enum Prioridad {
    BAJA("Baja"),
    MEDIA("Media"),
    ALTA ("Alta"); 
    private String nombre;

    Prioridad(String nombre){
        this.nombre = nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

}
    