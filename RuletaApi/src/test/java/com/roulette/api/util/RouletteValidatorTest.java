package com.roulette.api.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.roulette.api.dto.BetDTO;
import com.roulette.api.util.RouletteValidator;

/**
 * Roulette validator test class
 * 
 * @author Bryan Muñoz
 *
 */
public class RouletteValidatorTest {

	@Test
	public void testValidateBet() throws Exception {
		BetDTO request = new BetDTO();
		assertThat(RouletteValidator.validateBet(request)).isEqualTo(false);
		request.setNumber(10L);
		assertThat(RouletteValidator.validateBet(request)).isEqualTo(true);
		request.setColor("rojo");
		assertThat(RouletteValidator.validateBet(request)).isEqualTo(true);

	}

}
