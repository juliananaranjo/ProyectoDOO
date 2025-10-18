package co.edu.uco.nese.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nese.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nese.data.dao.entity.SqlConnection;
import co.edu.uco.nese.entity.IdentificationTypeEntity;

public final class IdentificationTypePostgresqlDAO extends SqlConnection implements IdentificationTypeDAO {
	
	public IdentificationTypePostgresqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<IdentificationTypeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdentificationTypeEntity> findByFilter(IdentificationTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentificationTypeEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
