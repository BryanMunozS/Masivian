package com.ruleta.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ruleta.api.model.Ruleta;
import com.ruleta.api.repository.RuletaRepository;
import com.util.api.dto.ApuestaDTO;

/**
 * Clase prueba de registrar ruleta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RuletaRegistrarServiceTest {

	@Autowired
	RuletaRegistrarService registrar;

	@MockBean
	RuletaRepository ruletaRepositorio;

	@Mock
	ModelMapper mapper;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testCrearRuleta() throws Exception {
//		Ruleta peticion = spy(Ruleta.class);
//		when(ruletaRepositorio.save(peticion)).thenReturn(new Ruleta(1L, false));
//		assertThat(registrar.crearRuleta()).isNull();

	}

	@Test
	public void testCrearApuesta() throws Exception {
		ApuestaDTO peticion = new ApuestaDTO();
		peticion.setIdRuleta(1L);
		peticion.setDineroDeApuesta(100L);
		peticion.setNumeros(3L);
		Ruleta ruleta = new Ruleta(1L, true);
		ruleta.setApuestas(new ArrayList<>());
		assertThat(registrar.crearApuesta(peticion)).isNotNull();
		Optional<Ruleta> optional = Optional.of(ruleta);
		when(ruletaRepositorio.findById(1L)).thenReturn(optional);
		when(ruletaRepositorio.save(ruleta)).thenReturn(ruleta);
		assertThat(registrar.crearApuesta(peticion).getCodigoRespuesta()).isEqualTo(200);

	}

}
