package co.edu.uco.nese.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nese.data.dao.entity.CityDAO;
import co.edu.uco.nese.data.dao.entity.SqlConnection;
import co.edu.uco.nese.entity.CityEntity;

public final class CityPostgresqlDAO extends SqlConnection implements CityDAO{

	
	public CityPostgresqlDAO(final Connection connection) {
		super(connection);
	}
	@Override
	public List<CityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
