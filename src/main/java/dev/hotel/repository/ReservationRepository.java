package dev.hotel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.entite.ReservationJson;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

	Reservation findByClient(Client client);

	Reservation save(ReservationJson reservationRecu);

}
