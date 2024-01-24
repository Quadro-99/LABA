package Model;
import java.sql.Time;

/**
 * La classe rappresenta un Guest con le relative informazioni.
 * 
 * @author alequ
 *
 */
public class Guest {
/**
 * Id univoco del guest.
 */
private int id;
/**
 * Nome del guest
 */
private String nome;
/**
 * Orario di accesso del guest.
 */
private Time accesso;


/**
 * Costruttore vuoto della classe guest
 */
public Guest() {
	
}
/**
 * Restituisce l'id del guest
 * @return Id del guest
 */
public int getId() {
	return id;
}
/**
 * Imposta l'id del guest
 * @param id, nuovo id del guest
 */
public void setId(int id) {
	this.id = id;
}
/**
 * Restituisce il nome del guest
 * @return il nome del guest
 */
public String getNome() {
	return nome;
}
/**
 * Imposta il nome del guest
 * @param nome, il nuovo nome dell'ospite.
 */
public void setNome(String nome) {
	this.nome = nome;
}
/**
 * Restituisce l'orario di accesso del guest
 * @return l'orario di accesso del guest.
 */
public Time getAccesso() {
	return accesso;
}
/**
 * Imposta l'orario di accesso del guest
 * @param time, il nuovo orario di accesso dell'ospite
 */
public void setAccesso(Time time) {
	this.accesso = time;
}


}
