package dev.hotel.exec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@Controller
public class InsererClient implements Runnable {

	private ClientRepository clientRepository;

	/**
	 * @param clientRepository
	 */
	public InsererClient(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public void run() {

		List<Client> listeClients = new ArrayList<>();
		listeClients.add(new Client("Pierre", "Dimitri"));
		this.clientRepository.saveAll(listeClients);

	}

}
