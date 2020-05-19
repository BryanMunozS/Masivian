package com.ruleta.api.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruleta.api.model.Ruleta;
import com.ruleta.api.repository.RuletaRepository;
import com.util.api.dto.ApuestaDTO;
import com.util.api.dto.RuletaDTO;

/**
 * Clase con metodos asociados a las consultas
 * @author Bryan Muñoz
 * @version 1.0
 */
@Service
public class RuletaConsultarService {

	@Autowired
	RuletaRepository ruletaRepositorio;

	ModelMapper mapper = new ModelMapper();

	public List<RuletaDTO> obtenerTodasLasRuletas() {
		List<Ruleta> peticion = new ArrayList<>();
		ruletaRepositorio.findAll().forEach(peticion::add);
		Type type = new TypeToken<List<RuletaDTO>>() {
		}.getType();
		return mapper.map(peticion, type);

	}

	public List<ApuestaDTO> cierraDeApuestas(Long id) {
		Optional<Ruleta> optional = ruletaRepositorio.findById(id);
		if (optional.isPresent()) {
			Ruleta ruleta = optional.get();
			ruleta.setEstado(false);
			ruletaRepositorio.save(ruleta);
			Type type = new TypeToken<List<ApuestaDTO>>() {
			}.getType();
			return mapper.map(ruleta.getApuestas(), type);
		}
		return new ArrayList<>();
	}
}
