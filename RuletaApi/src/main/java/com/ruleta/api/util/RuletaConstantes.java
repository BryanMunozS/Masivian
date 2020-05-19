package com.ruleta.api.util;

/**
 * Clase que contiene las constantes de la aplicación
 * 
 * @author Bryan Muñoz
 * @version 1.0
 */
public class RuletaConstantes {

	private RuletaConstantes() {
	}

	/*
	 * Direccionamiento de peticiones
	 */
	public static final String RULETA_REST_CONTROLLER_CREAR_RULETA = "/crear/ruleta";
	public static final String RULETA_REST_CONTROLLER_APERTURA_RULETA = "/apertura_ruleta/";
	public static final String RULETA_REST_CONTROLLER_APUESTA_RULETA = "/crear_apuesta";
	public static final String RULETA_REST_CONTROLLER_CIERRE_RULETA = "/cierre_ruleta";
	public static final String RULETA_REST_CONTROLLER_RULETA_OBTENER_TODOS = "/ruleta_obtener_todos";
	/*
	 * Mensajes de respuesta de las peticiones
	 */
	public static final int RULETA_CODIGO_RESPUESTA_EXITOSO = 200;
	public static final int RULETA_CODIGO_RESPUESTA_PETICION_FALLIDA = 400;
	public static final int RULETA_CODIGO_RESPUESTA_ERROR_INTERNO_SERVIDOR = 500;

	/*
	 * Mensajes de respuesta
	 */
	public static final String RULETA_MENSAJE_EXITOSO = "exitoso";
	public static final String RULETA_MENSAJE_DENEGADO = "denegado";

	/*
	 * Validacion campos
	 */
	public static final String RULETA_MENSAJE_VALIDAR_APUESTA = "Apuesta equivocada";
	
	/*
	 * 
	 */
	public static final String RULETA_HEADERS_ID_USUARIO="idUsuario";
}
