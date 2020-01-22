package dev.hotel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.HotelRepository;

@RestController
@RequestMapping("chambres")
public class ChambreController {

	private ChambreRepository chambreRepository;
	private HotelRepository hotelRepository;

	/**
	 * @param chambreRepository
	 */
	public ChambreController(ChambreRepository chambreRepository, HotelRepository hotelRepository) {
		super();
		this.chambreRepository = chambreRepository;
		this.hotelRepository = hotelRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Chambre> chambres() {
		return this.chambreRepository.findAll();
	}

}
