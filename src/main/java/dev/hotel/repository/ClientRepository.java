package dev.hotel.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

	List<Client> findByNom(String nom);

	Optional<Client> findByPrenoms(String prenoms);

	Optional<Client> findByNomAndPrenoms(String nom, String prenoms);

	boolean existsByNomAndPrenoms(String nom, String prenoms);

}
