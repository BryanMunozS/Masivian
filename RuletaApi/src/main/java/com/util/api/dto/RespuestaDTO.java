package com.util.api.dto;

/**
 * Dto que permite responder un codigo y mensaje de respuesta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class RespuestaDTO {

	private int codigoRespuesta;
	private String mensajeRespuesta;

	public RespuestaDTO() {

	}

	public RespuestaDTO(int codigoRespuesta, String mensajeRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

}
