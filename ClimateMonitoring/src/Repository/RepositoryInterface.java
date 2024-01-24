package Repository;

import java.sql.SQLException;
import java.util.List;
/**
 * L'interfaccia RepositoryInterface<T> fornisce i metodi base per la gestione 
 * di operazioni di Lettura,Creazione, aggiornamento e cancellazione dei dati nel database
 * 
 * @author alequ
 * @param <T> il tipo di entità gestita dal repository
 */
public interface RepositoryInterface<T> {
	/**
	 * Recupera gli oggetti di tipo<T> dal database
	 * @return una lista contenente tutti gli oggetti di tipo<T> 
	 */
	public List<T> findAll();
	/**
	 * Salva un nuovo oggetto <T> nel Database 
	 * @param t L'oggetto da salvare
	 * @return l'oggetto <T> appena salvato
	 */
	public T save (T t);
	/**
 	 * Aggiorna un oggetto T esistente nel database.
     * @param t l'oggetto da aggiornare
     * @return l'oggetto appena aggiornato
     * @throws SQLException se si verifica un errore durante l'operazione di aggiornamento
	 */
	public T update(T t) throws SQLException;
	/**
	 * Elimina un oggetto <T> dal Database
	 * @param t l'oggetto da eliminare
	 */
	public void delete(T t);
	
}
