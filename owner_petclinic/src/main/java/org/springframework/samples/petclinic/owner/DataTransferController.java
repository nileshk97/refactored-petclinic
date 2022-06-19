package org.springframework.samples.petclinic.owner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataTransferController {

	private final OwnerRepository owners;

	public DataTransferController(OwnerRepository clinicService) {
		this.owners = clinicService;
	}

	// TODO: Add a GET endpoint that returns owner with given Id
	@GetMapping("owner/{ownerId}")
	@ResponseBody
	public Owner getOwnerById(@PathVariable String ownerId) {
		Owner owner = this.owners.findById(Integer.parseInt(ownerId));
		return owner;
	}

}
