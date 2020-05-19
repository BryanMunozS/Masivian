package com.util.api.dto;

/**
 * Clase que permite la transferencia de datos de la clase ruleta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class RuletaDTO extends RespuestaDTO {

	private Long idRuleta;
	private boolean estado;

	public Long getIdRuleta() {
		return idRuleta;
	}

	public void setIdRuleta(Long idRuleta) {
		this.idRuleta = idRuleta;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
