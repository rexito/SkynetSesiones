/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.controller.horarios;

import org.zerhusen.model.horarios.Sala;
import org.zerhusen.security.repository.horarios.SalaRepository;
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
public class SalaController {
    
    @Autowired
    public SalaRepository SalaRepository;
    
    //Petición GET (Lista salas)
    @CrossOrigin
    @RequestMapping(value = "/skynet/sala/", method = GET)
    public Collection<Sala> getSala() {
        return SalaRepository.findAll();
    }
    
    //Petición GET  (Una sala)
    @CrossOrigin
    @RequestMapping(value = "/skynet/sala/{id}", method = GET)
    public Optional<Sala> getUnaSala(@PathVariable Integer id) {
        return SalaRepository.findById(id);
    }
    
    // Petición POST (Nuevo sala)
    @CrossOrigin
    @RequestMapping(value = "/skynet/sala/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Sala nuevaJornada(@Valid @RequestBody Sala sala) {
        SalaRepository.save(sala);
        return sala;
    }
    
    // Petición PUT (Editar sala)
    @CrossOrigin
    @RequestMapping(value = "/skynet/sala/{id}", method = PUT)
    public ResponseEntity<Optional<Sala>> actualizarSala(@Valid @PathVariable Integer id, @RequestBody Sala actualizarSala) {
        Optional<Sala> sala = SalaRepository.findById(id);
        if (sala != null) {

            actualizarSala.setIdSala(id);
            SalaRepository.save(actualizarSala);
            return new ResponseEntity<>(sala, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar jornada)
    @CrossOrigin
    @RequestMapping(value = "/skynet/sala/{id}", method = DELETE)
    public ResponseEntity<Optional<Sala>> eliminarSala(@PathVariable Integer id) {
        Optional<Sala> sala = SalaRepository.findById(id);
        SalaRepository.deleteById(id);
        if (sala != null) {
            return new ResponseEntity<>(sala, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
