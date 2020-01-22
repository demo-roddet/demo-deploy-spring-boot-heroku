package dev.hotel.controller;

import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public Client post400(@RequestBody Client clientRecu) {
		Client client = new Client();
		Optional<Client> clients = this.clientRepository.findByNomAndPrenoms(clientRecu.getNom(),
				clientRecu.getPrenoms());

		if (!clients.isPresent()) {
			client.setNom(clientRecu.getNom());
			client.setPrenoms(clientRecu.getPrenoms());
			this.clientRepository.save(client);
		} else {
			throw new EntityExistsException();
		}
		return client;
	}

	@ExceptionHandler(value = { EntityExistsException.class })
	public ResponseEntity<String> ClientPresent(EntityExistsException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("client déja en bdd");
	}
}
