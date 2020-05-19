package com.ruleta.api.model;

import org.springframework.data.redis.core.index.Indexed;

/**
 * Esta clase representa la lista de apuesta
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class Apuesta {

	@Indexed
	private Long idApuesta;
	private Long dineroDeApuesta;
	private String idUsuario;
	private String color;
	private Long numeros;

	public Long getIdApuesta() {
		return idApuesta;
	}

	public void setIdApuesta(Long idApuesta) {
		this.idApuesta = idApuesta;
	}

	public Long getDineroDeApuesta() {
		return dineroDeApuesta;
	}

	public void setDineroDeApuesta(Long dineroDeApuesta) {
		this.dineroDeApuesta = dineroDeApuesta;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getNumeros() {
		return numeros;
	}

	public void setNumeros(Long numeros) {
		this.numeros = numeros;
	}

}
