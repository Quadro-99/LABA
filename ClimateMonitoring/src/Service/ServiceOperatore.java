package Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.CentroDiMonitoraggio;
import Model.Operatore;
import Service.ServiceCentro;
import Repository.RepositoryOperatore;
import Repository.RepositoryInterface;
/**
 * La classe ServiceOperatore gestisce le operazioni e le logiche di business relative agli operatori.
 * Fornisce metodi per caricare gli operatori, ottenere informazioni e arricchire gli operatori
 * 
 * @author alequ
 * @see CentroDiMonitoraggio
 * @see Operatore
 * @see Service.ServiceCentro
 * @see RepositoryOperatore
 * @see RepositoryInterface
 */
public class ServiceOperatore {
	/**
	 * Service del centro
	 */
	private ServiceCentro servicecentro;
	/**
	 * Service dei parametri 
	 */
	private ServiceParametri serviceparametri;
	/**
	 * Inizializzazione della lista operatori;
	 */
	private List<Operatore> operatori = new ArrayList<>(); 
	/**
	 * Repository per l'accesso ai dati degli operatori 
	 */
	private RepositoryOperatore repositoryoperatori = new RepositoryOperatore();
	/**
	 * Costruttore della classe ServiceOperatore 
	 */
	public ServiceOperatore() {
		this.caricaOperatori();
	}
	/**
	 * Carica gli operatori dal Repository e li memorizza nella lista operatori
	 */
	public void caricaOperatori () {
		this.operatori = repositoryoperatori.findAll();
	}
	public Operatore creaOperatore(Operatore o) {
		try {
			return repositoryoperatori.save(o);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Operatore login(String username, String password) {
		Operatore o = new Operatore();
		o.setEmail(username);
		o.setPassword(password);
		try {
			return repositoryoperatori.findOperatore(o);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Restituisce l'operatore con l'ID specificato
	 * @param idoperatore
	 * @return L'operatore con l'id specificato, o null se non trovato
	 */
	public Operatore getOperatorebyId (Integer idoperatore) {
		if(idoperatore == null) return null;
		return operatori.stream().filter(c -> c.getIdoperatore() == idoperatore).findFirst().orElse(new Operatore());
	} 
	/**
	 * Restituisce la lista di operatori associati a un determinato centro di monitoraggio
	 * @param cm Centro di monitoraggio per il quale ottenere gli operatori
	 * @return Lista degli operatori associati al centro di monitoraggio
	 */
	public List<Operatore> getOperatoriListByCentro (CentroDiMonitoraggio cm){
		return operatori.stream().filter(o -> o.getIDCentro() == cm.getIdcentro()).collect(Collectors.toList());
	}
	public void associaCentro(Operatore o, CentroDiMonitoraggio cm) {
		o.setIDCentro(cm.getIdcentro());
		repositoryoperatori.update(o);
	}
	/**
	 * Metodo utilizzato per mappare informazioni aggiuntive degli operatori come i parametri climatici e il centro di monitoraggio associato.
	 * @param o Operatore da mappare
	 */
		private void operatoreMapper (Operatore o) {
		o.setParametriclimatici(this.serviceparametri.getParametriListByOperatore(o.getIdoperatore()));
		o.setCentrodimonitoraggio(this.servicecentro.getCentroById(o.getIDCentro()));
		}
		/**
		 * Arricchisce gli operatori con informazioni sui parametri climatici e il centro di monitoraggio associato.
		 * @param sc Service del Centro 
		 * @param sp Service dei Parametri climatici
		 */
	public void enrichOperatori (ServiceCentro sc, ServiceParametri sp) {
		this.servicecentro = sc;
		this.serviceparametri = sp;
		this.operatori.stream().forEach(o -> this.operatoreMapper(o));
		
	}
}
