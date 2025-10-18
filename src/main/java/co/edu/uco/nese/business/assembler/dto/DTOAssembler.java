package co.edu.uco.nese.business.assembler.dto;

public interface DTOAssembler<T, D> {
	
	T toDTO(D domain);
	D toDomain(T dto);

}
