package co.edu.uco.nese.business.domain;

import java.util.UUID;

import co.edu.uco.nese.crosscuting.helpers.ObjectHelper;
import co.edu.uco.nese.crosscuting.helpers.TextHelper;
import co.edu.uco.nese.crosscuting.helpers.UUIDHelper;

public final class CityDomain extends Domain {
	
	private String name;
	private DepartmentDomain department;
	
	public CityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDepartment(new DepartmentDomain());
	}
	
	public CityDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setDepartment(new DepartmentDomain());
	}
	
	public CityDomain(final UUID id, final String name, final DepartmentDomain department) {
		super(id);
		setName(name);
		setDepartment(department);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public DepartmentDomain getDepartment() {
		return department;
	}

	public void setDepartment(final DepartmentDomain department) {
		this.department = ObjectHelper.getDefault(department, new DepartmentDomain());
	}

}
