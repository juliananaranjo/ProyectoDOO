package co.edu.uco.nese.business.business;

public interface UserBusiness {
	
	void registerNewUserInformation(UserDomain userDomain);
	
	void dropUserInformation(UUID id);
	
	void updateInformation(UUID id, UserDomain userDomain);
	
	List<UserDomain> find AllUSERS();
	
}
