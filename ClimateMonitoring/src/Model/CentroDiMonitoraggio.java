package Model;
import java.util.List;
/**
 * La classe rappresenta un centro di monitoraggio con le relative informazioni.
 
 * @author alequ
 *
 */
public class CentroDiMonitoraggio {
	/**
	 * Nome del centro di monitoraggio
	 */
	private String centroname;
	/**
	 * Indirizzo del centro di monitoraggio
	 */
	private String indirizzo;
	/**
	 * Coordinate di monitoraggio associate al centro.
	 */
	private List<CoordinateMonitoraggio> coordinatedimonitoraggio; 
	/**
	 * Operatori associati al centro di monitoraggio
	 */
	private List<Operatore> operatori ;
	/**
	 * Parametri climatici monitorati dal centro
	 */
	private List<ParametriClimatici> parametriclimatici;
	/**
	 * Id univoco del centro di monitoraggio. 
	 */
	private Integer idcentro;
	

	/**
	 * Costruttore vuoto della classe 
	 */
	public CentroDiMonitoraggio() {
	}
	
	/**
	 * Restituisce il nome del centro di monitoraggio.
	 * 
	 * @return il nome del centro di monitoraggio.
	 */
	public String getCentroname() {
		return centroname;
	}

/**
 * Imposta il nome del centro di monitoraggio.
 * 
 * @param centroname
 */
	public void setCentroname(String centroname) {
		this.centroname = centroname;
	}

/**
 * Restituisce la lista di operatori associati al centro di monitoraggio.
 * 
 * @return la lista degli operatori associati.
 */
	public List<Operatore> getOperatori() {
		return operatori;
	}

/**
 *  Imposta la lista degli operatori associati al centro di monitoraggio
 * @param operatori, rappresenta la nuova lista degli operatori.
 */
	public void setOperatori(List<Operatore> operatori) {
		this.operatori = operatori;
	}

/**
 * Imposta l'id del centro di monitoraggio
 * 
 * @param idcentro, il nuovo id del centro di monitoraggio.
 */
	public void setIdcentro(Integer idcentro) {
		this.idcentro = idcentro;
	}

/**
 * Restituisce la lista di coordinate di monitoraggio associate al centro.
 * 
 * @return la lista delle coordinate di monitoraggio
 */
	public List<CoordinateMonitoraggio> getCoordinatedimonitoraggio() {
		return coordinatedimonitoraggio;
	}
/**
 * Imposta la lista delle coordinate di monitoraggio associate al centro.
 * 
 * @param coordinatedimonitoraggio, la nuova lista delle coordinate di monitoraggio
 */
	public void setCoordinatedimonitoraggio(List<CoordinateMonitoraggio> coordinatedimonitoraggio) {
		this.coordinatedimonitoraggio = coordinatedimonitoraggio;
	}
/**
 * Restituisce la lista dei parametri climatici monitorati dal centro di monitoraggio.
 * 
 * @return la lista di parametri climatici monitorati
 */
	public List<ParametriClimatici> getParametriclimatici() {
		return parametriclimatici;
	}
/**
 * Imposta la lista dei parametri climatici monitorati dal centro di monitoraggio.
 * 
 * @param parametriclimatici, la nuova lista di parametri climatici monitorati.
 */
	public void setParametriclimatici(List<ParametriClimatici> parametriclimatici) {
		this.parametriclimatici = parametriclimatici;
	}
/**
 * Restituisce l'Id univoco del centro di monitoraggio.
 * 
 * @return Id del centro di monitoraggio. 
 */
	public int getIdcentro() {
		return idcentro;
	}
/**
 * Imposta L'id univoco del centro di monitoraggio
 * 
 * @param idcentro, il nuovo ID del centro di monitoraggio.
 */
	public void setIdcentro(int idcentro) {
		this.idcentro = idcentro;
	}
/**
 * Restituisce l'indirizzo del centro di monitoraggio.
 * 
 * @return indirizzo, il nuovo indirizzo del centro di monitoraggio.
 */
	public String getIndirizzo() {
		return indirizzo;
	}
/**
 * Imposta l'indirizzo del centro di monitoraggio 
 * 
 * @param indirizzo, il nuovo indirizzo del centro di monitoraggio. 
 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	
	
	
	
	
}
