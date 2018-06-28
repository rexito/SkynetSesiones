/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.repository.horarios;
import java.util.List;
import org.zerhusen.model.horarios.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerhusen.model.horarios.Sala;
import org.zerhusen.model.horarios.Seccion;

/**
 *
 * @author don_w
 */
public interface HorarioRepository extends JpaRepository<Horario, Integer>{
    
    @Query(value = "select nombre from asignatura where id_seccion = any (select id from seccion where id_carrera = any (select id from carrera where id = ?1))", nativeQuery = true)
    List<Seccion> listaSeccionByCarrera(int id);
    
    @Query(value = "select seccion.id, seccion.nombre from seccion where id_carrera = any (select id from carrera where id = ?1)", nativeQuery = true)
    List<Seccion> listaSeccionByCarrera1(int id);
}
