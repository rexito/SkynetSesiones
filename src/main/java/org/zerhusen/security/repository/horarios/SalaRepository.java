/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.repository.horarios;

import java.util.List;
import org.zerhusen.model.horarios.Sala;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author don_w
 */
public interface SalaRepository extends JpaRepository<Sala, Integer>{
    
    @Query(value = "select * from sala where piso = 1", nativeQuery = true)
    List<Sala> listaSalaByPiso1(String piso);
    
    @Query(value = "select * from sala where piso = 2", nativeQuery = true)
    List<Sala> listaSalaByPiso2(String piso);
    
    @Query(value = "select * from sala where piso = 3", nativeQuery = true)
    List<Sala> listaSalaByPiso3(String piso);

}


