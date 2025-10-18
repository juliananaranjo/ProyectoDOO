package co.edu.uco.nese.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nese.business.business.UserBusinessImpl;
import co.edu.uco.nese.business.facade.UserFacade;
import co.edu.uco.nese.crosscuting.exception.NeseException;
import co.edu.uco.nese.data.dao.factory.DAOFactory;
import co.edu.uco.nese.dto.UserDTO;

public class UserFacadeImpl implements UserFacade {

	@Override
	public void registerNewUserInformation(final UserDTO userDTO) {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		try {
			daoFactory.initTransaction();
			var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDTO);
			business.registerNewUserInformation(domain);
			daoFactory.commitTransaction();
			
		} catch (final NeseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = "Se ha presentado un problema inesperado al intentar registrar la información del usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema.";
			var technicalMessage = "Se ha presentado una excepción no controlada al registrar la información del usuario. ";
			throw NeseException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void dropUserInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findUsersByFilter(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findSpecificUser(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
