package dev.hotel.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityExistsException;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

public class ClientService {

	private ClientRepository clientRepository;

	/**
	 * @param clientRepository
	 */
	public ClientService(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	public List<Client> listerClients() {
		return this.clientRepository.findAll();
	}

	public List<Client> findByNom(String nomRequete) {
		return this.clientRepository.findByNom(nomRequete);
	}

	public UUID creerClient(Client clientRecu) {
		if (this.clientRepository.existsByNomAndPrenoms(clientRecu.getNom(), clientRecu.getPrenoms())) {
			throw new EntityExistsException();
		}

		return this.clientRepository.save(clientRecu).getUuid();
	}

}
