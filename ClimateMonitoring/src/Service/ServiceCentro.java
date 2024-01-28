package Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.CentroDiMonitoraggio;
import Model.Operatore;
import Repository.RepositoryCentro;
import Repository.RepositoryInterface;
/**
 *  La classe ServiceCentro gestisce le operazioni relative ai centri di monitoraggio.
 * Utilizza un repository per accedere ai dati dei centri dal database e fornisce metodi
 * per caricare, recuperare, e arricchire le informazioni sui centri di monitoraggio.
 * 
 * @author alequ
 * @see RepositoryCentro
 * @see RepositoryInterface
 * @see CentroDiMonitoraggio
 * @see ServiceOperatore
 * @see ServiceCoordinate
 *
*/
public class ServiceCentro {
	/**
	 * Inizializzazione di una Lista che conterrà i centri di monitoraggio
	 */
	private List<CentroDiMonitoraggio> centri = new ArrayList<>();
	/**
	 * Viene istanziato un oggetto della classe ServiceCentro
	 */
	private RepositoryInterface<CentroDiMonitoraggio> repositorycentro = new RepositoryCentro();
	/**
	 * Viene istanziato un Service per la gestione degli operatori
	 */
	private ServiceOperatore serviceoperatore;
	/**
	 * Viene istanziato un Service per la gestione delle Coordinate
	 */
	private ServiceCoordinate servicecoordinate;
	/**
	 * Costruttore di default che inizializza il servizio caricando i centri dal repository.
	 */
	public ServiceCentro () {
		this.caricaCentri();
	}
	/**
	 * Carica tutti i centri dal repository e li memorizza nella lista interna del servizio.
	 */
	public void caricaCentri () {
		try {
			this.centri = repositorycentro.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public CentroDiMonitoraggio creaCentro(CentroDiMonitoraggio cm) {
		try {
			repositorycentro.save(cm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cm;
	}
	/**
	 * Restituisce il centro di monitoraggio corrispondente all'ID specificato.
	 * @param idcentro l'ID del centro di monitoraggio da cercare
	 * @return il centro di monitoraggio corrispondente all'ID, o null se non trovato
	 */
	public CentroDiMonitoraggio getCentroById(int idcentro) {
		return centri.stream().filter(c -> c.getIdcentro() == idcentro).findFirst().orElse(null);
	}
	/**
	 * Mappa le informazioni sulle coordinate e sugli operatori associati a un centro di monitoraggio.
	 * @param cm il centro di monitoraggio da arricchire 
	 */
	private void centroMapper (CentroDiMonitoraggio cm) {
	cm.setCoordinatedimonitoraggio(this.servicecoordinate.getCoordinateByCentro(cm));
	cm.setOperatori(this.serviceoperatore.getOperatoriListByCentro(cm));
	}
	/**
	 * Arricchisce i centri con informazioni sulle coordinate e sugli operatori associati.
	 * @param so Il service dell'operatore
	 * @param sc Il service delle coordinate
	 */
	public void enrichCentri (ServiceOperatore so, ServiceCoordinate sc) {
		this.serviceoperatore = so;
		this.servicecoordinate = sc;  
		this.centri.stream().forEach(cm -> this.centroMapper(cm));
		
	}
}
