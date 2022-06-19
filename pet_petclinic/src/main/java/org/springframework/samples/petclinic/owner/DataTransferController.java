package org.springframework.samples.petclinic.owner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataTransferController {

	private final PetRepository pets;

	public DataTransferController(PetRepository pets) {
		this.pets = pets;
	}

	@GetMapping("/owner/{ownerId}/pets")
	@ResponseBody
	public List<Pet> getPetsByOwnerId(@PathVariable Integer ownerId) {
		List<Pet> pets = this.pets.findByOwnerId(ownerId);
		for (Pet pet : pets) {
			System.out.println(pet);
		}
		return pets;
	}

}
