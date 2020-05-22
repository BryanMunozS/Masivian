package com.roulette.api.dto;

/**
 * This class is data transfer object of response
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class ResponseDTO {

	private int responseCode;
	private String responseMessage;

	public ResponseDTO() {

	}

	public ResponseDTO(int responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public int getResopnseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResopnseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
