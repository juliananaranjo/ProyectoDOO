package co.edu.uco.nese.crosscuting.messagescatalog;

import co.edu.uco.nese.crosscuting.helpers.TextHelper;

public enum MessagesEnum {
	
	USER_ERROR_SQLCONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada vacia", 
			"la conexion requerida para llevar a cabo la operacion contra la fuente de información deseada esta vacia."
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion."),
	
	
	TECNICAL_ERROR_SQLCONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada nula", 
			"la conexion requerida para llevar a cabo la operacion contra la base de datos llegó nula."),
	
	USER_ERROR_SQLCONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada", 
			"la conexion requerida para llevar a cabo la operacion contra la fuente de información deseada esta cerrada."
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion."),
	
	TECNICAL_ERROR_SQLCONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada", 
			"la conexion requerida para llevar a cabo la operacion contra la base de datos está  cerrada."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("problema inesperado validando el estado de la conexión contra la fuente de datos deseada", 
			"se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la operación contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion."),
	
	TECNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexion contra la base de datos estaba abierta", 
			"se presento un error de tipo SQLException al validar si la conexión contra la base de datos estaba o no abierta.Por favor valide la consola de errores para revisar con detalle el problema presentado.");
	
	private String title;
	private String content;
	
	private MessagesEnum(final String title, final String content) {
		setTitle(title);
		setContent(content);
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}

	public String getContent() {
		return content;
	}

	private void setContent(final String content) {
		this.content = TextHelper.getDefaultWithTrim(content);
	}
	
	

}
