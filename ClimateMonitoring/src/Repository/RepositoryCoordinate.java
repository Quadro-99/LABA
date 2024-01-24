package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.CoordinateMonitoraggio; 
import DB.DBO;
/**
 * La classe RepositoryCoordinate implementa l'interfaccia RepositoryInterface<CoordinateMonitoraggio>
 * per la gestione dei dati relativi alle coordinate di monitoraggio nel database 
 * 
 * @author alequ
 * 
 * @see RepositoryInterface
 * @see CoordinateMonitoraggio
 * @see DBO
 * 
 */
public class RepositoryCoordinate implements RepositoryInterface<CoordinateMonitoraggio> {
	/**
	 * Lista delle coordinate di monitoraggio
	 */
	private List<CoordinateMonitoraggio> coordinate = new ArrayList<>();
	@Override
	/**
	 * Recupera tutte le coordinate di monitoraggio dal database
	 * 
	 * @return una lista con tutte le coordinate di monitoraggio 
	 */
	public List<CoordinateMonitoraggio> findAll() {
		String query = "Select * From coordinatedimonitoraggio";
		ResultSet results = DBO.executeQuery(query);
		if(results != null) {
			if(coordinate.size() > 0) coordinate.clear();
			try {
				while(results.next()) {
					coordinate.add(createCoordinate(results));
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return coordinate;
	}

	@Override
	/**
	 * Salva nuove coordinate di monitoraggio nel database 
	 * 
	 * @param co le coordinate di monitoraggio da salvare
	 * @return le coordinate di monitoraggio appena salvate 
	 */
	public CoordinateMonitoraggio save(CoordinateMonitoraggio co) {
		String query = "Insert into coordinatedimonitoraggio (idcentro,geoname,nomearea,stato,latitudine,longitudine) Values (";
		query += co.getIdcentro() + "," + co.getGeoname() + "," + co.getNomeArea() + "," + co.getStato() + "," + co.getLatitudine();
		query += co.getLongitudine();
		DBO.executeQuery(query);
		return co;
	}

	@Override
	/**
	 * Aggiorna delle coordinate di monitoraggio esistenti nel database 
	 * 
	 * @param co le coordinate di monitoraggio da aggiornare 
	 * @return le coordinate di monitoraggio appena aggiornate 
	 */
	public CoordinateMonitoraggio update(CoordinateMonitoraggio co) {
	    String query = "Update coordinatemonitoraggio Set idcentro=" + co.getIdcentro() + ",nomearea=" + co.getNomeArea() + ";stato =" + co.getStato();
	    query +=  ",latitudine= " + co.getLatitudine() + ",longitudine= " + co.getLongitudine() + "where geoname=" + co.getGeoname() + ";";
	    DBO.executeQuery(query);
	    return co;
	}

	@Override
	/**
	 * Elimina delle coordinate di monitoraggio dal database
	 * @param co le coordinate di monitoraggio da eliminare 
	 */
	public void delete(CoordinateMonitoraggio co) {
	    String query = "Delete From coordinatedimonitoraggio Where geoname=" + co.getGeoname() + ";";
	    DBO.executeQuery(query);
	}

		
	/**
	 * Crea un oggetto CoordinateMonitoraggio a partire da un ResultSet
	 * @param result Il ResultSet contenente i dati delle coordinate di monitoraggio
	 * @return un oggetto CoordinateMonitoraggio
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati nel ResultSet
	 */
	private static CoordinateMonitoraggio createCoordinate(ResultSet result) throws SQLException {
		CoordinateMonitoraggio co = new CoordinateMonitoraggio();
		co.setIdcentro(result.getInt("idcentro"));
		co.setGeoname(result.getInt("geoname"));
		co.setNomeArea(result.getString("nomearea"));
		co.setStato(result.getString("stato"));
		co.setLatitudine(result.getDouble("Latitudine"));
		co.setLongitudine(result.getDouble("Longitudine"));
		return co;
	} 
}