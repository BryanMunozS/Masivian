package com.roulette.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roulette.api.dto.BetDTO;
import com.roulette.api.dto.ResponseDTO;
import com.roulette.api.dto.RouletteDTO;
import com.roulette.api.service.BetService;
import com.roulette.api.service.RouletteService;
import com.roulette.api.util.RouletteConstants;
import com.roulette.api.util.RouletteValidator;

/**
 * rest class that contains requests endpoints
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RestController
public class RouletteRest {

	@Autowired
	BetService betService;

	@Autowired
	RouletteService rouletteService;

	@GetMapping(RouletteConstants.ROULETTE_REST_CONTROLLER_CREATE_ROULETTE)
	public Long createRoulette() {

		return rouletteService.createRoulette();
	}

	@PutMapping(RouletteConstants.ROULETTE_REST_CONTROLLER_OPEN_ROULETTE)
	public ResponseDTO activateRoulette(@RequestParam("id") Long id) {
		return rouletteService.activateRoulette(id);
	}

	@PostMapping(RouletteConstants.ROULETTE_REST_CONTROLLER_ROULETTE_BET)
	public ResponseDTO betToRoulette(@RequestBody BetDTO peticion) {
		boolean result = RouletteValidator.validateBet(peticion);
		ResponseDTO response = new ResponseDTO();
		if (result) {
			response = betService.createBet(peticion);
		} else {
			response.setResponseCode(RouletteConstants.ROULETTE_FAILED_RESPONSE_CODE);
			response.setResponseMessage(RouletteConstants.ROULETTE_VALIDATOR_MESSAGE);
		}
		return response;
	}

	@GetMapping(RouletteConstants.ROULETTE_REST_CONTROLLER_CLOSE_ROULETTE)
	public List<BetDTO> closeRoulette(@RequestParam("roulette") Long idRoulette) {
		return betService.closeBet(idRoulette);
	}

	@GetMapping(RouletteConstants.ROULETTE_REST_CONTROLLER_GET_ALL_ROULETTES)
	public List<RouletteDTO> getAllRoulettes() {
		return rouletteService.getAllRoulettes();
	}
}
