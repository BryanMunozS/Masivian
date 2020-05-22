package com.roulette.api.util;

import com.roulette.api.dto.BetDTO;

/**
 * Validation of roulette
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class RouletteValidator {

	private RouletteValidator() {
		super();
	}

	public static boolean validateBet(BetDTO request) {
		if (request.getColor() != null
				&& (request.getColor().equalsIgnoreCase("rojo") || request.getColor().equalsIgnoreCase("negro"))) {
			return true;
		}
		if (request.getNumber() != null && request.getNumber() >= 0 && request.getNumber() <= 36) {
			return true;
		}
		return false;
	}
}
