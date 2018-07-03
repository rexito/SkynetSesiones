/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.repository.horarios;

import java.util.List;
import org.zerhusen.model.horarios.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerhusen.model.horarios.Seccion;

/**
 *
 * @author don_w
 */
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{
    
        @Query(value = "select * from asignatura where id_seccion = any (select id from seccion where id = ?1)", nativeQuery = true)
        List<Asignatura> listaAsignaturasBySeccion(int id);

}
