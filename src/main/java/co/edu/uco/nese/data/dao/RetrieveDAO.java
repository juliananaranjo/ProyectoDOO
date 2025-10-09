package co.edu.uco.nese.data.dao;

import java.util.List;

public interface RetrieveDAO<E, ID> {
	
	List <E> findAll();
	
	List<E> findByFilter(E filterEntity);
	
	E findByID(ID id);

}
