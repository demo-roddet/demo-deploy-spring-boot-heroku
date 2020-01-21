package dev.hotel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Chambre;

public interface ReservationRepository extends JpaRepository<Chambre, UUID> {

}
