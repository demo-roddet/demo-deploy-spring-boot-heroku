package dev.hotel.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Reservation;
import dev.hotel.entite.ReservationJson;
import dev.hotel.service.ReservationService;

@RestController
@RequestMapping("reservations")
public class ReservationController {

	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@PostMapping
	public ResponseEntity<Reservation> postReservation(@RequestBody @Valid ReservationJson reservationRecu) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.reservationService.creerReservation(reservationRecu.getDateDebut(),
				reservationRecu.getDateFin(), reservationRecu.getChambres(), reservationRecu.getClientId()));

	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<String> reservationPresent(EntityNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur " + exception.getMessage());
	}

	@GetMapping
	public List<Reservation> listerResa() {
		return this.reservationService.listerReservations();

	}

}
