package com.ruleta.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ruleta.api.model.Ruleta;
import com.ruleta.api.repository.RuletaRepository;
import com.ruleta.api.util.RuletaConstantes;

/**
 * Prueba del servicio modificar de ruleta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RuletaModificarServiceTest {

	@Autowired
	RuletaModificarService modificar;
	@MockBean
	RuletaRepository ruletaRepositorio;

	@Test
	public void testActivarRuleta() throws Exception {
		assertThat(modificar.activarRuleta(1L).getCodigoRespuesta())
				.isEqualTo(RuletaConstantes.RULETA_CODIGO_RESPUESTA_PETICION_FALLIDA);
		Optional<Ruleta> optional = Optional.of(new Ruleta());
		when(ruletaRepositorio.findById(1L)).thenReturn(optional);
		when(ruletaRepositorio.save(new Ruleta())).thenReturn(new Ruleta());
		assertThat(modificar.activarRuleta(1L).getCodigoRespuesta())
				.isEqualTo(RuletaConstantes.RULETA_CODIGO_RESPUESTA_EXITOSO);

	}

}
