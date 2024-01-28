package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Model.Operatore; 
import DB.DBO;
/**
 * La classe RepositoryOperatore implementa l'interfaccia RepositoryInterface<Operatore> 
 * per la gestione dei dati degli operatori nel database.
 * 
 * @author alequ
 * @see RepositoryInterface
 * @see Operatore
 * @see DBO
 */
public class RepositoryOperatore implements RepositoryInterface<Operatore> {
	/**
	 * Inizializzazione di una lista di operatori 
	 */
	private List<Operatore> operatori = new ArrayList<>();
	@Override
	/**
	 * Recupera tutti gli operatori dal database
	 * @return una lista di tutti gli operatori nel database 
	 */
	public List<Operatore> findAll() {
		String query = "Select * From operatore";
		ResultSet results = DBO.executeQuery(query);
		if(results != null) {
			if(operatori.size() > 0) operatori.clear();
			try {
				while(results.next()) {
					operatori.add(createOperatore(results));
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return operatori;
	}
	
	public Operatore findOperatore(Operatore o) throws SQLException {
		String query = "Select * From operatore WHERE email =" + o.getEmail() + ",passwordutente =" +o.getPassword() + ";";
		ResultSet results = DBO.executeQuery(query);
		if (!results.isBeforeFirst()) return null;
		return createOperatore(results);
	}

	@Override
	/**
	 * Salva un nuovo operatore nel database 
	 * @param o l'operatore da salvare 
	 * @return l'operatore appena salvato
	 */
	public Operatore save(Operatore o) throws SQLException {
		String query = "Insert into operatore (nome,cognome,cf,email,passwordutente,idcentro) Values (";
		query += o.getNome() + "," + o.getCognome() + "," + o.getCf() + "," + o.getEmail() + "," + o.getPassword();
		query += "," + o.getIDCentro() + ");"; 
		DBO.executeQuery(query);
		return findOperatore(o);
	}

	@Override
	/**
	 * Aggiorna un operatore esistente nel database 
	 * @param o L'operatore da aggiornare 
	 * @return l'operatore appena aggiornato 
	 */
	public Operatore update(Operatore o) {
	    String query = "Update operatore Set nome =" + o.getNome() + ",cognome =" + o.getCognome() + ",cf =" + o.getCf() + ",email =" + o.getEmail() +",passwordutente =" +o.getPassword();
	    query += ",idcentro =" + o.getIDCentro() +"WHERE idoperatore=" + o.getIdoperatore() + ";"; 
	   DBO.executeQuery(query);
	    return o;
	}

	@Override
	/**
	 * Elimina un operatore dal database
	 * @param o L'operatore da eliminare 
	 */
	public void delete(Operatore o) {
	    String query = "Delete From operatore Where idoperatore=" + o.getIdoperatore() + ";" ;
	    DBO.executeQuery(query);
	}

		
	/**
	 * Crea un oggetto  Operatore a partire da un ResultSet.
	 * @param result il ResultSet contenente i dati dell'operatore
	 * @return un oggetto Operatore
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati nel ResultSet
	 */
	private static Operatore createOperatore(ResultSet result) throws SQLException {
		Operatore o = new Operatore();
		o.setNome(result.getString("nome"));
		o.setCognome(result.getString("cognome"));
		o.setCf(result.getString("cf"));
		o.setEmail(result.getString("email"));
		o.setIDCentro(result.getInt("idcentro"));
		o.setIdoperatore(result.getInt("idoperatore"));
		return o;
	} 
}