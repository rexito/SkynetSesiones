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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author don_w
 */

@Entity
public class Seccion {
    
    public Seccion (int id, String nombre, Jornada jornada, Carrera carrera){
        this.id = id;
        this.nombre = nombre;
        this.jornada = jornada;
        this.carrera = carrera;
    }

    public Seccion() {
    }
    
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull (message = "Campo Obligatorio")
    private String nombre;
    
    @JoinColumn(name = "id_jornada")
    @OneToOne
    private Jornada jornada;
    
    @JoinColumn(name = "id_carrera")
    @OneToOne
    private Carrera carrera;

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

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    
}
