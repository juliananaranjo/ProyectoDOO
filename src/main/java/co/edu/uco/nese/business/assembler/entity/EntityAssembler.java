package co.edu.uco.nese.business.assembler.entity;

import java.util.List;

public interface EntityAssembler<T, D> {
	
	T toEntity(D domain);
	D toDomain(T entity);
	
	List<T> toDTO(List<D> domainList);

}
