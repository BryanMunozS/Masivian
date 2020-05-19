package com.ruleta.api.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ruleta.api.service.RuletaConsultarService;
import com.ruleta.api.service.RuletaModificarService;
import com.ruleta.api.service.RuletaRegistrarService;
import com.ruleta.api.util.RuletaConstantes;
import com.util.api.dto.ApuestaDTO;
import com.util.api.dto.RespuestaDTO;

/**
 * Clase prueba del restController de ruleta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RuletaRestTest {

	@Autowired
	RuletaRest rest;
	@MockBean
	RuletaRegistrarService registrar;
	@MockBean
	RuletaModificarService modificar;
	@MockBean
	RuletaConsultarService consultar;

	@Test
	public void testCrearRuleta() throws Exception {

		when(registrar.crearRuleta()).thenReturn(1L);
		assertThat(rest.crearRuleta()).isEqualTo(1L);
	}

	@Test
	public void testActivarRuleta() throws Exception {
		when(modificar.activarRuleta(1L)).thenReturn(new RespuestaDTO(RuletaConstantes.RULETA_CODIGO_RESPUESTA_EXITOSO,
				RuletaConstantes.RULETA_MENSAJE_EXITOSO));
		assertThat(rest.activarRuleta(1L).getCodigoRespuesta())
				.isEqualTo(RuletaConstantes.RULETA_CODIGO_RESPUESTA_EXITOSO);

	}

	@Test
	public void testApostarRuleta() throws Exception {
		ApuestaDTO apuesta = new ApuestaDTO();
		assertThat(rest.apostarRuleta(apuesta).getCodigoRespuesta())
				.isEqualTo(RuletaConstantes.RULETA_CODIGO_RESPUESTA_PETICION_FALLIDA);
		apuesta.setColor("rojo");
		when(registrar.crearApuesta(apuesta)).thenReturn(new RespuestaDTO(
				RuletaConstantes.RULETA_CODIGO_RESPUESTA_EXITOSO, RuletaConstantes.RULETA_MENSAJE_EXITOSO));
		assertThat(rest.apostarRuleta(apuesta).getCodigoRespuesta())
				.isEqualTo(RuletaConstantes.RULETA_CODIGO_RESPUESTA_EXITOSO);
	}

	@Test
	public void testCerrarRuletaConResultados() throws Exception {
		when(consultar.cierraDeApuestas(1L)).thenReturn(new ArrayList<>());
		assertThat(rest.cerrarRuletaConResultados(1L)).isNotNull();

	}

	@Test
	public void testObtenerTodasLasRuletas() throws Exception {
		when(consultar.obtenerTodasLasRuletas()).thenReturn(new ArrayList<>());
		assertThat(rest.obtenerTodasLasRuletas()).isNotNull();
	}

}
