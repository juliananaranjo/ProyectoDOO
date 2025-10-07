package co.edu.uco.nese.business.domain;

import java.util.UUID;

import co.edu.uco.nese.crosscuting.helpers.TextHelper;
import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;

public final class CountryDomain extends Domain{
	
	private String name;
	
	public CountryDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	public CountryDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	
	public CountryDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());	
		setName(TextHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
}
