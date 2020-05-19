package com.ruleta.api.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Tabla hash que se almacena en la BD
 * 
 * @author Bryan Muñoz
 * @version 1.0
 *
 */
@RedisHash("Ruleta")
public class Ruleta {

	@Id
	private Long idRuleta;
	private boolean estado;
	private List<Apuesta> apuestas;

	public Ruleta() {
		apuestas = new ArrayList<>();
	}

	public Ruleta(Long idRuleta, boolean estado) {
		this.idRuleta = idRuleta;
		this.estado = estado;
	}

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

	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}

	public void agregarApuesta(Apuesta apuesta) {
		this.apuestas.add(apuesta);
	}

}
