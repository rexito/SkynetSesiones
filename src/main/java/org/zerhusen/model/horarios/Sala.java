/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.model.horarios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author don_w
 */
@Entity
public class Sala {
    
    public Sala (int id, String nombreSala, String piso){
        this.id = id;
        this.nombre = nombre;
        this.piso = piso;
    }

    public Sala() {
    }
        
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
   
    private String piso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    
    
    
    
}
