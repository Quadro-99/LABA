package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ParametriClimatici; 
import DB.DBO;
/**
 * La classe RepositoryParametriClimatici implementa l'interfaccia RepositoryInterface<ParametriClimatici>
 * per la geestione dei dati relativi ai parametri climatici nel database
 * 
 * @author alequ
 * @see RepositoryInterface
 * @see ParametriClimatici
 * @see DBO
 */
public class RepositoryParametriClimatici implements RepositoryInterface<ParametriClimatici> {
	/**
	 * Inizializzazione di una lista contenente dei parametri climatici
	 */
	private List<ParametriClimatici> parametri = new ArrayList<>();
	
	@Override
	/**
	 * Recupera tutti i parametri climatici dal database.
     * @return una lista di tutti i parametri climatici 
	 */
	public List<ParametriClimatici> findAll() {
		String query = "Select * From parametriclimatici";
		ResultSet results = DBO.executeQuery(query);
		if(results != null) {
			if(parametri.size() > 0) parametri.clear();
			try {
				while(results.next()) {
					parametri.add(createParametri(results));
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return parametri;
	}
/**
 * Salva dei nuovi parametri climatici nel database.
 * @param p i parametri climatici da salvare
 * @return i parametri climatici appena salvati
 */
	@Override
	public ParametriClimatici save(ParametriClimatici p) {
		String query = "Insert into parametriclimatici (geoname,datarilevazione,vento,umidità,pressione,temperatura,precipitazioni,altitudineghiacciai,massaghiacciai,note,idcentro,idparametro) Values (";
		query +=  p.getGeoname() + "," + p.getDataRilevazione() + "," + p.getVento() + "," + p.getUmidità();
		query += "," + p.getPressione() + "," + p.getTemperatura() + ","+ p.getPrecipitazioni() + "," + p.getAltitudineGhiacciai() + "," + p.getMassaGhiaciai() + "," + p.getNote() + p.getIdcentro() +  "," + p.getIdparametro() + ");"; 
		DBO.executeQuery(query);
		return p;
	}
/**
 * Aggiorna dei parametri climatici nel database.
 * @param p i parametri climatici da aggiornare
 * @return il parametri climatici appena aggiornati
 */
	@Override
	public ParametriClimatici update(ParametriClimatici p) {
		String query = "Update parametriclimatici Set geoname =" + p.getGeoname() + ",datarilevazione =" + p.getDataRilevazione() + ",vento =" + p.getVento() + ",umidità =" + p.getUmidità() + ",pressione =" + p.getPressione() + ",temperatura =" + p.getTemperatura();
		query += ",precipitazioni =" + p.getPrecipitazioni() +",altitudineghiacciai =" + p.getAltitudineGhiacciai() + ",note =" + p.getNote() +",idcentro = " + p.getIdcentro() +"WHERE idparametro=" + p.getIdparametro() + ";";
		DBO.executeQuery(query);
		return p; 
	}
/**
 *  Elimina dei parametri climatici dal database.
 * @param p i parametri climatici da eliminare
 */
	@Override
	public void delete(ParametriClimatici p) {
		 String query = "Delete From parametriclimatici Where idparametri =" + p.getIdparametro() + ";";
		 DBO.executeQuery(query); 
		
		;
		   
	}

		
/**	
 *  Crea un oggetto ParametriClimatici a partire da un ResultSet.
 * @param result il ResultSet contenente i dati del parametro climatico
 * @return un oggetto ParametriClimatici
 * @throws SQLException se si verifica un errore durante l'accesso ai dati nel ResultSet
 */
	private static ParametriClimatici createParametri(ResultSet result) throws SQLException {
		ParametriClimatici p = new ParametriClimatici();
		
		p.setGeoname(result.getInt("geoname"));
		p.setDataRilevazione(result.getDate("datarilevazione"));
		p.setVento(result.getInt("vento"));
		p.setUmidità(result.getInt("umidità"));
		p.setPressione(result.getInt("pressione"));
		p.setTemperatura(result.getInt("temperatura"));
		p.setPrecipitazioni(result.getInt("precipitazioni"));
		p.setAltitudineGhiacciai(result.getInt("altitudineghiacciai"));
		p.setMassaGhiacciai(result.getInt("massaghiacciai"));
		p.setNote(result.getString("note"));
		p.setIdcentro(result.getInt("idcentro"));
		p.setIdparametro(result.getInt("idparametro"));
		return p;
	} 
}
