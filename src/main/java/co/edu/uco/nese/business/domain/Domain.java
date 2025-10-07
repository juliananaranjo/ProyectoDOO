package co.edu.uco.nese.business.domain;

import java.util.UUID;

import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;

class Domain {
    
    private UUID id;
    
    protected Domain(final UUID id) {
    	setId(id);
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
    
    
}

