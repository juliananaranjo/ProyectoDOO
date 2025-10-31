package co.edu.uco.nese.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nese.business.domain.UserDomain;

public interface UserBusiness {
	
	void registerNewUserInformation(UserDomain userDomain);
	
	void dropUserInformation(UUID id);
	
	void updateUserInformation(UUID id, UserDomain userDomain);
	
	List<UserDomain> findAllUsers();
	
	List<UserDomain> findUsersByFilter(UserDomain userFilters);
	
	UserDomain findSpecificUser(UUID id);

	void confirmPhoneNumber(UUID id, int confirmationCode);
	
	void confirmEmail(UUID id, int confirmationCode);
	
	void sendPhoneNumberConfirmation(UUID id);
	
	void sendEmailConfirmation(UUID id);
	
}