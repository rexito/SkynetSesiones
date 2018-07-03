/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.controller.horarios;

import java.text.ParseException;
import java.util.Collection;
import java.util.Optional;
import javax.annotation.PostConstruct;
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
import org.zerhusen.model.horarios.Dia;
import org.zerhusen.model.horarios.Timeslot;
import org.zerhusen.security.repository.horarios.TimeslotRepository;

/**
 *
 * @author don_w
 */
@RestController
public class TimeslotController {
    
    @Autowired
    private TimeslotRepository repository;
    
    @PostConstruct
    public void init() throws ParseException{
        if(repository.findAll() != null){
            repository.save(new Timeslot(1,"08:30","09:15"));
            repository.save(new Timeslot(2,"09:15","10:00"));
            repository.save(new Timeslot(3,"10:00","10:45"));
            repository.save(new Timeslot(4,"10:45","11:30"));
            repository.save(new Timeslot(5,"11:30","12:15"));
            repository.save(new Timeslot(6,"12:15","13:00"));
            repository.save(new Timeslot(7,"13:00","13:45"));
            repository.save(new Timeslot(8,"13:45","14:30"));
            repository.save(new Timeslot(9,"14:30","15:15"));
            repository.save(new Timeslot(10,"15:15","16:00"));
            repository.save(new Timeslot(11,"16:00","16:45"));
            repository.save(new Timeslot(12,"16:45","17:30"));
            repository.save(new Timeslot(13,"17:30","18:15"));
            repository.save(new Timeslot(14,"18:15","19:00"));
            
        }
    }
    
    @CrossOrigin
    @RequestMapping(value = "/skynet/timeslot/", method = GET)
    public Collection<Timeslot> getTimeslot() {
        return repository.listaTodo();
    }

    //Buscar a un Giro
    @CrossOrigin
    @RequestMapping(value = "/skynet/timeslot/{id}", method = GET)
    public Optional<Timeslot> getGiro(@PathVariable int id) {
        return repository.findById(id);
    }

    // Petición POST(Agregar)
    @CrossOrigin
    @RequestMapping(value = "/skynet/timeslot/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Timeslot nuevoTimeslot(@Valid @RequestBody Timeslot timeslot) {
        repository.save(timeslot);

        return timeslot;
    }

    // Petición PUT (Editar)
    @CrossOrigin
    @RequestMapping(value = "/skynet/timeslot/{id}", method = PUT)
    public ResponseEntity<Optional<Timeslot>> actualizarTimeslot(@Valid @PathVariable int id, @RequestBody Timeslot actualizarTimeslot) {
        Optional<Timeslot> timeslot = repository.findById(id);
        if (timeslot != null) {

            actualizarTimeslot.setId(id);
            repository.save(actualizarTimeslot);
            return new ResponseEntity<>(timeslot, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Petición DELETE(Eliminar)
    @CrossOrigin
    @RequestMapping(value = "/skynet/timeslot/{id}", method = DELETE)
    public ResponseEntity<Optional<Timeslot>> eliminarTimeslot(@PathVariable int id) {
        Optional<Timeslot> timeslot = repository.findById(id);
        repository.deleteById(id);
        if (timeslot != null) {
            return new ResponseEntity<>(timeslot, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
