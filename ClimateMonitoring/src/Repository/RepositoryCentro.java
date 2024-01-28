package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

	import Model.CentroDiMonitoraggio; 
	import DB.DBO;
	/**
	 * La classe RepositoryCentro implementa l'interfaccia RepositoryInterface<CentroDiMonitoraggio>
	 * per la gestione dei dati relativi ai centri di monitoraggio nel database.
	 * Fornisce metodi per recuperare tutti i centri di monitoraggio, salvare un nuovo centro,
	 * aggiornare un centro esistente e eliminare un centro dal database.
	 * 
	 * @see RepositoryInterface
	 * @see CentroDiMonitoraggio
	 * @see DBO
	 * 
	 *
	 */
	public class RepositoryCentro implements RepositoryInterface<CentroDiMonitoraggio> {
		/**
		 * Costruttore vuoto della classe RepositoryCentro
		 */
		public RepositoryCentro () {
		}
		/**
		 * Recupera tutti i centri di monitoraggio dal database
		 * 
		 * @return una lista di tutti i centri di monitoraggio nel database
		 */
		@Override
		public List<CentroDiMonitoraggio> findAll() {
			List<CentroDiMonitoraggio> centri = new ArrayList<>();
			String query = "Select * From centromonitoraggio";
			ResultSet results = DBO.executeQuery(query);
			if(results != null) {
				if(centri.size() > 0) centri.clear();
				try {
					while(results.next()) {
						centri.add(createCentro(results));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return centri;
		}
		
		private CentroDiMonitoraggio findLastInsert(CentroDiMonitoraggio c) {
			List<CentroDiMonitoraggio> centri = new ArrayList<>();
			String query = "Select * From centromonitoraggio where indirizzo = " + c.getIndirizzo() + " AND centroname = " + c.getCentroname() + ";";
			ResultSet results = DBO.executeQuery(query);
			if(results != null) {
				if(centri.size() > 0) centri.clear();
				try {
					while(results.next()) {
						centri.add(createCentro(results));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return centri.stream().max(Comparator.comparing(CentroDiMonitoraggio::getIdcentro)).orElse(new CentroDiMonitoraggio());
		}
/**
 * Salva un nuovo centro di monitoraggio nel database attraverso una query SQL
 * 
 * @param c, è il centro di monitoraggio da salvare 
 * @return il centro di monitoraggio appena salvato
 */
		@Override
		public CentroDiMonitoraggio save(CentroDiMonitoraggio c) {
			String query = "Insert into centromonitoraggio (indirizzo,centroname) Values (";
			query += c.getIndirizzo() + "," + c.getCentroname();
			query += ");";
			DBO.executeQuery(query);
			return findLastInsert(c);
		}
/**
 * Aggiorna il centro di monitoraggio attraverso una query SQL
 * @param c è il centro di monitoraggio da aggiornare
 * @return il centro di monitoraggio appena aggiornato
 */
		@Override
		public CentroDiMonitoraggio update(CentroDiMonitoraggio c) {
		    String query = "Update centrodimonitoraggio Set indirizzo= " + c.getIndirizzo() + ",centroname= " + c.getCentroname() + "Where idcentro =" + c.getIdcentro() + ";";
		    DBO.executeQuery(query);
		    return c; 
		}
/**
 * Elimina un centro di monitoraggio dal database 
 * @param c il centro di monitoraggio da eliminare
 */
		@Override
		public void delete(CentroDiMonitoraggio c) {
		    String query = "Delete From operatore Where idcentro=" + c.getIdcentro() + ";";
		    DBO.executeQuery(query);
		}

			
	/**
	 * Crea un oggetto CentroDiMonitoraggio a partire da un ResultSet
	 * 	
	 * @param result Il ResultSet che contiene i dati del centro di monitoraggio
	 * @return un oggetto CentroDiMonitoraggio
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati nel ResultSet
	 */
		private static CentroDiMonitoraggio createCentro (ResultSet result) throws SQLException {
			CentroDiMonitoraggio c = new CentroDiMonitoraggio();
			c.setCentroname(result.getString("centroname"));
			c.setIndirizzo(result.getString("Indirizzo"));
			c.setIdcentro(result.getInt("idcentro"));
	
			return c;
		} 
	}