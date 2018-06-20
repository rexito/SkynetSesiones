/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.controller.horarios;

import org.zerhusen.model.horarios.Jornada;
import org.zerhusen.security.repository.horarios.JornadaRepository;
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

/**
 *
 * @author don_w
 */
@RestController
public class JornadaController {
    
    @Autowired
    private JornadaRepository JornadaRepository;
    
    //Petición GET (Lista jornadas)
    @CrossOrigin
    @RequestMapping(value = "/skynet/jornada/", method = GET)
    public Collection<Jornada> getJornada() {
        return JornadaRepository.findAll();
    }
    
    //Petición GET  (Una jornada)
    @CrossOrigin
    @RequestMapping(value = "/skynet/jornada/{id}", method = GET)
    public Optional<Jornada> getUnaJornada(@PathVariable Integer id) {
        return JornadaRepository.findById(id);
    }
    
    // Petición POST (Nuevo Jornada)
    @CrossOrigin
    @RequestMapping(value = "/skynet/jornada/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Jornada nuevaJornada(@Valid @RequestBody Jornada jornada) {
        JornadaRepository.save(jornada);
        return jornada;
    }
    
    // Petición PUT (Editar jornada)
    @CrossOrigin
    @RequestMapping(value = "/skynet/jornada/{id}", method = PUT)
    public ResponseEntity<Optional<Jornada>> actualizarJornada(@Valid @PathVariable Integer id, @RequestBody Jornada actualizarJornada) {
        Optional<Jornada> jornada = JornadaRepository.findById(id);
        if (jornada != null) {

            actualizarJornada.setIdJornada(id);
            JornadaRepository.save(actualizarJornada);
            return new ResponseEntity<>(jornada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar jornada)
    @CrossOrigin
    @RequestMapping(value = "/skynet/jornada/{id}", method = DELETE)
    public ResponseEntity<Optional<Jornada>> eliminarJornada(@PathVariable Integer id) {
        Optional<Jornada> jornada = JornadaRepository.findById(id);
        JornadaRepository.deleteById(id);
        if (jornada != null) {
            return new ResponseEntity<>(jornada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
