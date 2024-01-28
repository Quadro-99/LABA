package Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.CentroDiMonitoraggio;
import Model.CoordinateMonitoraggio;
import Model.Operatore;
import Repository.RepositoryCoordinate;
import Repository.RepositoryInterface;

/**
 * La classe ServiceCoordinate gestisce le operazioni relative alle coordinate di monitoraggio.
 * Utilizza un repository per accedere ai dati delle coordinate dal database e fornisce metodi
 * per recuperare, filtrare ed arricchire le informazioni sulle coordinate.
 * @author alequ
 * @see RepositoryCoordinate
 * @see RepositoryInterface
 * @see CoordinateMonitoraggio
 * @see ServiceCentro
 * @see ServiceOperatore
 */
public class ServiceCoordinate {
	/**
	 * Viene istanziato un oggetto della classe ServiceCentro
	 */
	private ServiceCentro servicecentro;
	/**
	 * Viene istanziato un oggetto della classe ServiceOperatore
	 */
	private ServiceOperatore serviceoperatore;
	/**
	 * Inizializzazione di una lista che dovrà contenere le coordinate di monitoraggio 
	 */
	private List<CoordinateMonitoraggio> coordinate = new ArrayList<>();
	/**
	 * Inizializzazione di un Repository per l'accesso ai dati delle coordinate 
	 */
	private RepositoryInterface<CoordinateMonitoraggio> repositorycoordinate = new RepositoryCoordinate();
	
	
	
	/**
	 * 	Costruttore di default che inizializza il servizio caricando le coordinate dal repository
	 */
	public ServiceCoordinate() {
			this.caricaCoordinate();
	}
	/**
	 * Carica tutte le coordinate dal repository e le memorizza nella lista interna del servizio
	 */
	public void caricaCoordinate () {
		try {
			this.coordinate = repositorycoordinate.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<CoordinateMonitoraggio> getCoordinateByOperatore(Operatore o){
		return coordinate.stream().filter(c -> c.getIdoperatore() == o.getIdoperatore()).collect(Collectors.toList());
	}
	/**
	 * Restituisce le coordinate corrispondenti al geoname indicato
	 * @param geoname il geoname delle coordinate da cercare 
	 * @return le coordinate corrispondenti al geoname o un'istanza vuota se non trovate
	 */
	public CoordinateMonitoraggio getCoordinatebyGeoname(int geoname) {
		return coordinate.stream().filter(c -> c.getGeoname() == geoname).findFirst().orElse(new CoordinateMonitoraggio());
	}
	/**
	 * Restituisce una lista di coordinate associate a un determinato centro di monitoraggio.*
	 * @param cm il centro di monitoraggio
	 * @return la lista di coordinate associate al centro di monitoraggio
	 */
	public List<CoordinateMonitoraggio> getCoordinateByCentro (CentroDiMonitoraggio cm){
		return coordinate.stream().filter(c -> c.getIdcentro() == cm.getIdcentro()).collect(Collectors.toList());
	}
	public List<CoordinateMonitoraggio> getCoordinateByStato(String stato){
	return coordinate.stream().filter(c-> c.getStato() == stato).collect(Collectors.toList());
	}
	
	public void associaCentro(CoordinateMonitoraggio co) {
		try {
			repositorycoordinate.update(co);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void creaCoordinate(CoordinateMonitoraggio co) {
		try {
			repositorycoordinate.save(co);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Arricchisce le coordinate con informazioni sugli operatori e i centri di monitoraggio associati.
	 * @param so il Service degli operatori
	 * @param sc il Service dei centri di monitoraggio
	 */
	public void enrichCoordinate (ServiceOperatore so, ServiceCentro sc) {
		this.serviceoperatore = so;
		this.servicecentro = sc;
		this.coordinate.stream().forEach(c -> this.coordinateMapper(c));
	}
	/**
	 * Mappa le informazioni sugli operatori e i centri di monitoraggio associati a una coordinata.
	 * @param c la coordinata di monitoraggio da arricchire
	 */
	private void coordinateMapper (CoordinateMonitoraggio c) {
		c.setCentro(this.servicecentro.getCentroById(c.getIdcentro()));
		c.setOperatore(this.serviceoperatore.getOperatorebyId(c.getIdoperatore()));
	}
}
