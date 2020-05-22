package com.roulette.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.roulette.api.model.Roulette;
import com.roulette.api.repository.RouletteRepository;
import com.roulette.api.util.RouletteConstants;

/**
 * Roulette service test class
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RouletteServiceTest {

	@Autowired
	RouletteService rouletteService;
	@MockBean
	RouletteRepository rouletteRepository;

	@Test
	public void testGetAllRoulettes() throws Exception {
		Roulette roulette = new Roulette();
		when(rouletteRepository.findAll()).thenReturn(Arrays.asList(roulette));
		assertThat(rouletteService.getAllRoulettes()).isNotNull();
	}

	@Test
	public void testActivateRoulette() throws Exception {
		assertThat(rouletteService.activateRoulette(1L).getResopnseCode())
				.isEqualTo(RouletteConstants.ROULETTE_FAILED_RESPONSE_CODE);
		Optional<Roulette> optional = Optional.of(new Roulette());
		when(rouletteRepository.findById(1L)).thenReturn(optional);
		when(rouletteRepository.save(new Roulette())).thenReturn(new Roulette());
		assertThat(rouletteService.activateRoulette(1L).getResopnseCode())
				.isEqualTo(RouletteConstants.ROULETTE_CODE_RESPONSE_SUCCESS);

	}

}
