package Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.Operatore;
import Model.ParametriClimatici;
import Repository.RepositoryInterface;
import Repository.RepositoryParametriClimatici;

/**
 * La classe ServiceParametri fornisce servizi per la gestione dei parametri climatici.
 * Include metodi per caricare, ottenere e arricchire i dati relativi ai parametri climatici.
 * @author alequ
 * @see Operatore 
 * @see ParametriClimatici
 * @see RepositoryInterface
 * @see RepositoryParametriClimatici
 */
public class ServiceParametri {
	/**
	 * Inizializzazione lista che conterrà i parametri climatici.
	 */
	private List<ParametriClimatici> parametri = new ArrayList<>();
	/**
	 * Repository per l'accesso ai dati dei parametri climatici
	 */
	private RepositoryInterface<ParametriClimatici> repositoryparametri = new RepositoryParametriClimatici();
	/**
	 * Service dell'operatore
	 */
	private ServiceOperatore serviceoperatore;
	/**
	 * Service delle coordinate 
	 */
	private ServiceCoordinate servicecoordinate;

	/**
	 * Costruttore della classe ServiceParametri
	 */
	public ServiceParametri() {
	}
	/**
	 * Carica tutti i parametri climatici dal repository
	 */
	 public void CaricaParametri() {
		 this.parametri = repositoryparametri.findAll();
	 }
	 /**
	  * Restituisce un parametro climatico in base all'id specificato
	  * @param idparametro L'id del parametro climatico
	  * @return Il parametro climatico corrispondente all'Id specificato, o un nuovo oggetto ParametriClimatici se non trovato. 
	  */
	public ParametriClimatici getParametriById (int idparametro) {
		return parametri.stream().filter(c -> c.getIdparametro() == idparametro).findFirst().orElse(new ParametriClimatici());
	}
	/**
	 * Restituisce una lista di parametri climatici associati a un operatore specificato
	 * @param idOperatore L'id dell'operatore 
	 * @return una lista di parametri climatici associati all'operatore specificato.
	 */
	public List<ParametriClimatici> getParametriListByOperatore (int idOperatore){
		return this.parametri.stream().filter(p -> p.getIdoperatore() == idOperatore).collect(Collectors.toList());
	}
	/**
	 * Mappa i dati aggiuntivi sugli operatori e sulle coordinate per ogni parametro climatico
	 * @param p Il parametro climatico da arricchire
	 */
	private void parametriMapper (ParametriClimatici p) {
		p.setOperatore(serviceoperatore.getOperatorebyId(p.getIdoperatore()));
		p.setCoordinatedimonitoraggio(servicecoordinate.getCoordinatebyGeoname(p.getGeoname()));
	
	}
	/**
	 * Arricchisce i dati relativi ai parametri climatici con l'operatore e le coordinate di monitoraggio associate.
	 * @param so Service dell'operatore
	 * @param sc Service delle coordinate
	 */
public void enrichParametri (ServiceOperatore so, ServiceCoordinate sc) {
	this.servicecoordinate = sc;
	this.serviceoperatore = so; 
	this.parametri.forEach(p -> this.parametriMapper(p));
}
}
