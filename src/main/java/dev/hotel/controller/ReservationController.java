package dev.hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
