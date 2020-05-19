package com.ruleta.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruleta.api.model.Ruleta;
import com.ruleta.api.repository.RuletaRepository;
import com.ruleta.api.util.RuletaConstantes;
import com.util.api.dto.RespuestaDTO;

/**
 * Clase que tiene los metodos asociados con el modificar
 * 
 * @author Bryan Muñoz
 * @version 1.0
 *
 */
@Service
public class RuletaModificarService {

	@Autowired
	RuletaRepository ruletaRepositorio;

	public RespuestaDTO activarRuleta(Long id) {
		Optional<Ruleta> optional = ruletaRepositorio.findById(id);
		RespuestaDTO respuesta = new RespuestaDTO();
		if (optional.isPresent()) {
			Ruleta peticion = optional.get();
			if (!peticion.isEstado())
				peticion.setApuestas(null);
			peticion.setEstado(true);
			ruletaRepositorio.save(peticion);
			respuesta.setCodigoRespuesta(RuletaConstantes.RULETA_CODIGO_RESPUESTA_EXITOSO);
			respuesta.setMensajeRespuesta(RuletaConstantes.RULETA_MENSAJE_EXITOSO);
		} else {
			respuesta.setCodigoRespuesta(RuletaConstantes.RULETA_CODIGO_RESPUESTA_PETICION_FALLIDA);
			respuesta.setMensajeRespuesta(RuletaConstantes.RULETA_MENSAJE_DENEGADO);
		}
		return respuesta;
	}
}
