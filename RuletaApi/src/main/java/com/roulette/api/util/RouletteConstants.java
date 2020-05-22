package com.roulette.api.util;

/**
 * This class allows of constants
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class RouletteConstants {

	private RouletteConstants() {
	}

	/*
	 * Url's
	 */
	public static final String ROULETTE_REST_CONTROLLER_CREATE_ROULETTE = "/create/roulette";
	public static final String ROULETTE_REST_CONTROLLER_OPEN_ROULETTE = "/open_roulette/";
	public static final String ROULETTE_REST_CONTROLLER_ROULETTE_BET = "/create_bet";
	public static final String ROULETTE_REST_CONTROLLER_CLOSE_ROULETTE = "/close_roulette";
	public static final String ROULETTE_REST_CONTROLLER_GET_ALL_ROULETTES = "/get_all_roulettes";
	/*
	 * Response code
	 */
	public static final int ROULETTE_CODE_RESPONSE_SUCCESS = 200;
	public static final int ROULETTE_FAILED_RESPONSE_CODE = 400;
	public static final int ROULETTE_CODIGO_RESPUESTA_SERVER_INTERNAL_ERROR = 500;

	/*
	 * Response Messages
	 */
	public static final String ROULETTE_SUCCESS_MESSAGE = "exitoso";
	public static final String RULETA_MENSAJE_DENEGADO = "denegado";

	/*
	 * Validator message
	 */
	public static final String ROULETTE_VALIDATOR_MESSAGE = "Apuesta equivocada";

	/*
	 * Headers
	 */
	public static final String ROULETTE_HEADERS_ID_USER = "idUsuario";
}
