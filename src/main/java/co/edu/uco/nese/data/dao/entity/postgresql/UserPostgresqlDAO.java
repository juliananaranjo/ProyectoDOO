package co.edu.uco.nese.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nese.data.dao.entity.SqlConnection;
import co.edu.uco.nese.data.dao.entity.UserDAO;
import co.edu.uco.nese.entity.UserEntity;

public class UserPostgresqlDAO extends SqlConnection implements UserDAO {
	
	public UserPostgresqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(UserEntity entity) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new String Builder();
		sql.append("INSERT INTO public.user( ");
		sql.append("id, first_name, second_name, first_surname, second_surname, email, phone, identification_number, identification_type, birth_date, city, active) ");
		
		try (var preparedStatement = getConnection().prepareStatement(sql.toString())){
			
			
		preparedStatement.setObject(1, entity.getId());
		preparedStatement.setObject(2, entity.getFirstName());
		preparedStatement.setObject(3, entity.getSecondNumber());
		preparedStatement.setObject(4, entity.getFirstSurname());
		preparedStatement.setObject(5, entity.getSecondSurname());
		preparedStatement.setObject(6, entity.getEmail());
		preparedStatement.setObject(7, entity.getPhone());
		preparedStatement.setObject(8, entity.getIdentificationNumber());
		preparedStatement.setObject(9, entity.getIdentificationType());
		preparedStatement.setObject(10, entity.getBirthDate());
		preparedStatement.setObject(11, entity.getCity());
		preparedStatement.setObject(12, entity.isActive());
		
		preparedStatement.executeUpdate();
		
	}catch (final SQLException exception) {
		var userMessage = "";
		var technicalMessage = "";
		throw NeseException.create(exception, userMessage, technicalMessage);

	@Override
	public List<UserEntity> findAll() {
		
		final var sql = new StringBuilder();
		sql.append("SELECT id, first_name, second_name, first_surname, second_surname, email, phone, identification_number, identification_type, birth_date, city, active ");
		sql.append("FROM public.user; ");
		
		try (var preparedStatement = getConnection().prepareStatement(sql.toString())){
			try (var resultSet = preparedStatement.executeQuery()){
				var results = new ArrayList<UserEntity>();
				
				while (resultSet.next()) {
					final var userEntity = new UserEntity();
					userEntity.setId((UUID) resultSet.getObject("id"));
					userEntity.setFirstName(resultSet.getString("first_name"));
					userEntity.setSecondName(resultSet.getString("second_name"));
					userEntity.setFirstSurname(resultSet.getString("first_surname"));
					userEntity.setSecondSurname(resultSet.getString("second_surname"));
					userEntity.setEmail(resultSet.getString("email"));
					userEntity.setPhone(resultSet.getString("phone"));
					userEntity.setIdentificationNumber(resultSet.getString("identification_number"));
					userEntity.setIdentificationType(resultSet.getString("identification_type"));
					userEntity.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
					userEntity.setCity((UUID) resultSet.getObject("city"));
					userEntity.setActive(resultSet.getBoolean("active"));
					
					results.add(userEntity);
				}
				
				return results;
			}
		}catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filterEntity) {
		
		final var sql = new StringBuilder();
		sql.append("SELECT id, first_name, second_name, first_surname, second_surname, email, phone, identification_number, identification_type, birth_date, city, active ");
		sql.append("FROM public.user ");
		sql.append("WHERE 1=1 ");
		
	}

	@Override
	public UserEntity findByID(final UUID id) {
		var user = new UserEntity();
		
		final var sql = new StringBuilder();
		sql.append("SELECT id, first_name, second_name, first_surname, second_surname, email, phone, identification_number, identification_type, birth_date, city, active ");
		sql.append("FROM public.user ");
		sql.append("WHERE id=?");
		
		preparedStatement.setObject(1, id);
		
		try(var resultSet = preparedStatement.executeQuery()){
			if (resultSet.next()) {
				final var userEntity = new UserEntity();
				userEntity.setId((UUID) resultSet.getObject("id"));
				userEntity.setFirstName(resultSet.getString("first_name"));
				userEntity.setSecondName(resultSet.getString("second_name"));
				userEntity.setFirstSurname(resultSet.getString("first_surname"));
				userEntity.setSecondSurname(resultSet.getString("second_surname"));
				userEntity.setEmail(resultSet.getString("email"));
				userEntity.setPhone(resultSet.getString("phone"));
				userEntity.setIdentificationNumber(resultSet.getString("identification_number"));
				userEntity.setIdentificationType(resultSet.getString("identification_type"));
				userEntity.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
				userEntity.setCity((UUID) resultSet.getObject("city"));
				userEntity.setActive(resultSet.getBoolean("active"));
				
				return userEntity;
			}else {
				return null;
			}
		}
		
		try (var preparedStatement = getConnection().prepareStatement(sql.toString())){
			try (var resultSet = preparedStatement.executeQuery()){
				if (resultSet.next()) {
					final var userEntity = new UserEntity();
					userEntity.setId((UUID) resultSet.getObject("id"));
					userEntity.setFirstName(resultSet.getString("first_name"));
					userEntity.setSecondName(resultSet.getString("second_name"));
					userEntity.setFirstSurname(resultSet.getString("first_surname"));
					userEntity.setSecondSurname(resultSet.getString("second_surname"));
					userEntity.setEmail(resultSet.getString("email"));
					userEntity.setPhone(resultSet.getString("phone"));
					userEntity.setIdentificationNumber(resultSet.getString("identification_number"));
					userEntity.setIdentificationType(resultSet.getString("identification_type"));
					userEntity.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
					userEntity.setCity((UUID) resultSet.getObject("city"));
					userEntity.setActive(resultSet.getBoolean("active"));
					
					return userEntity;
				}else {
					return null;
				}
			}
		
	}

	@Override
	public void update(UserEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new String Builder();
		sql.append("UPDATE public.user ");
		sql.append("SET first_name=?, second_name=?, first_surname=?, second_surname=?, email=?, phone=?, identification_number=?, identification_type=?, birth_date=?, city=?, active=? ");
		
		sql.append("WHERE id=?; ");
		
		try (var preparedStatement = getConnection().prepareStatement(sql.toString())){
			preparedStatement.setObject(1, entity.getFirstName());
			preparedStatement.setObject(2, entity.getSecondNumber());
			preparedStatement.setObject(3, entity.getFirstSurname());
			preparedStatement.setObject(4, entity.getSecondSurname());
			preparedStatement.setObject(5, entity.getEmail());
			preparedStatement.setObject(6, entity.getPhone());
			preparedStatement.setObject(7, entity.getIdentificationNumber());
			preparedStatement.setObject(8, entity.getIdentificationType());
			preparedStatement.setObject(9, entity.getBirthDate());
			preparedStatement.setObject(10, entity.getCity());
			preparedStatement.setObject(11, entity.isActive());
			preparedStatement.setObject(12, entity.getId());
			
			preparedStatement.executeUpdate();
		}catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void delete(UUID id) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new String Builder();
		sql.append("DELETE FROM public.user ");
		sql.append("WHERE id=?; ");
		
		try (var preparedStatement = getConnection().prepareStatement(sql.toString())){
			preparedStatement.setObject(1, id);
			
			preparedStatement.executeUpdate();
		}catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NeseException.create(exception, userMessage, technicalMessage);
		}
		
	}

}
