/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.model.horarios;

import java.sql.Time;
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
public class Horario {
    public Horario (int id,Asignatura asignatura,Sala sala, Dia dia, Timeslot rangoHora){
        this.id = id;
        this.asignatura = asignatura;
        this.sala = sala;
        this.dia = dia;
        this.rangoHora = rangoHora;
    }

    public Horario() {
    }
    
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    

    
    @NotNull (message = "Campo Obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;
    
    @NotNull (message = "Campo Obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;
    
    @NotNull (message = "Campo Obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_dia")
    private Dia dia;
    
    @NotNull (message = "Campo Obligatorio")
    @ManyToOne
    @JoinColumn (name = "id_rangoHora")
    private Timeslot rangoHora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Timeslot getRangoHora() {
        return rangoHora;
    }

    public void setRangoHora(Timeslot rangoHora) {
        this.rangoHora = rangoHora;
    }

    
    
 
    

    
    
}
