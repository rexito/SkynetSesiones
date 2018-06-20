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
public class Jornada {
    
   public Jornada(int idJornada, String nombreJornada, String detalleJornada) {
        this.idJornada = idJornada;
        this.nombreJornada = nombreJornada;
        this.detalleJornada = detalleJornada;
    }
   
   
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idJornada;
    
    @NotNull (message = "Campo Obligatorio")
    private String nombreJornada;
    
    @NotNull (message = "Campo Obligatorio")
    private String detalleJornada;

    public Jornada() {
    }
    
    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public String getNombreJornada() {
        return nombreJornada;
    }

    public void setNombreJornada(String nombreJornada) {
        this.nombreJornada = nombreJornada;
    }

    
    
    public String getDetalleJornada() {
        return detalleJornada;
    }

    public void setDetalleJornada(String detalleJornada) {
        this.detalleJornada = detalleJornada;
    }
    
    
    }
