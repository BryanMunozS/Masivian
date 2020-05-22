package com.roulette.api.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.api.dto.ResponseDTO;
import com.roulette.api.dto.RouletteDTO;
import com.roulette.api.model.Roulette;
import com.roulette.api.repository.RouletteRepository;
import com.roulette.api.util.RouletteConstants;

/**
 * This class allow operations with roulettes
 * 
 * @author Bryan Muñoz
 *
 */
@Service
public class RouletteService {

	@Autowired
	RouletteRepository rouletteRepository;

	ModelMapper mapper = new ModelMapper();

	public List<RouletteDTO> getAllRoulettes() {
		List<Roulette> request = new ArrayList<>();
		rouletteRepository.findAll().forEach(request::add);
		Type type = new TypeToken<List<RouletteDTO>>() {
		}.getType();
		return mapper.map(request, type);

	}

	public Long createRoulette() {
		Roulette request = new Roulette(null, false);
		Roulette response = rouletteRepository.save(request);
		return response.getIdRoulette();
	}

	public ResponseDTO activateRoulette(Long id) {
		Optional<Roulette> optional = rouletteRepository.findById(id);
		ResponseDTO response = new ResponseDTO();
		if (optional.isPresent()) {
			Roulette request = optional.get();
			if (!request.isStatus())
				request.setBets(null);
			request.setStatus(true);
			rouletteRepository.save(request);
			response.setResponseCode(RouletteConstants.ROULETTE_CODE_RESPONSE_SUCCESS);
			response.setResponseMessage(RouletteConstants.ROULETTE_SUCCESS_MESSAGE);
		} else {
			response.setResponseCode(RouletteConstants.ROULETTE_FAILED_RESPONSE_CODE);
			response.setResponseMessage(RouletteConstants.RULETA_MENSAJE_DENEGADO);
		}
		return response;
	}

}
