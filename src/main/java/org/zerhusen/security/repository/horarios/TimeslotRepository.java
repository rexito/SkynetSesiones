/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.repository.horarios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerhusen.model.horarios.Dia;
import org.zerhusen.model.horarios.Timeslot;

/**
 *
 * @author don_w
 */
public interface TimeslotRepository extends JpaRepository<Timeslot, Integer>{
    
    @Query(value = "select * from Timeslot where start <> 'Default' ORDER BY `timeslot`.`id` ASC", nativeQuery = true)
     List<Timeslot> listaTodo();
     
     @Query(value = "select * from Timeslot where jornada = ?1", nativeQuery = true)
     List<Timeslot> getTimeslotByJornada(int id);
}
