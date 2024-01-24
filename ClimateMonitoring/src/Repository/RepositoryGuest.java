package Repository;

import Model.Guest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBO;

/**
 * La classe {@code RepositoryGuest} implementa l'interfaccia {@code RepositoryInterface<Guest>}
 * per la gestione dei dati relativi ai guest nel database.
 * 
 * 
 * @author alequ
 * @see RepositoryInterface
 * @see DBO
 * 
 */
public class RepositoryGuest implements RepositoryInterface<Guest> {
/**
 * Costruttore vuoto della classe RepositoryGuest
 */
	public RepositoryGuest() {	
	}
	@Override
	/**
	 * Recupera tutti i guest dal database.
	 * 
	 * @return una lista di tutti i guest nel database
	 */
	public List<Guest> findAll() {
		List<Guest> guest = new ArrayList<>();
		String query = "Select * From guest";
		ResultSet results = DBO.executeQuery(query);
		if(results != null) {
			if(guest.size() > 0) guest.clear();
			try {
				while(results.next()) {
					guest.add(createGuest(results));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return guest;
	}

	@Override
	/**
	 * Salva un nuovo guest nel database.
	 * 
	 * @param g il guest da salvare
     * @return il guest appena salvato
	 */
	public Guest save(Guest g) {
		String query = "Insert into guest (accesso,ID,name) Values (";
		query += g.getAccesso() + "," + g.getId() + "," + g.getNome() + ";"; 
		DBO.executeQuery(query);
		return g;
	}
/**
 *  Aggiorna un guest esistente nel database.
     *
     * @param g il guest da aggiornare
     * @return il guest appena aggiornato
 */
	@Override
	public Guest update(Guest g) {
	    String query = "Update guest Set accesso= " + g.getAccesso() + ",name=" + g.getNome() +  "Where ID =" + g.getId() + ";";
	    DBO.executeQuery(query);
	    return g; 
	}
/**
 * Elimina un guest dal database.
 *
 * @param g il guest da eliminare
 */
	@Override
	public void delete(Guest g) {
	    String query = "Delete From guest Where id=" + g.getId() + ";";
	    DBO.executeQuery(query);
	}

		
	/**
	 * Crea un oggetto Guest a partire da un result set.
	 * @param result Il ResultSet contenente i dati del guest
	 * @return un oggetto Guest
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati nel ResultSet
	 */
	private static Guest createGuest (ResultSet result) throws SQLException {
		Guest g = new Guest();
		g.setAccesso(result.getTime("timestamp"));
		g.setId(result.getInt("ID"));
		g.setNome(result.getString("name"));

		return g;
	} 
}