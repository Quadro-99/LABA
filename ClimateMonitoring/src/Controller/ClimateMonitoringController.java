package Controller;

import java.util.Scanner;

import Model.CoordinateMonitoraggio;
import Model.Operatore;
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
		this.instantiate();
		this.loadEnvironment();
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
	public String test() {
	  
	  

	   
	  CoordinateMonitoraggio coordinate  = servicecoordinate.getCoordinatebyGeoname(2960791);
	    return coordinate.getNomeArea();
	}
	}

