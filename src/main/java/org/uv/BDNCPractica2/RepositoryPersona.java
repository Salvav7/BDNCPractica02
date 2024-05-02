/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package org.uv.BDNCPractica2;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Ville
 */
public interface RepositoryPersona extends MongoRepository<Persona, String> {
    
}
