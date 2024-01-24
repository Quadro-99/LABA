package DB;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
/**
 * La classe DBO fornisce metodi per la gestione delle connessioni al database PostGreSQL.
 * Utilizza il driver JDBC per PostgreSQL per stabilire la connessione ed eseguire query.
 * 
 * @author aleq
 *
 */
	public class DBO {
	   /**
	    * L'oggetto Connection che rappresenta la connessione al database PostgreSQL:
	    */
		private static Connection connection;
		/**
		 * Url del database Postgre.
		 */
	    private static final String URL = "jdbc:postgresql://localhost:5432/ClimateMonitoring";
	    /**
	     * Nome utente per la connessione al database Postgre.
	     */
	    private static final String USER = "postgres";
	    /**
	     * Password per la connessione al database Postgre. 
	     */
	    private static final String PASSWORD = "Inter4ever";
	   
	    /**
	     * Apre una connessione al database PostgreSQL utilizzando i parametri di connessione specificati.
	     * 
	     * @return un oggetto Connection che rappresenta la connessione al database. 
	     */
	    public static Connection openConnection() {
	        try {
	            
	            Class.forName("org.postgresql.Driver");

	            
	            connection = DriverManager.getConnection(URL,USER,PASSWORD);
	            
	            System.out.println("Connessione al database PostgreSQL stabilita con successo.");
	        } catch (ClassNotFoundException | SQLException e) {
	        	System.out.println(e.getMessage());
	        }
	        return connection;
	    }

	    /**
	     * Chiude la connessione al database se aperta
	     */
	    private static void closeConnection() {
	        try {
	            if (connection != null && !connection.isClosed()) {
	                connection.close();
	                System.out.println("Connessione al database chiusa.");
	            }
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	        }
	    }
	    /**
	     * Esegue una query SQL sul database e restituisce il risultato come oggetto ResultSet.
	     * 
	     * @param query, La query SQL da eseguire-
	     * @return Un oggetto ResultSet contenente il risultato della query.
	     */
	    public static ResultSet executeQuery(String query) {
	        try {
	         
	            Class.forName("org.postgresql.Driver");

	            openConnection();

	          
	            PreparedStatement preparedStatement = connection.prepareStatement(query);

	           
	            ResultSet resultSet = preparedStatement.executeQuery();

	            closeConnection();
	            
	            return resultSet;

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            
	            return null;
	        }
	    }
	}

	  