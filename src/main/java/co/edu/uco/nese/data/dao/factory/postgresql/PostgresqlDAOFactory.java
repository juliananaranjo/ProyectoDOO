package co.edu.uco.nese.data.dao.factory.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.nese.crosscuting.exception.NeseException;
import co.edu.uco.nese.data.dao.entity.CityDAO;
import co.edu.uco.nese.data.dao.entity.CountryDAO;
import co.edu.uco.nese.data.dao.entity.DepartmentDAO;
import co.edu.uco.nese.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nese.data.dao.entity.UserDAO;
import co.edu.uco.nese.data.dao.entity.postgresql.UserPostgresqlDAO;
import co.edu.uco.nese.data.dao.factory.DAOFactory;

public final class PostgresqlDAOFactory extends DAOFactory {
		
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
		// TODO Auto-generated method stub
		return new IdentificationTypePostgresqlDAO(connection);
	}

	@Override
	public DepartmentDAO getDepartmentDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return new UserPostgresqlDAO(connection);
	}

	@Override
	protected void openConnection() {
		try {
			this.connection = DriverManager.getConnection("");
			
		}catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
			var tecnicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
		}catch(final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
		}
	}

}
