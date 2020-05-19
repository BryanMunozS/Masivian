package com.ruleta.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ruleta.api.model.Ruleta;

/**
 * Clase repositorio que permite las operaciones basicas para la ruleta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@Repository
public interface RuletaRepository extends CrudRepository<Ruleta, Long> {

}
