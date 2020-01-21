package dev.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	public void insererClient() {

		List<Client> listeClients = new ArrayList<>();
		listeClients.add(new Client("Pierre", "Jean"));
		listeClients.add(new Client("Albert", "Dimitri"));
		listeClients.add(new Client("Pierre", "Dimitri"));

		this.clientRepository.saveAll(listeClients);

	}

	// @RequestMapping(method = RequestMethod.GET, path = "clients")
	// public List<Client> clients() {
	// return this.clientRepository.findAll();
	//
	// }

	@RequestMapping(method = RequestMethod.GET, path = "clients")
	public List<Client> query(@RequestParam("nom") String nomRequete) {
		return this.clientRepository.findByNom("Pierre");
	}

}
