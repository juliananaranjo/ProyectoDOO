package co.edu.uco.nese.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nese.business.assembler.dto.DTOAssembler;
import co.edu.uco.nese.business.domain.IdentificationTypeDomain;
import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;
import co.edu.uco.nese.dto.IdentificationTypeDTO;

public final class IdentificationTypeDTOAssembler implements DTOAssembler<IdentificationTypeDTO, IdentificationTypeDomain>{
	
	private static final DTOAssembler<IdentificationTypeDTO, IdentificationTypeDomain> instance =
			new IdentificationTypeDTOAssembler();
	
	private IdentificationTypeDTOAssembler() {
	}
	
	public static DTOAssembler<IdentificationTypeDTO, IdentificationTypeDomain> getIdentificationTypeDTOAssembler(){
		return instance;
	}

	@Override
	public IdentificationTypeDTO toDTO(IdentificationTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdentificationTypeDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdentificationTypeDomain toDomain(IdentificationTypeDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new IdentificationTypeDTO());
		return new IdentificationTypeDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<IdentificationTypeDTO> toDTO(List<IdentificationTypeDomain> domainList) {
		var identificationTypeDtoList = new ArrayList<IdentificationTypeDTO>();
		
		for (var identificationTypeDomain : domainList) {
			identificationTypeDtoList.add(toDTO(identificationTypeDomain));
		}
		
		return identificationTypeDtoList;
	}
}