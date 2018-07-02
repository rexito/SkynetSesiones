/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.controller.horarios;

import org.zerhusen.model.horarios.Horario;
import org.zerhusen.security.repository.horarios.HorarioRepository;
import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.model.horarios.Sala;
import org.zerhusen.model.horarios.Seccion;

/**
 *
 * @author don_w
 */
@RestController
public class HorarioController {
    
    @Autowired
    private HorarioRepository HorarioRepository;
    
    //Petición GET (Lista horarios)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/", method = GET)
    public Collection<Horario> getHorario() {
        return HorarioRepository.findAll();
    }
    
    //Petición GET  (Un horario)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/{id}", method = GET)
    public Optional<Horario> getUnHorario(@PathVariable Integer id) {
        return HorarioRepository.findById(id);
    }
    
    // Petición POST (Nuevo horaio)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Horario nuevoHorario(@Valid @RequestBody Horario horario) {
        HorarioRepository.save(horario);
        return horario;
    }
    
    // Petición PUT (Editar horario)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/{id}", method = PUT)
    public ResponseEntity<Optional<Horario>> actualizarHorario(@Valid @PathVariable Integer id, @RequestBody Horario actualizarHorario) {
        Optional<Horario> horario = HorarioRepository.findById(id);
        if (horario != null) {

            actualizarHorario.setId(id);
            HorarioRepository.save(actualizarHorario);
            return new ResponseEntity<>(horario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/{id}", method = DELETE)
    public ResponseEntity<Optional<Horario>> eliminarHorario(@PathVariable Integer id) {
        Optional<Horario> horario = HorarioRepository.findById(id);
        HorarioRepository.deleteById(id);
        if (horario != null) {
            return new ResponseEntity<>(horario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/seccion/{id}", method = GET)
    public Collection<Seccion> getAsignaturaBySeccionByCarrera(@PathVariable Integer id) {
       return HorarioRepository.listaAsignaturasBySeccion(id);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/carrera/{id}", method = GET)
    public Collection<Seccion> getSeccionByCarrera(@PathVariable Integer id) {
       return HorarioRepository.listaSeccionByCarrera(id);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/sala/{id}", method = GET)
    public Collection<Horario> listaHorarioBySala (@PathVariable Integer id){
        return HorarioRepository.listaHorarioBySala(id);
    }
    
}
