/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerhusen.security.controller.horarios;

import org.zerhusen.model.horarios.Administrador;
import org.zerhusen.security.repository.horarios.AdministradorRepository;
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
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author don_w
 */
@RestController
public class AdministradorController {
    
    @Autowired
    private AdministradorRepository AdministradorRepository;
    
    //Petición GET (Lista Administradores)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/", method = GET)
    public Collection<Administrador> getAdministrador() {
        return AdministradorRepository.findAll();
    }
    
    //Petición GET  (Un Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/{id}", method = GET)
    public Optional<Administrador> getUnAdministrador(@PathVariable Integer id) {
        return AdministradorRepository.findById(id);
    }
    
    // Petición POST (Nuevo Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador nuevoAdministrador(@Valid @RequestBody Administrador administrador) {
        AdministradorRepository.save(administrador);
        return administrador;
    }
    
    // Petición PUT (Editar arriendo)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/{id}", method = PUT)
    public ResponseEntity<Optional<Administrador>> actualizarAdministrador(@Valid @PathVariable Integer id, @RequestBody Administrador actualizarAdministrador) {
        Optional<Administrador> administrador = AdministradorRepository.findById(id);
        if (administrador != null) {

            actualizarAdministrador.setIdAdministrador(id);
            AdministradorRepository.save(actualizarAdministrador);
            return new ResponseEntity<>(administrador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/{id}", method = DELETE)
    public ResponseEntity<Optional<Administrador>> eliminarAdministrador(@PathVariable Integer id) {
        Optional<Administrador> administrador = AdministradorRepository.findById(id);
        AdministradorRepository.deleteById(id);
        if (administrador != null) {
            return new ResponseEntity<>(administrador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
