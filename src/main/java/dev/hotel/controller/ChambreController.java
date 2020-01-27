package dev.hotel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.repository.ChambreRepository;

@RestController
@RequestMapping("chambres")
public class ChambreController {

	private ChambreRepository chambreRepository;

	/**
	 * @param chambreRepository
	 */
	public ChambreController(ChambreRepository chambreRepository) {
		super();
		this.chambreRepository = chambreRepository;
	}

	@GetMapping
	public List<Chambre> chambres() {
		return this.chambreRepository.findAll();
	}

}
