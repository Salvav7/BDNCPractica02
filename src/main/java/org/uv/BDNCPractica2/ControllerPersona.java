/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.BDNCPractica2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Ville
 */
@RestController
@RequestMapping("/url")
public class ControllerPersona {
    @Autowired
    
    private RepositoryPersona repositoryPersona;
    
    @GetMapping()
    public List<Persona> list() {
        return repositoryPersona.findAll();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Optional<Persona> persona = repositoryPersona.findById(id);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.get());
        } else {
            return null;
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Persona personaDetails) {
         Optional<Persona> optionalPersona = repositoryPersona.findById(id);
        if (optionalPersona.isPresent()) {
            Persona persona = optionalPersona.get();
            persona.setNombre(personaDetails.getNombre());
            persona.setDireccion(personaDetails.getDireccion());
            persona.setTelefono(personaDetails.getTelefono());
            repositoryPersona.save(persona);
            return ResponseEntity.ok(persona);
        } else {
            return null;
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Persona persona) {
         repositoryPersona.save(persona);
        return ResponseEntity.ok(persona);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         Optional<Persona> optionalPersona = repositoryPersona.findById(id);
        if (optionalPersona.isPresent()) {
            repositoryPersona.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return null;
        }
    }
    
}
