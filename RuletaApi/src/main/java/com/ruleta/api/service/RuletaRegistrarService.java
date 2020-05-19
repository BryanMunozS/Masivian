package com.ruleta.api.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruleta.api.model.Apuesta;
import com.ruleta.api.model.Ruleta;
import com.ruleta.api.repository.RuletaRepository;
import com.ruleta.api.util.RuletaConstantes;
import com.util.api.dto.ApuestaDTO;
import com.util.api.dto.RespuestaDTO;

/**
 * Clase que contiene los metodos de registrar
 * 
 * @author Bryan Muñoz
 * @version 1.0
 *
 */
@Service
public class RuletaRegistrarService {

	@Autowired
	RuletaRepository ruletaRepositorio;

	@Autowired
	HttpServletRequest request;

	ModelMapper mapper = new ModelMapper();

	public Long crearRuleta() {
		Ruleta peticion = new Ruleta(null, false);
		Ruleta respuesta = ruletaRepositorio.save(peticion);
		return respuesta.getIdRuleta();
	}

	public RespuestaDTO crearApuesta(ApuestaDTO peticion) {
		boolean estadoRuleta = comprobarRuleta(peticion.getIdRuleta());
		RespuestaDTO respuesta = new RespuestaDTO();
		if (estadoRuleta && peticion.getDineroDeApuesta() != null && peticion.getDineroDeApuesta() > 0
				&& peticion.getDineroDeApuesta() <= 10000) {
			respuesta = guardarApuesta(peticion);
		} else {
			respuesta.setCodigoRespuesta(RuletaConstantes.RULETA_CODIGO_RESPUESTA_PETICION_FALLIDA);
			respuesta.setMensajeRespuesta(RuletaConstantes.RULETA_MENSAJE_DENEGADO);
		}
		return respuesta;
	}

	private RespuestaDTO guardarApuesta(ApuestaDTO peticion) {
		Ruleta ruleta = ruletaRepositorio.findById(peticion.getIdRuleta()).get();
		Apuesta apuesta = mapper.map(peticion, Apuesta.class);
		if (peticion.getColor() != null) {
			peticion.setNumeros(null);
		} else {
			peticion.setColor(null);
		}
		ruleta.agregarApuesta(apuesta);
		ruletaRepositorio.save(ruleta);
		return new RespuestaDTO(RuletaConstantes.RULETA_CODIGO_RESPUESTA_EXITOSO,
				RuletaConstantes.RULETA_MENSAJE_EXITOSO);
	}

	private boolean comprobarRuleta(Long idRuleta) {
		Optional<Ruleta> optional = ruletaRepositorio.findById(idRuleta);
		if (optional.isPresent()) {
			if (optional.get().isEstado()) {
				return true;
			}
		}
		return false;
	}

}
