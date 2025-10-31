package co.edu.uco.nese.business.assembler.entity.impl;

import static co.edu.uco.nese.business.assembler.entity.impl.CountryEntityAssembler.getCountryEntityAssembler;

import co.edu.uco.nese.business.assembler.entity.EntityAssembler;
import co.edu.uco.nese.business.domain.DepartmentDomain;
import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.entity.DepartmentEntity;

public final class DepartmentEntityAssembler implements EntityAssembler<DepartmentEntity, DepartmentDomain>{
	
	private static final EntityAssembler<DepartmentEntity, DepartmentDomain> instance =
			new DepartmentEntityAssembler();
	
	private DepartmentEntityAssembler() {
	}
	
	public static EntityAssembler<DepartmentEntity, DepartmentDomain> getDepartmentEntityAssembler(){
		return instance;
	}
	
	@Override
	public DepartmentEntity toEntity(DepartmentDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new DepartmentDomain());
		var countryEntityTmp = getCountryEntityAssembler().toEntity(domainTmp.getCountry());
		return new DepartmentEntity(domainTmp.getId(), domainTmp.getName(), countryEntityTmp);
	}

	@Override
	public DepartmentDomain toDomain(DepartmentEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new DepartmentEntity());
		var countryDomainTmp = getCountryEntityAssembler().toDomain(entityTmp.getCountry());
		return new DepartmentDomain(entityTmp.getId(), entityTmp.getName(), countryDomainTmp);
	}

}