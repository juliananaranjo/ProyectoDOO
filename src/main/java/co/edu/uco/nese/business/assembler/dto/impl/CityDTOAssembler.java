package co.edu.uco.nese.business.assembler.dto.impl;

import static co.edu.uco.nese.business.assembler.dto.impl.DepartmentDTOAssembler.getDepartmentDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nese.business.assembler.dto.DTOAssembler;
import co.edu.uco.nese.business.domain.CityDomain;
import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;
import co.edu.uco.nese.dto.CityDTO;

public final class CityDTOAssembler implements DTOAssembler<CityDTO, CityDomain>{
	
	private static final DTOAssembler<CityDTO, CityDomain> instance =
			new CityDTOAssembler();
	
	private CityDTOAssembler() {
	}
	
	public static DTOAssembler<CityDTO, CityDomain> getCityDTOAssembler(){
		return instance;
	}

	@Override
	public CityDTO toDTO(CityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var departmentDtoTmp = getDepartmentDTOAssembler().toDTO(domainTmp.getDepartment());
		return new CityDTO(domainTmp.getId(), domainTmp.getName(), departmentDtoTmp);
	}

	@Override
	public CityDomain toDomain(CityDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CityDTO());
		var departmentDomainTmp = getDepartmentDTOAssembler().toDomain(dtoTmp.getDepartment());
		return new CityDomain(dtoTmp.getId(), dtoTmp.getName(), departmentDomainTmp);
	}

	@Override
	public List<CityDTO> toDTO(List<CityDomain> domainList) {
		var cityDtoList = new ArrayList<CityDTO>();
		
		for (var cityDomain : domainList) {
			cityDtoList.add(toDTO(cityDomain));
		}
		
		return cityDtoList;
	}

}