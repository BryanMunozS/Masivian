package com.ruleta.api.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.util.api.dto.ApuestaDTO;

/**
 * Clase prueba de validador
 * 
 * @author Bryan Muñoz
 *
 */
public class RuletaValidadorTest {

	@Test
	public void testValidarApuesta() throws Exception {
		ApuestaDTO peticion = new ApuestaDTO();
		assertThat(RuletaValidador.validarApuesta(peticion)).isEqualTo(false);
		peticion.setNumeros(10L);
		assertThat(RuletaValidador.validarApuesta(peticion)).isEqualTo(true);
		peticion.setColor("rojo");
		assertThat(RuletaValidador.validarApuesta(peticion)).isEqualTo(true);

	}

}
