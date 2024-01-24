 package ServerController;
import Service.*;

public class Facade {
	
	private static ServiceCentro servicecentro;
	private static ServiceOperatore serviceoperatore; 
	private static ServiceParametri serviceparametri;
	private static ServiceCoordinate servicecoordinate;
	
	public static void instantiateFacade () {
		servicecentro = new ServiceCentro();
		serviceoperatore = new ServiceOperatore();
		serviceparametri = new ServiceParametri();
		servicecoordinate = new ServiceCoordinate();
	}
	public static void loadEnvironment () {
		serviceoperatore.enrichOperatori(servicecentro, serviceparametri);
		servicecoordinate.enrichCoordinate(serviceoperatore, servicecentro);
		serviceparametri.enrichParametri(serviceoperatore, servicecoordinate);
		servicecentro.enrichCentri(serviceoperatore, servicecoordinate);
	}
}
