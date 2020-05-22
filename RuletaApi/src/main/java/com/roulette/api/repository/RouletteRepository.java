package com.roulette.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roulette.api.model.Roulette;

/**
 * This class allows basic operations on the roulette
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@Repository
public interface RouletteRepository extends CrudRepository<Roulette, Long> {

}
