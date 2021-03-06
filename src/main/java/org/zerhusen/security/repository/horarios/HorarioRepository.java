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
    

    

    
    @Query(value = "select * from horario where id_sala = ?1", nativeQuery = true)
    List<Horario> listaHorarioBySala (int id);
    
    @Query(value = "select * from horario where id_rango_hora = any (select id from timeslot where jornada = ?1)", nativeQuery = true)
    List<Horario> listaHorariosByJornada (int id);
}
