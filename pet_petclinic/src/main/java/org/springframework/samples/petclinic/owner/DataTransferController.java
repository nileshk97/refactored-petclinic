package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataTransferController {

	private final PetRepository pets;

	private final VisitRepository visitRepository;

	public DataTransferController(PetRepository pets, VisitRepository visits) {
		this.pets = pets;
		this.visitRepository = visits;
	}

	@GetMapping("/owner/{ownerId}/pets")
	@ResponseBody
	public List<Pet> getPetsByOwnerId(@PathVariable Integer ownerId) {
		List<Pet> pets = this.pets.findByOwnerId(ownerId);
		return pets;
	}

	@GetMapping("pet/{petId}/visits")
	@ResponseBody
	public List<Visit> getVisitsByPetId(@PathVariable Integer petId) {
		List<Visit> visits = this.visitRepository.findByPetId(petId);
		return visits;
	}

	@GetMapping("deletebyownerid/{ownerId}")
	public String deleteByOwnerId(@PathVariable Integer ownerId) {
		this.pets.deleteByOwnerId(ownerId);
		return "redirect:http://localhost:8080/owners/{ownerId}";
	}

	@GetMapping("deletebyid/{petId}")
	public String deleteById(@PathVariable Integer petId) {
		Integer ownerId = this.pets.findById(petId).getOwnerId();
		this.pets.deleteById(petId);
		return "redirect:http://localhost:8080/owners/" + ownerId;
	}

}
