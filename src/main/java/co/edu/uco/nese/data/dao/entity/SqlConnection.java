package co.edu.uco.nese.data.dao.entity;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.nese.crosscuting.exception.NeseException;
import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.messagescatalog.MessagesEnum;

public abstract class SqlConnection {
	
	private Connection connection;
	
	protected SqlConnection(final Connection connection) {
		setConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(final Connection connection) {
		if(ObjectHelper.isNull(connection)) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_IS_EMPTY.getContent();
			var technicalMessage = MessagesEnum.TECNICAL_ERROR_SQLCONNECTION_IS_EMPTY.getContent();
			throw NeseException.create(userMessage, technicalMessage);
		}
		
		try {
			if (connection.isClosed()) {
				var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_IS_CLOSED.getContent();
				var technicalMessage = MessagesEnum.TECNICAL_ERROR_SQLCONNECTION_IS_CLOSED.getContent();
				throw NeseException.create(userMessage, technicalMessage);
			}
	
		} catch (SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			var technicalMessage = MessagesEnum.TECNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			throw NeseException.create(exception, userMessage, technicalMessage);
		}
		
		this.connection = connection;
	}
	
}
