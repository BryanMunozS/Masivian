package com.ruleta.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruleta.api.service.RuletaConsultarService;
import com.ruleta.api.service.RuletaModificarService;
import com.ruleta.api.service.RuletaRegistrarService;
import com.ruleta.api.util.RuletaConstantes;
import com.ruleta.api.util.RuletaValidador;
import com.util.api.dto.ApuestaDTO;
import com.util.api.dto.RespuestaDTO;
import com.util.api.dto.RuletaDTO;

/**
 * Clase rest que expone endpoint's por medio de peticiones
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
@RestController
public class RuletaRest {

	@Autowired
	RuletaRegistrarService registrar;

	@Autowired
	RuletaConsultarService consultar;

	@Autowired
	RuletaModificarService modificar;

	@GetMapping(RuletaConstantes.RULETA_REST_CONTROLLER_CREAR_RULETA)
	public Long crearRuleta() {

		return registrar.crearRuleta();
	}

	@PutMapping(RuletaConstantes.RULETA_REST_CONTROLLER_APERTURA_RULETA)
	public RespuestaDTO activarRuleta(@RequestParam("id") Long id) {
		return modificar.activarRuleta(id);
	}

	@PostMapping(RuletaConstantes.RULETA_REST_CONTROLLER_APUESTA_RULETA)
	public RespuestaDTO apostarRuleta(@RequestBody ApuestaDTO peticion) {
		boolean resultado = RuletaValidador.validarApuesta(peticion);
		RespuestaDTO respuesta = new RespuestaDTO();
		if (resultado) {
			respuesta = registrar.crearApuesta(peticion);
		} else {
			respuesta.setCodigoRespuesta(RuletaConstantes.RULETA_CODIGO_RESPUESTA_PETICION_FALLIDA);
			respuesta.setMensajeRespuesta(RuletaConstantes.RULETA_MENSAJE_VALIDAR_APUESTA);
		}
		return respuesta;
	}

	@GetMapping(RuletaConstantes.RULETA_REST_CONTROLLER_CIERRE_RULETA)
	public List<ApuestaDTO> cerrarRuletaConResultados(@RequestParam("ruleta") Long idRuleta) {
		return consultar.cierraDeApuestas(idRuleta);
	}

	@GetMapping(RuletaConstantes.RULETA_REST_CONTROLLER_RULETA_OBTENER_TODOS)
	public List<RuletaDTO> obtenerTodasLasRuletas() {
		return consultar.obtenerTodasLasRuletas();
	}
}
