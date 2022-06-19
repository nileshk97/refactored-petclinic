package org.springframework.samples.petclinic.owner;

import java.util.HashSet;
import java.util.Set;

public class OwnerPOJO {

	private Integer id;

	private String firstName;

	private String lastName;

	private String address;

	private String city;

	private String telephone;

	private Set<Pet> pets;

	protected Set<Pet> getPetsInternal() {
		if (this.pets == null) {
			this.pets = new HashSet<>();
		}
		return this.pets;
	}

	protected void setPetsInternal(Set<Pet> pets) {
		this.pets = pets;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isNew() {
		return this.id == null;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "OwnerPOJO{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", address='" + address + '\'' + ", city='" + city + '\'' + ", telephone='" + telephone + '\''
				+ ", pets=" + pets + '}';
	}

}
