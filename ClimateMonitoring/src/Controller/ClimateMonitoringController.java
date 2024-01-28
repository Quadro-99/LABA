package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.CentroDiMonitoraggio;
import Model.CoordinateMonitoraggio;
import Model.Operatore;
import Model.ParametriClimatici;
import Service.ServiceCentro;
import Service.ServiceCoordinate;
import Service.ServiceOperatore;
import Service.ServiceParametri;

public class ClimateMonitoringController {
	
	private  ServiceCentro servicecentro;
	private  ServiceOperatore serviceoperatore; 
	private  ServiceParametri serviceparametri;
	private  ServiceCoordinate servicecoordinate;
	
	public ClimateMonitoringController () {
		//this.instantiate();
		//this.loadEnvironment();
		System.out.println("Dati caricati");
	}
	public void instantiate () {
		servicecentro = new ServiceCentro();
		serviceoperatore = new ServiceOperatore();
		serviceparametri = new ServiceParametri();
		servicecoordinate = new ServiceCoordinate();
	}
	public void loadEnvironment () {
		serviceoperatore.enrichOperatori(servicecentro, serviceparametri);
		servicecoordinate.enrichCoordinate(serviceoperatore, servicecentro);
		serviceparametri.enrichParametri(serviceoperatore, servicecoordinate);
		servicecentro.enrichCentri(serviceoperatore, servicecoordinate);
	}
	public List<CentroDiMonitoraggio> getCentriStub() {
		List<CentroDiMonitoraggio> centri = new ArrayList<>();
		for(int x = 0; x <= 100; x++) {
	    	CentroDiMonitoraggio c = new CentroDiMonitoraggio();
	    	c.setCentroname("Centro numero " + x);
	    	c.setIndirizzo("Via contrada " + x);
	    	c.setIdcentro(x);
	    	centri.add(c);
	    }
		return centri;
	}
	public List<CoordinateMonitoraggio> getCoordinateStub(int idCentro) {
		List<CoordinateMonitoraggio> coordinate = new ArrayList<>();
		for(int x = 0; x <= 100; x++) {
			CoordinateMonitoraggio c = new CoordinateMonitoraggio();
	    	c.setGeoname(x);
	    	c.setNomeArea("AREA NUMERO " + x);
	    	c.setLatitudine(x * 2.00);
	    	c.setLongitudine(x * 3.00);
	    	c.setIdcentro(x);
	    	coordinate.add(c);
	    }
		return coordinate.stream().filter(c -> c.getIdcentro() == idCentro).collect(Collectors.toList());
	}
	public List<ParametriClimatici> getParametriStub(int geoname) {
		List<ParametriClimatici> parametri = new ArrayList<>();
		for(int x = 0; x <= 100; x++) {
			ParametriClimatici p = new ParametriClimatici();
	    	p.setGeoname(x);
	    	p.setIdparametro(x);
	    	p.setPrecipitazioni(x * 10);
	    	p.setMassaGhiacciai(x * 20);
	    	p.setNote("parametro numero " + x);
	    	parametri.add(p);
	    }
		return parametri.stream().filter(p -> p.getGeoname() == geoname).collect(Collectors.toList());
	}
	public Operatore stubLogin() {
		Operatore o = new Operatore();
		o.setIdoperatore(0);
		o.setIDCentro(0);
		o.setCognome("Rossi");
		return o;
	}
	public Operatore login(String us, String pwd) {
		//return serviceoperatore.login(us, pwd);
		Operatore o = new Operatore();
		o.setIDCentro(-1);
		o.setIdoperatore(0);
		return o;
	}
	public void registrazioneUtente(Operatore o) {
		serviceoperatore.creaOperatore(o);
	}
	public void associaCentroCoordinate(CoordinateMonitoraggio co) {
		servicecoordinate.associaCentro(co);
	}
	public void creaCoordinate(CoordinateMonitoraggio co) {
		servicecoordinate.creaCoordinate(co);
	}
	public void creaCentro(CentroDiMonitoraggio cm, Operatore o) {
		CentroDiMonitoraggio centro = servicecentro.creaCentro(cm);
		serviceoperatore.associaCentro(o, centro);
	}
	public void associaCentro(CentroDiMonitoraggio cm, Operatore o) {
		serviceoperatore.associaCentro(o, cm);
	}
	public void createParametriClimatici(Operatore o, CoordinateMonitoraggio co, ParametriClimatici pc) {
		pc.setGeoname(co.getGeoname());
		pc.setIdcentro(co.getIdcentro());
		pc.setIdoperatore(o.getIdoperatore());
		serviceparametri.creaParametri(pc);		
	}
}

