package com.roulette.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.roulette.api.dto.BetDTO;
import com.roulette.api.model.Roulette;
import com.roulette.api.repository.RouletteRepository;

/**
 * Bet service test class
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BetServiceTest {

	@Autowired
	BetService betService;
	@MockBean
	RouletteRepository rouletteRepository;

	@Test
	public void testCreateBet() throws Exception {
		BetDTO peticion = new BetDTO();
		peticion.setIdRoulette(1L);
		peticion.setBetsMoney(100L);
		peticion.setNumber(3L);
		Roulette ruleta = new Roulette(1L, true);
		ruleta.setBets(new ArrayList<>());
		assertThat(betService.createBet(peticion)).isNotNull();
		Optional<Roulette> optional = Optional.of(ruleta);
		when(rouletteRepository.findById(1L)).thenReturn(optional);
		when(rouletteRepository.save(ruleta)).thenReturn(ruleta);
		assertThat(betService.createBet(peticion).getResopnseCode()).isEqualTo(200);

	}

	@Test
	public void testCloseBet() throws Exception {
		Roulette ruleta = new Roulette();
		Optional<Roulette> optional = Optional.of(ruleta);
		when(rouletteRepository.findById(1L)).thenReturn(optional);
		when(rouletteRepository.save(ruleta)).thenReturn(ruleta);
		assertThat(betService.closeBet(1L)).isNotNull();

	}

}
