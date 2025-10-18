package co.edu.uco.nese.business.business;

import co.edu.uco.nese.business.business;
import co.edu.uco.nese.data.dao.factory.DAOFactory;
import co.edu.uco.nese.data.dao.factory.DAOFactory;


public class UserBusinessImpl implements UserBusiness {
	
	private DAOFactory daoFactory;
	
	public UserBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
		this.DAOFACTORY = daoFactory;
		
	}

	@Override
	public void registerNewUserInformation(UserDomain userDomain) {
		var id= UUIHelper().generateNewUUID();
		var UserEntity = UserAssembler.getUserAssembler().toEntity(userDomain);
		
		UserEntity.setId(id);
		
		daoFactory.getUserDAO().create(null);
		
	}

	@Override
	public void dropUserInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInformation(UUID id, UserDomain userDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AllUSERS() {
		// TODO Auto-generated method stub
		
	}
	
	public UUID generateNewUUID() {
		return UUID.randomUUID();
	}
	
	

}
