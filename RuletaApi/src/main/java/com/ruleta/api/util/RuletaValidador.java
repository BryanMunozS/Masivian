package com.ruleta.api.util;

import com.util.api.dto.ApuestaDTO;

/**
 * Validar de ruleta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class RuletaValidador {

	private RuletaValidador() {
		super();
	}

	public static boolean validarApuesta(ApuestaDTO peticion) {
		if (peticion.getColor() != null
				&& (peticion.getColor().equalsIgnoreCase("rojo") || peticion.getColor().equalsIgnoreCase("negro"))) {
			return true;
		}
		if (peticion.getNumeros() != null && peticion.getNumeros() >= 0 && peticion.getNumeros() <= 36) {
			return true;
		}
		return false;
	}
}
