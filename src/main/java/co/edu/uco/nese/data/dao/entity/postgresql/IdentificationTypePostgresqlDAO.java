package co.edu.uco.nese.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
	    var entities = new ArrayList<IdentificationTypeEntity>();
	    String sql = "SELECT id, nombre FROM public.\"TipoIdentificacion\""; // cuidado con el nombre exacto

	    try (var preparedStatement = getConnection().prepareStatement(sql);
	         var resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            var entity = new IdentificationTypeEntity();
	            entity.setId((UUID) resultSet.getObject("id"));
	            entity.setName(resultSet.getString("nombre"));
	            entities.add(entity);
	        }

	    } catch (SQLException exception) {
	        exception.printStackTrace();
	    }

	    return entities;
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