package com.ruleta.api.service;

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

import com.ruleta.api.model.Ruleta;
import com.ruleta.api.repository.RuletaRepository;

/**
 * Clase prueba modificar asociado con ruleta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RuletaConsultarServiceTest {

	@Autowired
	RuletaConsultarService consultar;
	@MockBean
	RuletaRepository ruletaRepositorio;

	@Test
	public void testObtenerTodasLasRuletas() throws Exception {
		Ruleta ruleta = new Ruleta();
		when(ruletaRepositorio.findAll()).thenReturn(Arrays.asList(ruleta));
		assertThat(consultar.obtenerTodasLasRuletas()).isNotNull();
	}

	@Test
	public void testCierraDeApuestas() throws Exception {
		Ruleta ruleta = new Ruleta();
		Optional<Ruleta> optional = Optional.of(ruleta);
		when(ruletaRepositorio.findById(1L)).thenReturn(optional);
		when(ruletaRepositorio.save(ruleta)).thenReturn(ruleta);
		assertThat(consultar.cierraDeApuestas(1L)).isNotNull();

	}

}
