package dev.hotel.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@RestController
public class ClientController {

	private ClientRepository clientRepository;

	/**
	 * @param clientRepository
	 */
	public ClientController(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	// @RequestMapping(method = RequestMethod.GET, path = "clients")
	// public List<Client> clients() {
	// return this.clientRepository.findAll();
	//
	// }

	// @RequestMapping(method = RequestMethod.GET, path = "clients")
	// public List<Client> query(@RequestParam("nom") String nomRequete) {
	// return this.clientRepository.findByNom("Pierre");
	// }

	@RequestMapping(method = RequestMethod.POST, path = "clients")
	public ResponseEntity<String> post400(@RequestBody Client clientRecu) {
		Client client = new Client();

		Optional<Client> clients = this.clientRepository.findByNomAndPrenoms(clientRecu.getNom(),
				clientRecu.getPrenoms());
		ResponseEntity<String> body = null;
		if (!clients.isPresent()) {
			client.setNom(clientRecu.getNom());
			client.setPrenoms(clientRecu.getPrenoms());
			this.clientRepository.save(client);
			body = ResponseEntity.status(HttpStatus.CREATED)
					.body(client.getNom() + " " + client.getPrenoms() + " a bien été ajouté en base");

		} else {
			body = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le client est déjà en bdd");
		}
		return body;
	}
}
