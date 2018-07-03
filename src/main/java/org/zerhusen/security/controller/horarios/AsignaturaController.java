/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.controller.horarios;



import org.zerhusen.model.horarios.Asignatura;
import org.zerhusen.security.repository.horarios.AsignaturaRepository;
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
import org.zerhusen.model.horarios.Seccion;
import org.zerhusen.security.repository.horarios.SeccionRepository;

/**
 *
 * @author don_w
 */
@RestController
public class AsignaturaController {
    
    @Autowired
    private AsignaturaRepository AsignaturaRepository;
    
    //Petición GET (Lista asignaturas)
    @CrossOrigin
    @RequestMapping(value = "/skynet/asignatura/", method = GET)
    public Collection<Asignatura> getAsignatura() {
        return AsignaturaRepository.findAll();
    }
    
    //Petición GET  (Un Asignatura)
    @CrossOrigin
    @RequestMapping(value = "/skynet/asignatura/{id}", method = GET)
    public Optional<Asignatura> getUnaAsignatura(@PathVariable Integer id) {
        return AsignaturaRepository.findById(id);
    }
    
    // Petición POST (Nuevo Asignatura)
    @CrossOrigin
    @RequestMapping(value = "/skynet/asignatura/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Asignatura nuevoAsignatura(@Valid @RequestBody Asignatura asignatura) {
        AsignaturaRepository.save(asignatura);
        return asignatura;
    }
    
    // Petición PUT (Editar asignatura)
    @CrossOrigin
    @RequestMapping(value = "/skynet/asignatura/{id}", method = PUT)
    public ResponseEntity<Optional<Asignatura>> actualizarAsignatura(@Valid @PathVariable Integer id, @RequestBody Asignatura actualizarAsignatura) {
        Optional<Asignatura> asignatura = AsignaturaRepository.findById(id);
        if (asignatura != null) {

            actualizarAsignatura.setId(id);
            AsignaturaRepository.save(actualizarAsignatura);
            return new ResponseEntity<>(asignatura, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar Asignatura)
    @CrossOrigin
    @RequestMapping(value = "/skynet/asignatura/{id}", method = DELETE)
    public ResponseEntity<Optional<Asignatura>> eliminarAsignatura(@PathVariable Integer id) {
        Optional<Asignatura> asignatura = AsignaturaRepository.findById(id);
        AsignaturaRepository.deleteById(id);
        if (asignatura != null) {
            return new ResponseEntity<>(asignatura, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
     @CrossOrigin
    @RequestMapping(value = "/skynet/asignatura/seccion/{id}", method = GET)
    public Collection<Asignatura> getAsignaturaBySeccionByCarrera(@PathVariable Integer id) {
       return AsignaturaRepository.listaAsignaturasBySeccion(id);
    }
}
