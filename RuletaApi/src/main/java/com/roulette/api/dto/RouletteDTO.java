package com.roulette.api.dto;

/**
 * This class is data transfer object of roulette
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class RouletteDTO extends ResponseDTO {

	private Long idRoulette;
	private boolean status;

	public Long getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(Long idRuleta) {
		this.idRoulette = idRuleta;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
