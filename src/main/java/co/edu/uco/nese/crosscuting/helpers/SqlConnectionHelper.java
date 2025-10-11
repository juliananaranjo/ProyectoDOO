package co.edu.uco.nese.crosscuting.helpers;

public class SqlConnectionHelper {
	
	public static void ensureTransactionIsStarted(final java.sql.Connection connection) {
		try {
			if (connection.getAutoCommit()) {
				connection.setAutoCommit(false);
			}
		} catch (final java.sql.SQLException exception) {
			var userMessage = "Se ha presentado un problema al intentar iniciar la transaccion de la conexion a la base de datos";
			var technicalMessage = "Se ha presentado un problema al intentar iniciar la transaccion de la conexion a la base de datos: "
					+ exception.getMessage();
			throw co.edu.uco.nese.crosscuting.exception.NeseException.create(exception, userMessage, technicalMessage);
		}
	}

	public static void ensureTransactionIsNotStarted(final java.sql.Connection connection) {
		try {
			if (!connection.getAutoCommit()) {
				var userMessage = "La transaccion de la conexion a la base de datos ya ha sido iniciada";
				var technicalMessage = "La transaccion de la conexion a la base de datos ya ha sido iniciada, por favor verifique el flujo de su aplicacion";
				throw co.edu.uco.nese.crosscuting.exception.NeseException.create(userMessage, technicalMessage);
			}
		} catch (final java.sql.SQLException exception) {
			var userMessage = "Se ha presentado un problema al intentar validar el estado de la transaccion de la conexion a la base de datos";
			var technicalMessage = "Se ha presentado un problema al intentar validar el estado de la transaccion de la conexion a la base de datos: "
					+ exception.getMessage();
			throw co.edu.uco.nese.crosscuting.exception.NeseException.create(exception, userMessage, technicalMessage);
		}
		
	

}
