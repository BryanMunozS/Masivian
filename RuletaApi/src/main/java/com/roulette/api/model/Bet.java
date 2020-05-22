package com.roulette.api.model;

import org.springframework.data.redis.core.index.Indexed;

/**
 * This class allow save list of bets
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class Bet {

	@Indexed
	private Long idBet;
	private Long betsMoney;
	private String idUser;
	private String color;
	private Long number;

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
