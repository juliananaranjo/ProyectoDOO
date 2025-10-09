package co.edu.uco.nese.data.dao.factory;

import java.sql.Connection;

import co.edu.uco.nese.data.dao.entity.CityDAO;
import co.edu.uco.nese.data.dao.entity.CountryDAO;
import co.edu.uco.nese.data.dao.entity.DepartmentDAO;
import co.edu.uco.nese.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nese.data.dao.entity.UserDAO;

public abstract class DAOFactory {
	
	protected Connection connection; 
	protected FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
	public static DAOFactory getFactory() {
		return null;
	}
	
	public abstract CityDAO getCityDAO();
	
	public abstract CountryDAO getCountryDAO();
	
	public abstract IdentificationTypeDAO getIdentificationTypeDAO();
	
	public abstract DepartmentDAO getDepartmentDAO();
	
	public abstract UserDAO getUserDAO();
	
	protected abstract void openConnection();
	
	protected final void initTransaction() {
		
	}
	
	protected final void commitTransaction() {
		
	}
	
	protected final void rollbackTransaction() {
		
	}
	
	protected final void closeConnection() {
	
	}

}