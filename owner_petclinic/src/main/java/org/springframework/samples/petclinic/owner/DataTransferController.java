package org.springframework.samples.petclinic.owner;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

@Controller
public class DataTransferController {

	private final OwnerRepository owners;

	public DataTransferController(OwnerRepository clinicService) {
		this.owners = clinicService;
	}

	@GetMapping("owner/{ownerId}")
	@ResponseBody
	public Owner getOwnerById(@PathVariable String ownerId) {
		Owner owner = this.owners.findById(Integer.parseInt(ownerId));
		return owner;
	}

	// TODO: Add a GET endpoint that returns whether an owner with given id exists or not
	@GetMapping("doesownerexist/{ownerId}")
	@ResponseBody
	public boolean doesOwnerExist(@PathVariable String ownerId) {
		Owner owner = owners.findById(Integer.parseInt(ownerId));
		if (owner == null)
			return false;
		else
			return true;
	}

	@GetMapping("/owners/deleteownerbyid/{id}")
	public String deleteOwnerById(@PathVariable("id") Integer ownerId) throws IOException {
		// Start HTTP request code
		String GET_URL = "http://localhost:8081/deletebyownerid/" + ownerId;
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("Response[Pets] over HTTP: " + response.toString());
		}
		else {
			System.out.println("Request to GET pets of the owner did not work");
		}
		// End HTTP request code

		this.owners.deleteById(ownerId);
		return "redirect:/owners/find";
	}

}
