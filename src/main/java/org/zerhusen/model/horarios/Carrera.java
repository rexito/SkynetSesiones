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
public class Carrera {
    
    public Carrera(int id, String nombre, String detalle){
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public Carrera() {
    }
    
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull (message = "Campo obligatorio")
    private String nombre;
    
    @NotNull (message = "Campo obligatorio")
    private String detalle;

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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    
    
    
}
