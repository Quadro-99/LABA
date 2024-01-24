package Model;
import java.util.List;
/**
 * La classe rappresenta le Coordinate di monitoraggio con le relative informazioni.
 * 
 * @author alequ
 *
 */
public class CoordinateMonitoraggio {
	/**
	 * Nome dell'Area monitorata 
	 */
	private String nomeArea;
	/**
	 * Stato in cui si trova l'area monitorata
	 */
	private String stato;
	/**
	 * Latitudine dell'area monitorata 
	 */
	private Double Latitudine;
	/**
	 * Longitudine dell'area monitorata
	 */
	private Double Longitudine;
	/**
	 * Codice numerico che identifica univocamente una coordinata di monitoraggio
	 */
	private int geoname;
	/**
	 * Il riferimento al centro di monitoraggio associato
	 */
	private CentroDiMonitoraggio centro;
	/**
	 * L'id del centro associato
	 */
	private Integer idcentro;
	/**
	 * Lista di parametri climatici associati
	 */
	private List<ParametriClimatici> parametriclimatici;
	/**
	 * Riferimento all'operatore associato
	 */
	private Operatore operatore;
	/**
	 * Id dell'operatore associato
	 */
	private Integer Idoperatore;
	
	/**
	 * Costruttore vuoto della classe Coordinate di monitoraggio
	 */
	public CoordinateMonitoraggio() {
		
	}

	/**
	 * Restituisce il riferimento al centro di monitoraggio associato
	 * 
	 * @return il riferimento al centro di monitoraggio associato
	 */
	public CentroDiMonitoraggio getCentro() {
		return centro;
	}
/**
 * Imposta il riferimento al centro di monitoraggio associato 
 * @param centro, il nuovo riferimento al centro di monitoraggio
 */
	public void setCentro(CentroDiMonitoraggio centro) {
		this.centro = centro;
	}
/**
 * Restituisce la lista di parametri climatici associati 
 * @return la lista di parametri climatici associati
 */
	public List<ParametriClimatici> getParametriclimatici() {
		return parametriclimatici;
	}
/**
 * Imposta la lista di parametri climatici associati
 * @param parametriclimatici, la nuova lista di parametri climatici associati
 */
	public void setParametriclimatici(List<ParametriClimatici> parametriclimatici) {
		this.parametriclimatici = parametriclimatici;
	}
/**
 * Restituisce il riferimento all'operatore associato
 * @return il riferimento all'operatore
 */
	public Operatore getOperatore() {
		return operatore;
	}
/**
 * Imposta il riferimento all'operatore associato
 * @param operatore, il nuovo riferimento all'operatore
 */
	public void setOperatore(Operatore operatore) {
		this.operatore = operatore;
	}

/**
 * Restituisce la latitudine dell'area monitorata
 * @return latitudine dell'area monitorata
 */
	public double getLatitudine() {
		return Latitudine;
	}
/**
 * Imposta la latitudine dell'area monitorata
 * @param latitudine, la nuova latitudine dell'area monitorata
 */
	public void setLatitudine(Double latitudine) {
		Latitudine = latitudine;
	}
/**
 * Restituisce la Longitudine dell'area monitorata 
 * @return longitudine dell'area monitorata. 
 */
	public double getLongitudine() {
		return Longitudine;
	}
/**
 * Imposta la lognitudine dell'area monitorata 
 * @param longitudine, la nuova longitudine dell'area monitorata 
 */
	public void setLongitudine(Double longitudine) {
		Longitudine = longitudine;
	}
/**
 * Restituisce il geoname dell'area monitorata 
 * @return geoname dell'area monitorata 
 */
	public int getGeoname() {
		return geoname;
	}
/**
 * Imposta il geoname dell'area monitorata 
 * @param geoname, nuovo geoname dell'area monitorata
 */
	public void setGeoname(int geoname) {
		this.geoname = geoname;
	}
/**
 * Restituisce lo stato dell'area monitorata
 * @return stato dell'area monitorata 
 */
	public String getStato() {
		return stato;
	}
/**
 * Imposta lo stato dell'area monitorata 
 * @param stato, il nuovo stato dell'area monitorata 
 */
	public void setStato(String stato) {
		this.stato = stato;
	}
/**
 * Restituisce l'ID del centro di monitoraggio associato  
 * @return Id del centro associato
 */
	public int getIdcentro() {
		return idcentro;
	}
/**
 * Imposta l'ID del centro di monitoraggio
 * @param idcentro, il nuovo ID del centro 
 */
	public void setIdcentro(Integer idcentro) {
		this.idcentro = idcentro;
	}
/**
 * Restituisce il nome dell'area monitorata
 * @return il nome dell'area 
 */
public String getNomeArea() {
	return nomeArea;
}
/**
 * Imposta il nome dell'area monitorata 
 * @param nomeArea, il nuovo nome dell'area monitorata
 */
public void setNomeArea(String nomeArea) {
	this.nomeArea = nomeArea;
}
/**
 * Restituisce l'id dell'operatore associato
 * @return l'id dell'operatore associato
 */
public Integer getIdoperatore() {
	return Idoperatore;
}
/**
 * Imposta l'id dell'operatore associato
 * @param idoperatore, il nuovo ide dell'operatore
 */
public void setIdoperatore(Integer idoperatore) {
	Idoperatore = idoperatore;
}
	
	
}
