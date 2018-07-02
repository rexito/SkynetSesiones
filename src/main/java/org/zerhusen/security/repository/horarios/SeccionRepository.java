/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.repository.horarios;

import java.util.List;
import org.zerhusen.model.horarios.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author don_w
 */
public interface SeccionRepository extends JpaRepository<Seccion, Integer>{

    @Query(value = "select * from seccion where id_carrera = any (select id from carrera where id = ?1)", nativeQuery = true)
    List<Seccion> listaSeccionByCarrera(int id);
    
}
