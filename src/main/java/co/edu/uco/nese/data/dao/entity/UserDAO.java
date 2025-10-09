package co.edu.uco.nese.data.dao.entity;

import java.util.UUID;

import co.edu.uco.nese.data.dao.CreateDAO;
import co.edu.uco.nese.data.dao.DeleteDAO;
import co.edu.uco.nese.data.dao.RetrieveDAO;
import co.edu.uco.nese.data.dao.UpdateDAO;
import co.edu.uco.nese.entity.UserEntity;

public interface UserDAO 
		extends CreateDAO<UserEntity>, 
				RetrieveDAO<UserEntity, UUID>, 
				UpdateDAO<UserEntity>,
				DeleteDAO<UUID>{
}
