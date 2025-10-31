package co.edu.uco.nese.business.assembler.entity.impl;

import static co.edu.uco.nese.business.assembler.entity.impl.DepartmentEntityAssembler.getDepartmentEntityAssembler;

import co.edu.uco.nese.business.assembler.entity.EntityAssembler;
import co.edu.uco.nese.business.domain.CityDomain;
import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;
import co.edu.uco.nese.entity.CityEntity;

public final class CityEntityAssembler implements EntityAssembler<CityEntity, CityDomain>{
	
	private static final EntityAssembler<CityEntity, CityDomain> instance =
			new CityEntityAssembler();
	
	private CityEntityAssembler() {
	}
	
	public static EntityAssembler<CityEntity, CityDomain> getCityEntityAssembler(){
		return instance;
	}
	
	@Override
	public CityEntity toEntity(CityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var departmentEntityTmp = getDepartmentEntityAssembler().toEntity(domainTmp.getDepartment());
		return new CityEntity(domainTmp.getId(), domainTmp.getName(), departmentEntityTmp);
	}

	@Override
	public CityDomain toDomain(CityEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new CityEntity());
		var departmentDomainTmp = getDepartmentEntityAssembler().toDomain(entityTmp.getDepartment());
		return new CityDomain(entityTmp.getId(), entityTmp.getName(), departmentDomainTmp);
	}

}