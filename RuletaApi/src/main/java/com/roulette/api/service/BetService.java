package com.roulette.api.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.api.dto.BetDTO;
import com.roulette.api.dto.ResponseDTO;
import com.roulette.api.model.Bet;
import com.roulette.api.model.Roulette;
import com.roulette.api.repository.RouletteRepository;
import com.roulette.api.util.RouletteConstants;

/**
 * This class allow operations with bets
 * @author Bryan Muñoz
 *
 */
@Service
public class BetService {

	@Autowired
	RouletteRepository rouletteRepository;
	@Autowired
	HttpServletRequest requestUrl;

	ModelMapper mapper = new ModelMapper();

	public List<BetDTO> closeBet(Long id) {
		Optional<Roulette> optional = rouletteRepository.findById(id);
		if (optional.isPresent()) {
			Roulette roulette = optional.get();
			roulette.setStatus(false);
			rouletteRepository.save(roulette);
			Type type = new TypeToken<List<BetDTO>>() {
			}.getType();
			return mapper.map(roulette.getBets(), type);
		}
		return new ArrayList<>();
	}

	public ResponseDTO createBet(BetDTO request) {
		boolean statusRoulette = checkRoulette(request.getIdRoulette());
		ResponseDTO response = new ResponseDTO();
		if (statusRoulette && request.getBetsMoney() != null && request.getBetsMoney() > 0
				&& request.getBetsMoney() <= 10000) {
			response = saveBet(request);
		} else {
			response.setResponseCode(RouletteConstants.ROULETTE_FAILED_RESPONSE_CODE);
			response.setResponseMessage(RouletteConstants.RULETA_MENSAJE_DENEGADO);
		}
		return response;
	}

	private ResponseDTO saveBet(BetDTO request) {
		Roulette roulette = rouletteRepository.findById(request.getIdRoulette()).get();
		request.setIdUser(requestUrl.getHeader("idUser"));
		Bet bet = mapper.map(request, Bet.class);
		if (request.getColor() != null) {
			request.setNumber(null);
		} else {
			request.setColor(null);
		}
		roulette.addBets(bet);
		rouletteRepository.save(roulette);
		return new ResponseDTO(RouletteConstants.ROULETTE_CODE_RESPONSE_SUCCESS,
				RouletteConstants.ROULETTE_SUCCESS_MESSAGE);
	}

	private boolean checkRoulette(Long idRoulette) {
		Optional<Roulette> optional = rouletteRepository.findById(idRoulette);
		if (optional.isPresent()) {
			if (optional.get().isStatus()) {
				return true;
			}
		}
		return false;
	}
}
