package co.edu.uco.nese.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nese.business.assembler.dto.DTOAssembler;
import co.edu.uco.nese.business.domain.CountryDomain;
import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;
import co.edu.uco.nese.dto.CountryDTO;

public final class CountryDTOAssembler implements DTOAssembler<CountryDTO, CountryDomain>{
	
	private static final DTOAssembler<CountryDTO, CountryDomain> instance =
			new CountryDTOAssembler();
	
	private CountryDTOAssembler() {
	}
	
	public static DTOAssembler<CountryDTO, CountryDomain> getCountryDTOAssembler(){
		return instance;
	}

	@Override
	public CountryDTO toDTO(final CountryDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new CountryDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public CountryDomain toDomain(final CountryDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CountryDTO());
		return new CountryDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<CountryDTO> toDTO(List<CountryDomain> domainList) {
		var countryDtoList = new ArrayList<CountryDTO>();
		
		for (var countryDomain : domainList) {
			countryDtoList.add(toDTO(countryDomain));
		}
		
		return countryDtoList;
	}

}