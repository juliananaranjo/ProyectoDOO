package co.edu.uco.nese.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nese.data.dao.entity.CountryDAO;
import co.edu.uco.nese.data.dao.entity.SqlConnection;
import co.edu.uco.nese.entity.CountryEntity;

public final class CountryPostgresqlDAO extends SqlConnection implements CountryDAO {
	
	public CountryPostgresqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<CountryEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> findByFilter(CountryEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
