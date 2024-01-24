package Model;
import java.util.Date;
/**
 *La classe parametri climatici rappresenta i parametri climatici con le relative informazioni.
 *
 * @author alequ
 *
 */
public class ParametriClimatici {
/**
 * Note associate ai parametri climatici
 */
private String note;
/**
 * Geoname associato ai parametri climatici
 */
private int geoname;
/**
 * Velocità del vento
 */
private int vento; 
/**
 * Umidità dell'aria
 */
private int umidità;
/**
 * pressione atmosferica
 */
private int pressione; 
/**
 * temperatura
 */
private int temperatura;
/**
 * Precipitazioni
 */
private int precipitazioni; 
/**
 * Altitudine dei ghiacciai 
 */
private int altitudineGhiacciai; 
/**
 * Massa dei ghiacciai
 */
private int massaGhiacciai;
/**
 * La data di rilevazione dei parametri climatici
 */
private Date dataRilevazione;
/**
 * Riferimento al centro di monitoraggio associato
 */
private CentroDiMonitoraggio centro;
/**
 * Riferimento alle coordinate di monitoraggio associate
 */
private Operatore operatore;
/**
 * Riferimento all'operatore associato
 */
private Integer idparametro;
/**
 * L'ID del parametro climatico associato
 */
private Integer idoperatore;
/**
 * Il riferimento alle coordinate di monitoraggio associate
 */
private CoordinateMonitoraggio coordinatedimonitoraggio;
/**
 * L'id del centro di monitoraggio associato. 
 */
private Integer idcentro;

/**
 * Costruttore vuoto della classe ParametriClimatici
 */
public ParametriClimatici() {
	
}

/**
 * Restituisce il riferimento all'operatore associato.
 * @return il riferimento all'operatore associato
 */
public Operatore getOperatore() {
	return operatore;
}
/**
 * Imposta il riferimento all'operatore associato.
 * @param operatore, il nuovo riferimento all'operatore
 */
public void setOperatore(Operatore operatore) {
	this.operatore = operatore;
}
/**
 * Restituisce il riferimento al centro di monitoraggio associato
 * @return il riferimento al centro associato
 */
public CentroDiMonitoraggio getCentro() {
	return centro;
}
/**
 * Imposta il riferimento al centro di monitoraggio associato
 * @param centro, il nuovo riferimento al centro di monitoraggio
 */
public void setCentro(CentroDiMonitoraggio centro) {
	this.centro = centro;
}
/**
 * Restituisce le note associate ai parametri climatici
 * @return le note associate ai parametri 
 */
public String getNote() {
	return note;
}
/**
 * Imposta le note associate ai parametri climatici.
 * @param note, le nuove note associate
 */
public void setNote(String note) {
	this.note = note;
}
/**
 * Restituisce il geoname associato ai parametri climatici.
 * @return il geoname associato
 */
public int getGeoname() {
	return geoname;
}
/**
 * Imposta il geoname associato ai parametri climatici.
 * @param geoname, il nuovo geoname associato
 */
public void setGeoname(int geoname) {
	this.geoname = geoname;
}
/**
 * Restituisce la velocità del vento.
 * @returnla velocità del vento
 */
public int getVento() {
	return vento;
}
/**
 * Imposta la velocità del vento.
 * @param vento, la nuova velocità del vento
 */
public void setVento(int vento) {
	this.vento = vento;
}
/**
 * Restituisce l'umidità dell'aria.
 * @return l'umidità dell'aria
 */
public int getUmidità() {
	return umidità;
}
/**
 * Imposta l'umidità dell'aria.
 * @param umidità, la nuova umidità dell'aria
 */
public void setUmidità(int umidità) {
	this.umidità = umidità;
}
/**
 * Restituisce la pressione atmosferica.
 * @return la pressione atmosferica
 */
public int getPressione() {
	return pressione;
}
/**
 * Imposta la pressione atmosferica.
 * @param pressione, la nuova pressione atmosferica
 */
public void setPressione(int pressione) {
	this.pressione = pressione;
}
/**
 * Restituisce la temperatura.
 * @return la temperatura
 */
public int getTemperatura() {
	return temperatura;
}
/**
 * Imposta la temperatura.
 * @param temperatura, la nuova temperatura
 */
public void setTemperatura(int temperatura) {
	this.temperatura = temperatura;
}
/**
 * Restituisce le precipitazioni.
 * @return le precipitazioni
 */
public int getPrecipitazioni() {
	return precipitazioni;
}
/**
 * Imposta le precipitazioni.
 * @param precipitazioni, le nuove precipitazioni
 */
public void setPrecipitazioni(int precipitazioni) {
	this.precipitazioni = precipitazioni;
}
/**
 * Restituisce l'altitudine dei ghiacciai.
 * @return l'altitudine dei ghiacciai
 */
public int getAltitudineGhiacciai() {
	return altitudineGhiacciai;
}
/**
 * Imposta l'altitudine dei ghiacciai
 * @param altitudineGhiacciai, la nuova altitudine dei ghiacciai
 */
public void setAltitudineGhiacciai(int altitudineGhiacciai) {
	this.altitudineGhiacciai = altitudineGhiacciai;
}
/**
 * Restituisce la massa dei ghiacciai.
 * @return la massa dei ghiacciai
 */
public int getMassaGhiaciai() {
	return massaGhiacciai;
}
/**
 * Imposta la massa dei ghiacciai.
 * @param massaGhiacciai, la nuova massa dei ghiacciai
 */
public void setMassaGhiaciai(int massaGhiacciai) {
	this.massaGhiacciai = massaGhiacciai;
}
/**
 * Restituisce la data di rilevazione dei parametri climatici.
 * @return la data di rilevazione
 */
public Date getDataRilevazione() {
	return dataRilevazione;
}
/**
 * Imposta la data di rilevazione dei parametri climatici.
 * @param dataRilevazione, la nuova data di rilevazione
 */
public void setDataRilevazione(Date dataRilevazione) {
	this.dataRilevazione = dataRilevazione;
}
/**
 * Restituisce la massa dei ghiacciai.
 * @return la massa dei ghiacciai
 */
public int getMassaGhiacciai() {
	return massaGhiacciai;
}
/**
 * Imposta la massa dei ghiacciai.
 * @param massaGhiacciai, la nuova massa dei ghiacciai
 */
public void setMassaGhiacciai(int massaGhiacciai) {
	this.massaGhiacciai = massaGhiacciai;
}
/**
 * Restituisce l'ID del parametro climatico.
 * @returnl'ID del parametro climatico
 */
public int getIdparametro() {
	return idparametro;
}
/**
 * Imposta l'ID del parametro climatico.
 * @param idparametro,  il nuovo ID del parametro climatico
 */
public void setIdparametro(int idparametro) {
	this.idparametro = idparametro;
}
/**
 * Restituisce l'ID del centro associato.
 * @return  l'ID del centro associato
 */
public int getIdcentro() {
	return idcentro;
}
/** Imposta l'ID del centro associato.
 * 
 * @param idcentro, il nuovo ID del centro associato
 */
public void setIdcentro(int idcentro) {
	this.idcentro = idcentro;
}
/**
 * Restituisce l'ID dell'operatore associato.
 * @return l'ID dell'operatore associato
 */
public int getIdoperatore() {
	return idoperatore;
}
/**
 * Imposta l'ID dell'operatore associato.
 * @param idoperatore, il nuovo ID dell'operatore associato
 */
public void setIdoperatore(int idoperatore) {
	this.idoperatore = idoperatore;
}
/**
 * Restituisce il riferimento alle coordinate di monitoraggio associate.
 * @return il riferimento alle coordinate di monitoraggio
 */
public CoordinateMonitoraggio getCoordinatedimonitoraggio() {
	return coordinatedimonitoraggio;
}
/**
 * Imposta il riferimento alle coordinate di monitoraggio associate
 * @param coordinatedimonitoraggio, il nuovo riferimento alle coordinate di monitoraggio
 */
public void setCoordinatedimonitoraggio(CoordinateMonitoraggio coordinatedimonitoraggio) {
	this.coordinatedimonitoraggio = coordinatedimonitoraggio;
}






}
