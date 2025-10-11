package co.edu.uco.nese.data.dao.factory;

import java.sql.Connection;

import co.edu.uco.nese.crosscuting.exception.NeseException;
import co.edu.uco.nese.data.dao.entity.CityDAO;
import co.edu.uco.nese.data.dao.entity.CountryDAO;
import co.edu.uco.nese.data.dao.entity.DepartmentDAO;
import co.edu.uco.nese.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nese.data.dao.entity.UserDAO;
import co.edu.uco.nese.data.dao.factory.postgresql.PostgresqlDAOFactory;

public abstract class DAOFactory {
	
	protected Connection connection; 
	protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
	public static DAOFactory getFactory() {
		switch (factory) {
		case POSTGRESQL:
			return new PostgresqlDAOFactory();
		default:
			var userMessage ="Factoria no iniciada";
			var technicalMessage ="Factoria no valida";
			throw NeseException.create(userMessage, technicalMessage);
		}
	}
	
	public abstract CityDAO getCityDAO();
	
	public abstract CountryDAO getCountryDAO();
	
	public abstract IdentificationTypeDAO getIdentificationTypeDAO();
	
	public abstract DepartmentDAO getDepartmentDAO();
	
	public abstract UserDAO getUserDAO();
	
	protected abstract void openConnection();
	
	protected final void initTransaction() {
		sqlConnectionHelper.ensureTransactionIsNotStarted(connection);
		
		try {
			Connection.rolback();
		}cach(final SQLException exception){
			var userMessage ="";
			var technicalMessage ="";
			throw NeseException.create(exception, userMessage, technicalMessage);
			
		}catch(final Exception exception){
			var userMessage ="";
			var technicalMessage ="";
			throw NeseException.create(exception, userMessage, technicalMessage);
		}
		
		
	}
	
	protected final void commitTransaction() {
		
	}
	
	protected final void rollbackTransaction() {
		
	}
	
	protected final void closeConnection() {
	
	}

}