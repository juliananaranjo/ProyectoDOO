package co.edu.uco.nese.data.dao.factory.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.nese.crosscuting.exception.NeseException;
import co.edu.uco.nese.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nese.data.dao.entity.CityDAO;
import co.edu.uco.nese.data.dao.entity.CountryDAO;
import co.edu.uco.nese.data.dao.entity.DepartmentDAO;
import co.edu.uco.nese.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nese.data.dao.entity.UserDAO;
import co.edu.uco.nese.data.dao.entity.postgresql.CityPostgresqlDAO;
import co.edu.uco.nese.data.dao.entity.postgresql.CountryPostgresqlDAO;
import co.edu.uco.nese.data.dao.entity.postgresql.DepartmentPostgresqlDAO;
import co.edu.uco.nese.data.dao.entity.postgresql.IdentificationTypePostgresqlDAO;
import co.edu.uco.nese.data.dao.entity.postgresql.UserPostgresqlDAO;
import co.edu.uco.nese.data.dao.factory.DAOFactory;

public final class PostgresqlDAOFactory extends DAOFactory {
	
	public PostgresqlDAOFactory() {
		openConnection();
	}
	
	@Override
	protected void openConnection() {
	    try {
	        String url = "jdbc:postgresql://localhost:5432/DOO"; 
	        String user = "postgres";
	        String password = "jorgealpidio1442"; 

	        Class.forName("org.postgresql.Driver");

	        this.connection = DriverManager.getConnection(url, user, password);

	    } catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_OPENING_CONNECTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPENING_CONNECTION.getContent();
	        throw NeseException.create(exception, userMessage, technicalMessage);

	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION.getContent();
	        throw NeseException.create(exception, userMessage, technicalMessage);
	    }
	}

	@Override
	public CityDAO getCityDAO() {
		return new CityPostgresqlDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountryPostgresqlDAO(connection);
	}

	@Override
	public IdentificationTypeDAO getIdentificationTypeDAO() {
		return new IdentificationTypePostgresqlDAO(connection);
	}

	@Override
	public DepartmentDAO getDepartmentDAO() {
		return new DepartmentPostgresqlDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserPostgresqlDAO(connection);
	}


}