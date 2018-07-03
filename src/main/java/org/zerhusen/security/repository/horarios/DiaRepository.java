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

/**
 *
 * @author don_w
 */
public interface DiaRepository extends JpaRepository<Dia, Integer>{
    
     @Query(value = "select * from Dia where nombre <> 'Default' ORDER BY `dia`.`id` ASC", nativeQuery = true)
     List<Dia> listaTodo();
    
}
