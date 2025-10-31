package co.edu.uco.nese.business.assembler.entity.impl;

import co.edu.uco.nese.business.assembler.entity.EntityAssembler;
import co.edu.uco.nese.business.domain.CountryDomain;
import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;
import co.edu.uco.nese.entity.CountryEntity;

public final class CountryEntityAssembler implements EntityAssembler<CountryEntity, CountryDomain>{
	
	private static final EntityAssembler<CountryEntity, CountryDomain> instance =
			new CountryEntityAssembler();
	
	private CountryEntityAssembler() {
	}
	
	public static EntityAssembler<CountryEntity, CountryDomain> getCountryEntityAssembler(){
		return instance;
	}
	
	@Override
	public CountryEntity toEntity(CountryDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new CountryEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public CountryDomain toDomain(CountryEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new CountryEntity());
		return new CountryDomain(entityTmp.getId(), entityTmp.getName());
	}

}