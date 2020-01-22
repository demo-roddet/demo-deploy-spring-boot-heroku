package dev.hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.entite.ReservationJson;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientRepository;
import dev.hotel.repository.ReservationRepository;

@RestController
@RequestMapping("reservations")
public class ReservationController {

	private ChambreRepository chambreRepository;
	private ClientRepository clientRepository;
	private ReservationRepository reservationRepository;

	/**
	 * @param chambreRepository
	 * @param clientRepository
	 * @param reservationRepository
	 */
	public ReservationController(ChambreRepository chambreRepository, ClientRepository clientRepository,
			ReservationRepository reservationRepository) {
		super();
		this.chambreRepository = chambreRepository;
		this.clientRepository = clientRepository;
		this.reservationRepository = reservationRepository;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Reservation postReservation(@RequestBody ReservationJson reservationRecu) {
		Reservation resa = new Reservation();
		Client client = new Client();
		if (clientRepository.findById(reservationRecu.getClientId()).isPresent()) {

			client = clientRepository.findById(reservationRecu.getClientId()).get();
			resa.setClient(client);

		} else {
			throw new EntityNotFoundException("client non trouvé");

		}
		List<Chambre> chambres = new ArrayList<>();
		for (UUID chambre : reservationRecu.getChambres()) {

			if (chambreRepository.findById(chambre).isPresent()) {
				Chambre ch = this.chambreRepository.findById(chambre).get();
				chambres.add(ch);
				resa.setChambres(chambres);
				resa.setDateDebut(reservationRecu.getDateDebut());
				resa.setDateFin(reservationRecu.getDateFin());

			} else {
				throw new EntityNotFoundException("la chambre " + chambre + " n'existe pas");

			}
		}

		return this.reservationRepository.save(resa);

	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<String> ReservationPresent(EntityNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur " + exception.getMessage());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public List<Reservation> listerResa() {
		List<Reservation> reservations = this.reservationRepository.findAll();

		return reservations;

	}

}
