package dev.hotel.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservationJson extends BaseEntite {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private UUID clientId;
	private List<UUID> chambres = new ArrayList<>();

	/**
	 * Getter
	 * 
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut
	 *            the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter
	 * 
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter
	 * 
	 * @return the clientId
	 */
	public UUID getClientId() {
		return clientId;
	}

	/**
	 * Setter
	 * 
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	/**
	 * Getter
	 * 
	 * @return the chambres
	 */
	public List<UUID> getChambres() {
		return chambres;
	}

	/**
	 * Setter
	 * 
	 * @param chambres
	 *            the chambres to set
	 */
	public void setChambres(List<UUID> chambres) {
		this.chambres = chambres;
	}

}
