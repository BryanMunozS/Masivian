package com.roulette.api.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.roulette.api.dto.BetDTO;
import com.roulette.api.dto.ResponseDTO;
import com.roulette.api.service.BetService;
import com.roulette.api.service.RouletteService;
import com.roulette.api.util.RouletteConstants;

/**
 * Roulette rest controller test class
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RouletteRestTest {

	@Autowired
	RouletteRest rest;

	@MockBean
	BetService betService;

	@MockBean
	RouletteService rouletteService;

	@Test
	public void testCreateRoulette() throws Exception {

		when(rouletteService.createRoulette()).thenReturn(1L);
		assertThat(rest.createRoulette()).isEqualTo(1L);
	}

	@Test
	public void testActivateRoulette() throws Exception {
		when(rouletteService.activateRoulette(1L)).thenReturn(new ResponseDTO(
				RouletteConstants.ROULETTE_CODE_RESPONSE_SUCCESS, RouletteConstants.ROULETTE_SUCCESS_MESSAGE));
		assertThat(rest.activateRoulette(1L).getResopnseCode())
				.isEqualTo(RouletteConstants.ROULETTE_CODE_RESPONSE_SUCCESS);

	}

	@Test
	public void testBetToRoulette() throws Exception {
		BetDTO bet = new BetDTO();
		assertThat(rest.betToRoulette(bet).getResopnseCode())
				.isEqualTo(RouletteConstants.ROULETTE_FAILED_RESPONSE_CODE);
		bet.setColor("rojo");
		when(betService.createBet(bet)).thenReturn(new ResponseDTO(RouletteConstants.ROULETTE_CODE_RESPONSE_SUCCESS,
				RouletteConstants.ROULETTE_SUCCESS_MESSAGE));
		assertThat(rest.betToRoulette(bet).getResopnseCode())
				.isEqualTo(RouletteConstants.ROULETTE_CODE_RESPONSE_SUCCESS);
	}

	@Test
	public void testCloseRoulette() throws Exception {
		when(betService.closeBet(1L)).thenReturn(new ArrayList<>());
		assertThat(rest.closeRoulette(1L)).isNotNull();

	}

	@Test
	public void testGetAllRoulettes() throws Exception {
		when(rouletteService.getAllRoulettes()).thenReturn(new ArrayList<>());
		assertThat(rest.getAllRoulettes()).isNotNull();
	}

}
