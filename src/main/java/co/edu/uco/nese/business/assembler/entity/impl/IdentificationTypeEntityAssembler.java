package co.edu.uco.nese.business.assembler.entity.impl;

import co.edu.uco.nese.business.assembler.entity.EntityAssembler;
import co.edu.uco.nese.business.domain.IdentificationTypeDomain;
import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;
import co.edu.uco.nese.entity.IdentificationTypeEntity;

public final class IdentificationTypeEntityAssembler implements EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain>{
	
	private static final EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> instance =
			new IdentificationTypeEntityAssembler();
	
	private IdentificationTypeEntityAssembler() {
	}
	
	public static EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> getIdentificationTypeEntityAssembler(){
		return instance;
	}
	
	@Override
	public IdentificationTypeEntity toEntity(IdentificationTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdentificationTypeEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdentificationTypeDomain toDomain(IdentificationTypeEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new IdentificationTypeEntity());
		return new IdentificationTypeDomain(entityTmp.getId(), entityTmp.getName());
	}

}