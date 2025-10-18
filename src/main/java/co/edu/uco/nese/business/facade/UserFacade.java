package co.edu.uco.nese.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nese.dto.UserDTO;

public interface UserFacade {
	
	void registerNewUserInformation(UserDTO userDTO);
	
	void dropUserInformation(UUID id);
	
	void updateUserInformation(UUID id, UserDTO userDTO);
	
	List<UserDTO> findAllUsers();
	
	List<UserDTO> findUsersByFilter(UserDTO userDTO);
	
	UserDTO findSpecificUser(UUID id);
}
