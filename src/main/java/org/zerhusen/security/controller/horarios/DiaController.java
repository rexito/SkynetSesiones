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
import org.zerhusen.security.repository.horarios.DiaRepository;

/**
 *
 * @author don_w
 */


//sacowe
@RestController
public class DiaController {
    
    @Autowired
    private DiaRepository repository;
    
    @PostConstruct
    public void init() throws ParseException{
        if(repository.findAll() != null){
            repository.save(new Dia(1, "Lunes"));
            repository.save(new Dia(2, "Martes"));
            repository.save(new Dia(3, "Miercoles"));
            repository.save(new Dia(4, "Jueves"));
            repository.save(new Dia(5, "Viernes"));
            
        }
    }
    
    @CrossOrigin
    @RequestMapping(value = "/skynet/dia/", method = GET)
    public Collection<Dia> getDias() {
        return repository.listaTodo();
    }

    //Buscar a un Giro
    @CrossOrigin
    @RequestMapping(value = "/skynet/dia/{id}", method = GET)
    public Optional<Dia> getGiro(@PathVariable int id) {
        return repository.findById(id);
    }

    // Petición POST(Agregar)
    @CrossOrigin
    @RequestMapping(value = "/skynet/dia/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Dia nuevoDia(@Valid @RequestBody Dia dia) {
        repository.save(dia);

        return dia;
    }

    // Petición PUT (Editar)
    @CrossOrigin
    @RequestMapping(value = "/skynet/dia/{id}", method = PUT)
    public ResponseEntity<Optional<Dia>> actualizarDia(@Valid @PathVariable int id, @RequestBody Dia actualizarDia) {
        Optional<Dia> dia = repository.findById(id);
        if (dia != null) {

            actualizarDia.setId(id);
            repository.save(actualizarDia);
            return new ResponseEntity<>(dia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Petición DELETE(Eliminar)
    @CrossOrigin
    @RequestMapping(value = "/skynet/dia/{id}", method = DELETE)
    public ResponseEntity<Optional<Dia>> eliminarDia(@PathVariable int id) {
        Optional<Dia> dia = repository.findById(id);
        repository.deleteById(id);
        if (dia != null) {
            return new ResponseEntity<>(dia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
