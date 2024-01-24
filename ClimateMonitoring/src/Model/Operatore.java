package Model;
import java.util.List;
/**
 * La classe rappresenta un operatore con le relative informazioni.
 * 
 * @author alequ
 *
 */
public class Operatore {
/**
 * Nome dell'operatore
 */
private String nome;
/**
 * Cognome dell'operatore
 */
private String cognome;
/**
 * Codice fiscale dell'operatore
 */
private String cf;
/**
 * email dell'operatore 
 */
private String email; 
/**
 * Password dell'operatore
 */
private String password;
/**
 * ID univoco dell'operatore
 */
private Integer idoperatore;
/**
 * Id del centro associato all'operatore
 */
private Integer idcentro;
/**
 * Lista di parametri climatici associati all'operatore 
 */
private List<ParametriClimatici> parametriclimatici;
/**
 * Riferimento al centro di monitoraggio associato all'operazione
 */
private CentroDiMonitoraggio centrodimonitoraggio; 


/**
 * Costruttore vuoto della classe Operatore.
 */
public Operatore() {
	
}
/**
 * Restituisce il codice fiscale dell'operatore
 * @return il codice fiscale dell'operatore
 */
public String getCf() {
	return cf;
}
/**
 * Imposta il codice fiscale dell'operatore
 * @param cf, il nuovo cf dell'operatore
 */
public void setCf(String cf) {
	this.cf = cf;
}
/**
 * Restituisce la lista di parametri climatici associati all'operatore
 * @return la lista dei parametri climatici associati
 */
public List<ParametriClimatici> getParametriclimatici() {
	return parametriclimatici;
}
/**
 * Imposta la lista dei parametri climatici associati all'operatore.
 * @param parametriclimatici, la nuova lista dei parametri climatici
 */
public void setParametriclimatici(List<ParametriClimatici> parametriclimatici) {
	this.parametriclimatici = parametriclimatici;
}
/**
 * Restituisce il riferimento al centro di monitoraggio associato all'operatore
 * @return il riferimento al centro di monitoraggio associato.
 */
public CentroDiMonitoraggio getCentrodimonitoraggio() {
	return centrodimonitoraggio;
}
/**
 * IMposta il riferimento al centro di monitoraggio associato all'operazione 
 * @param centrodimonitoraggio, il nuovo riferimento al centro di monitoraggio associato.
 */
public void setCentrodimonitoraggio(CentroDiMonitoraggio centrodimonitoraggio) {
	this.centrodimonitoraggio = centrodimonitoraggio;
}
/**
 * Restituisce il nome dell'operatore 
 * @return il nome dell'operatore
 */
public String getNome() {
	return nome;
}
/**
 * Imposta il nome dell'operatpore
 * @param nome, il nuovo nome dell'operatore
 */
public void setNome(String nome) {
	this.nome = nome;
}
/**
 * Restituisce il cognome dell'operatore
 * @return il cognome dell'operatore
 */
public String getCognome() {
	return cognome;
}
/**
 * Imposta il cognome dell'operatore
 * @param cognome, il nuovo cognome dell'operatore
 */
public void setCognome(String cognome) {
	this.cognome = cognome;
}
/**
 * Restituisce l'email dell'operatore 
 * @return l'email dell'operatore 
 */
public String getEmail() {
	return email;
}
/**
 * Imposta l'email dell'operatore 
 * @param email, la nuova email dell'operatore
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * Restituisce la password dell'operatore
 * @return la password dell'operatore
 */
public String getPassword() {
	return password;
}
/**
 * Imposta la password dell'operatore
 * @param password, la nuova password dell'operatore
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * Restituisce l'Id del centro associato all'operatore.
 * @return L'ID del centro
 */
public int getIDCentro() {
	return idcentro;
}
/**
 * Imposta L'ID del centro associato all'operatore
 * @param idcentro, il nuovo Id del centro associato
 */
public void setIDCentro(int idcentro) {
	this.idcentro = idcentro;
}
/**
 * Restituisce l'id univoco dell'operatore.
 * @return L'id dell'operatore
 */
public int getIdoperatore() {
	return idoperatore;
}
/**
 * Imposta L'id univoco dell'operatore.
 * @param idoperatore, il nuovo id dell'operatore
 */
public void setIdoperatore(int idoperatore) {
	this.idoperatore = idoperatore;
}







}
