package Service;
import Repository.RepositoryGuest;
import Repository.RepositoryInterface;

import java.util.ArrayList;
import java.util.List;

import Model.Guest;

/**
 * La classe ServiceGuest gestisce le operazioni relative agli ospiti.
 * Utilizza un repository per accedere ai dati degli ospiti dal database e fornisce metodi
 * per caricare, recuperare e visualizzare informazioni sugli ospiti.
 * 
 * @author alequ
 * @see RepositoryGuest
 * @see RepositoryInterface
 * @see Guest
 */
public class ServiceGuest {
/**
 * Inizializzazione di una lista che conterrà tutti i guest
*/
private List<Guest> guest = new ArrayList<>();
/**
 * Viene istanziato un RepositoryGuest per l'accesso ai dati degli ospiti nel database
 */
private RepositoryInterface<Guest> repositoryguest = new RepositoryGuest();
	
/**
 * Costruttore di default che inizializza il servizio caricando gli ospiti dal repository 
 */
	public ServiceGuest() {
}
	/**
	 * Carica tutti i guest dal repository e li memorizza nella lista interna al servizio
	 */
 public void CaricaGuest() {
	 this.guest = repositoryguest.findAll();
 }
 /**
  * Restituisce il guest corrispondente all'id specificato
  * @param id l'ID del guest da cercare
  * @return Il guest corrispondente all'ID, o un nuovo oggetto Guest se non trovato
  */
	public Guest getGuestByID(int id) {
		return guest.stream().filter(c -> c.getId() == id).findFirst().orElse(new Guest());
	}
	
	

}
