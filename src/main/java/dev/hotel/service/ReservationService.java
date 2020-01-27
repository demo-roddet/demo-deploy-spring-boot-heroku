package dev.hotel.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import dev.hotel.entite.Reservation;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientRepository;
import dev.hotel.repository.ReservationRepository;

@Service
public class ReservationService {

	private ReservationRepository reservationRepository;

	private ClientRepository clientRepository;
	private ChambreRepository chambreRepository;

	public ReservationService(ReservationRepository reservationRepository, ClientRepository clientRepository, ChambreRepository chambreRepository) {
		super();
		this.reservationRepository = reservationRepository;
		this.clientRepository = clientRepository;
		this.chambreRepository = chambreRepository;
	}

	public Reservation creerReservation(LocalDate dateDebut, LocalDate dateFin, List<UUID> chambresId, UUID clientId) {
		Reservation resa = new Reservation();
		resa.setDateDebut(dateDebut);
		resa.setDateFin(dateFin);
		resa.setClient(clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException("client non trouvé")));
		resa.setChambres(
				chambresId.stream()
						.map(chambreId -> chambreRepository.findById(chambreId)
								.orElseThrow(() -> new EntityNotFoundException("la chambre " + chambreId + " n'existe pas")))
						.collect(Collectors.toList()));
		return this.reservationRepository.save(resa);
	}

	public List<Reservation> listerReservations() {
		return reservationRepository.findAll();
	}

}
