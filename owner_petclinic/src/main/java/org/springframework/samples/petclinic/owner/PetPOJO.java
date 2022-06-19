package org.springframework.samples.petclinic.owner;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PetPOJO {

	private Integer id;

	private String name;

	private String birthDate;

	private PetTypePOJO type;

	private Integer ownerId;

	private Set<VisitPOJO> visits = new LinkedHashSet<>();

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(this.birthDate, formatter);
		return date;
	}

	public boolean isNew() {
		return this.id == null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetTypePOJO getType() {
		return type;
	}

	public void setType(PetTypePOJO type) {
		this.type = type;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	protected Set<VisitPOJO> getVisitsInternal() {
		if (this.visits == null) {
			this.visits = new HashSet<>();
		}
		return this.visits;
	}

	protected void setVisitsInternal(Collection<VisitPOJO> visits) {
		this.visits = new LinkedHashSet<>(visits);
	}

	public List<VisitPOJO> getVisits() {
		List<VisitPOJO> sortedVisits = new ArrayList<>(getVisitsInternal());
		PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
		return Collections.unmodifiableList(sortedVisits);
	}

	public void addVisit(VisitPOJO visit) {
		getVisitsInternal().add(visit);
		visit.setPetId(this.getId());
	}

}
