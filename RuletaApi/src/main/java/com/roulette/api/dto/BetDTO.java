package com.roulette.api.dto;

/**
 * This class is data transfer object of bet
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class BetDTO extends ResponseDTO {

	private Long idRoulette;
	private Long idBet;
	private Long betsMoney;
	private String idUser;
	private String color;
	private Long number;

	public Long getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(Long idRoulette) {
		this.idRoulette = idRoulette;
	}

	public Long getIdBet() {
		return idBet;
	}

	public void setIdBet(Long idBet) {
		this.idBet = idBet;
	}

	public Long getBetsMoney() {
		return betsMoney;
	}

	public void setBetsMoney(Long betsMoney) {
		this.betsMoney = betsMoney;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

}
