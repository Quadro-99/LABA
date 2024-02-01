package View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import Model.*;


import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.ClimateMonitoringController;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenuBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Cursor;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;

public class Main {

	private static final String CLIMATE_MONITORING_TITLE = "Climate Monitoring";
	private static final String CLIMATE_MONITORING_TITLE_GUEST = "Climate Monitoring - GUEST";
	private static final String CLIMATE_MONITORING_TITLE_OP = "Climate Monitoring - OPERATOR";
	private static final String CLIMATE_MONITORING_TITLE_NEW_CENTRO = "Climate Monitoring - Inserimento Centro";
	private static final String CLIMATE_MONITORING_TITLE_NEW_PARAMETRI = "Climate Monitoring - Inserimento Prametri";
	private static final String CLIMATE_MONITORING_TITLE_NEW_COORDINATE = "Climate Monitoring - Inserimento Coordinate";
	private JFrame operatorFrame = new JFrame();
	private JFrame loginFrame = new JFrame();
	private JFrame registerFrame = new JFrame();
	private JFrame guestFrame = new JFrame();
	private JFrame insertNewCentro = new JFrame();
	private JFrame insertNewCoordinate = new JFrame();
	private JFrame insertNewParametri = new JFrame();
	private JPanel coordinatePanel = new JPanel();
	private JPanel parametriPanel = new JPanel();
	private JScrollPane coordinateScroll = new JScrollPane();
	private JScrollPane parametriScroll = new JScrollPane();
	private JMenuBar menuBar = new JMenuBar();
	private JButton addCoordinate = new JButton("Aggiungi Coordinate");
	private JButton addParametri = new JButton("Aggiungi Parametri");
	private CentroDiMonitoraggio selectedCentro;
	private CoordinateMonitoraggio selectedCoordinate;
	private Operatore currentOperator;
    private ClimateMonitoringController controller = new ClimateMonitoringController();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JLabel lblNewLabel_21;
    private JLabel lblNewLabel_22;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		initFrame(loginFrame, 1000, 600, CLIMATE_MONITORING_TITLE);
		initFrame(registerFrame, 1000, 600, CLIMATE_MONITORING_TITLE);
		initFrame(guestFrame, 1200, 600, CLIMATE_MONITORING_TITLE_GUEST);
		initFrame(operatorFrame, 1200, 600, CLIMATE_MONITORING_TITLE_OP);
		initPopUp(insertNewCentro, 600, 400, CLIMATE_MONITORING_TITLE_NEW_CENTRO);
		initPopUp(insertNewParametri, 600, 400, CLIMATE_MONITORING_TITLE_NEW_PARAMETRI);
		initPopUp(insertNewCoordinate, 600, 400, CLIMATE_MONITORING_TITLE_NEW_COORDINATE);
		createLogin(loginFrame);
		createRegister(registerFrame);
		createInsertNewCentro(insertNewCentro);
		createInsertNewCoordinate(insertNewCoordinate);
		createInsertParametri(insertNewParametri);
		loginFrame.getContentPane().setBackground(new Color(102, 205, 170));
		loginFrame.setVisible(true);
		
	}
	
	private void initFrame(JFrame f, int w, int h, String title) {
		f.setBounds(100, 100, w, h);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle(title);
	}	
	
	private void initPopUp(JFrame f, int w, int h, String title) {
		f.setBounds(200, 200, w, h);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setTitle(title);
	}
	
	private void changeFrameTo(JFrame from, JFrame to) {
		from.setVisible(false);
		to.setVisible(true);
		to.validate();
	}
	
	private void popUp(JFrame popUp) {
		popUp.setVisible(true);
		popUp.validate();
	}
	
	
	private void createInsertNewCentro(JFrame insertNewCentro) {
		
		insertNewCentro.getContentPane().setLayout(null);
		
		JButton chiudi = new JButton("REGISTRA CENTRO");
		chiudi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chiudi.setBounds(300, 275, 175, 45);
		insertNewCentro.getContentPane().add(chiudi);
		
		JButton registraCentro = new JButton("CHIUDI");
		registraCentro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registraCentro.setBounds(100, 275, 175, 45);
		insertNewCentro.getContentPane().add(registraCentro);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRA CENTRO DI MONITORAGGIO");
		lblNewLabel_1.setFont(new Font("Arial Nova Cond", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(36, 10, 520, 57);
		insertNewCentro.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(260, 85, 260, 30);
		insertNewCentro.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(260, 135, 260, 30);
		insertNewCentro.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(260, 185, 260, 30);
		insertNewCentro.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome centro");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(29, 85, 195, 30);
		insertNewCentro.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Indirizzo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(29, 135, 195, 30);
		insertNewCentro.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID Centro");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(29, 185, 195, 30);
		insertNewCentro.getContentPane().add(lblNewLabel_4);
		
		insertNewCentro.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
	            operatorFrame.setEnabled(true);
	            operatorFrame.toFront();
	            operatorFrame.requestFocus();
	        }
	    });
	}
	
	private void createInsertNewCoordinate(JFrame insertNewCoordinate) {
		
		JPanel panel = new JPanel();
		operatorFrame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JLabel lblNewLabel_5 = new JLabel("REGISTRA COORDINATE GEOGRAFICHE");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial Nova Cond", Font.PLAIN, 35));
		lblNewLabel_5.setBounds(10, 10, 930, 88);
		panel.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(350, 120, 400, 45);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(350, 180, 400, 45);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(350, 240, 400, 45);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(350, 360, 400, 45);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(350, 300, 400, 45);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("CHIUDI");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_4.setBounds(184, 464, 270, 60);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("REGISTRA COORDINATE");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setBounds(507, 465, 270, 60);
		panel.add(btnNewButton_5);
		
		lblNewLabel_6 = new JLabel("Geoname  ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(42, 120, 250, 45);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Nome area");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(42, 180, 250, 45);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Stato");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(42, 240, 250, 45);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Latitudine ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(42, 300, 250, 45);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Longitudine");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_10.setBounds(42, 360, 250, 45);
		panel.add(lblNewLabel_10);
		
		
		insertNewCoordinate.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
	            operatorFrame.setEnabled(true);
	            operatorFrame.toFront();
	            operatorFrame.requestFocus();
	        }
	    });
	}
	
	private void createInsertParametri(JFrame insertParametri) {
		
		JPanel panel = new JPanel();
		operatorFrame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JLabel lblNewLabel_5 = new JLabel("REGISTRA PARAMETRI CLIMATICI");
		lblNewLabel_5.setBounds(10, 10, 930, 88);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial Nova Cond", Font.PLAIN, 35));
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_6 = new JButton("Chiudi");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_6.setBounds(200, 600, 235, 45);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("REGISTRA PARAMETRI");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_7.setBounds(500, 600, 235, 45);
		panel.add(btnNewButton_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(680, 240, 65, 50);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(250, 360, 65, 50);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(680, 360, 65, 50);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(250, 300, 65, 50);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(250, 240, 65, 50);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_13.setBounds(680, 427, 246, 110);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(680, 300, 65, 50);
		panel.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(466, 130, 358, 34);
		panel.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_16.setBounds(250, 420, 65, 50);
		panel.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Data di rilevazione (Formato YYYY-MM-DD)");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setBounds(130, 130, 320, 35);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("- VENTO ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12.setBounds(50, 240, 200, 50);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("- TEMPERATURA");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_13.setBounds(50, 420, 200, 50);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("- PRESSIONE");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_14.setBounds(50, 360, 200, 50);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("- UMIDITA'");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_15.setBounds(50, 300, 200, 50);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("- NOTE (Max 256 caratteri)");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_16.setBounds(375, 420, 260, 50);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("- MASSA GHIACCIAI");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_17.setBounds(375, 360, 260, 50);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("- ALTITUDINE GHIACCIAI");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_18.setBounds(375, 300, 260, 50);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setBounds(613, 193, 32, -1);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("- PRECIPITAZIONI");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_20.setBounds(375, 240, 200, 50);
		panel.add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("Inserisci valore (1-5)");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_21.setBounds(225, 200, 223, 26);
		panel.add(lblNewLabel_21);
		
		lblNewLabel_22 = new JLabel("Inserisci valore (1-5)");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_22.setBounds(644, 200, 223, 26);
		panel.add(lblNewLabel_22);
		
		insertParametri.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
	            operatorFrame.setEnabled(true);
	            operatorFrame.toFront();
	            operatorFrame.requestFocus();
	        }
	    });
	}
	
	private void createLogin(JFrame f) {
		
		JLayeredPane panel = new JLayeredPane();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 125, 966, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("PASSWORD");
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(10, 248, 966, 41);
		panel.add(lblNewLabel1);
		
		
		JTextField userNameField = new JTextField();
		userNameField.setFont(new Font("Tahoma", Font.BOLD, 18));
		userNameField.setBounds(276, 185, 430, 50);
		userNameField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(userNameField);
		userNameField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(276, 299, 430, 50);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentOperator = controller.login(userNameField.getText().trim(), passwordField.getPassword().toString());
				if(currentOperator == null) return;
				else {
					createOperatorFrame(operatorFrame);
					changeFrameTo(f, operatorFrame);
				}
			}
		});
		btnNewButton.setBounds(276, 392, 210, 50);
		panel.add(btnNewButton);
		
		JButton b = new JButton("ACCEDI COME OSPITE");
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createGuestFrame(guestFrame);
				changeFrameTo(f, guestFrame);
			}
		});
		b.setBounds(276, 468, 430, 50);
		panel.add(b);
		
		JButton btnNewButton_1 = new JButton("REGISTRATI");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeFrameTo(f, registerFrame);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(496, 392, 210, 50);
		panel.add(btnNewButton_1);
		
		JLabel lblClimateMonitoringLogin = new JLabel("Climate Monitoring Login");
		lblClimateMonitoringLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblClimateMonitoringLogin.setForeground(Color.BLACK);
		lblClimateMonitoringLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClimateMonitoringLogin.setBounds(10, 33, 966, 50);
		panel.add(lblClimateMonitoringLogin);
		

	}
		
		private void createRegister(JFrame registerFrame) {
			
		    registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		    registerFrame.setTitle("Registrazione");

		   
		    JPanel panel = new JPanel();
		    panel.setBackground(new Color(102, 205, 170));
		    registerFrame.getContentPane().add(panel, BorderLayout.CENTER);
		    panel.setLayout(null);

		    
		    JLabel lblNewLabel = new JLabel("Nome");
		    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblNewLabel.setBounds(10, 120, 330, 40);
		    panel.add(lblNewLabel);

		    JLabel lblNewLabel1 = new JLabel("Cognome");
		    lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblNewLabel1.setBounds(10, 170, 330, 40);
		    panel.add(lblNewLabel1);
		    
		    JLabel lblNewLabel2 = new JLabel("Codice fiscale");
		    lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblNewLabel2.setBounds(10, 220, 330, 40);
		    panel.add(lblNewLabel2);
		    
		    JLabel lblNewLabel3 = new JLabel("E-Mail");
		    lblNewLabel3.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblNewLabel3.setBounds(10, 270, 330, 40);
		    panel.add(lblNewLabel3);
		    
		    JLabel lblNewLabel4 = new JLabel("Password");
		    lblNewLabel4.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblNewLabel4.setBounds(10, 320, 330, 40);
		    panel.add(lblNewLabel4);

		    JTextField nomeField = new JTextField();
		    nomeField.setBounds(350, 120, 350, 40);
		    panel.add(nomeField);
		    nomeField.setColumns(10);

		    JTextField emailField = new JTextField();
		    emailField.setBounds(350, 270, 350, 40);
		    panel.add(emailField);
		    emailField.setColumns(10);
		    
		    JTextField cfField = new JTextField();
		    cfField.setBounds(350, 220, 350, 40);
		    panel.add(cfField);
		    cfField.setColumns(10);
		    
		    JTextField cognomeField = new JTextField();
		    cognomeField.setBounds(350, 170, 350, 40);
		    panel.add(cognomeField);
		    cognomeField.setColumns(10);
		    
		    JPasswordField passRegField = new JPasswordField();
		    passRegField.setBounds(350, 320, 350, 40);
		    panel.add(passRegField);
		    passRegField.setColumns(10);
		    
		    JButton btnNewButton_2 = new JButton("REGISTRATI");
		    btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    btnNewButton_2.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    	}
		    });
		    btnNewButton_2.setBounds(350, 411, 350, 50);
		    panel.add(btnNewButton_2);
		    
		    JButton btnNewButton_3 = new JButton("INDIETRO");
		    btnNewButton_3.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		changeFrameTo(registerFrame, loginFrame);		    		
		    	}
		    });
		    btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		    btnNewButton_3.setBounds(35, 35, 200, 50);
		    panel.add(btnNewButton_3);

		    
		}
		
		private void createOperatorFrame(JFrame operatorFrame) {
			
		    operatorFrame.getContentPane().add(menuBar, BorderLayout.NORTH);
		    
		    JButton addCentro = new JButton("Aggiungi Centro");
		    addCentro.setHorizontalAlignment(SwingConstants.LEFT);
		    if(currentOperator == null || currentOperator.getIDCentro() != -1) addCentro.setEnabled(false);
		    addCentro.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		if(currentOperator == null || currentOperator.getIDCentro() != -1) return;
		    		operatorFrame.setEnabled(false);
		    		popUp(insertNewCentro);
		    	}
		    });
		    menuBar.add(addCentro);
		    
		    JSeparator separator = new JSeparator();
		    separator.setBackground(Color.LIGHT_GRAY);
		    menuBar.add(separator);
		    
		    
		    addCoordinate.setHorizontalAlignment(SwingConstants.RIGHT);
		    if(currentOperator == null || currentOperator.getIDCentro() == -1) addCoordinate.setEnabled(false);
		    addCoordinate.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		if(currentOperator == null || currentOperator.getIDCentro() == -1) return;
		    		if(!addCoordinate.isEnabled()) return;
		    		popUp(insertNewCoordinate);
		    	}
		    });
		    menuBar.add(addCoordinate);
		    
		    
		    addParametri.setHorizontalAlignment(SwingConstants.RIGHT);
		    if(currentOperator == null || currentOperator.getIDCentro() == -1) addParametri.setEnabled(false);
		    addParametri.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		if(currentOperator == null || currentOperator.getIDCentro() == -1) return;
		    		if(!addParametri.isEnabled()) return;
		    		popUp(insertNewParametri);
		    	}
		    });
		    menuBar.add(addParametri);
			createMainPanel(operatorFrame);   
		}

		private void createGuestFrame(JFrame guestFrame) {
			createMainPanel(guestFrame);    
		}
		
		private void createMainPanel(JFrame frame) {
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
		    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		    
		    JSplitPane firstSplit = new JSplitPane();
		    panel.add(firstSplit);
		    
		    JScrollPane centriScroll = new JScrollPane();
		    centriScroll.setMinimumSize(new DimensionUIResource(350, 200));
		    centriScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Centri di Monitoraggio"));        
		    	    
		    JPanel centriPanel = new JPanel();
		    JList<CentroDiMonitoraggio> cl = createCentroList();
		    cl.setPreferredSize(new Dimension(300, cl.getMaximumSize().height));
		    centriPanel.add(cl);
		    centriScroll.setViewportView(centriPanel);
		    firstSplit.setLeftComponent(centriScroll);
		    
		    JSplitPane secondSplit = new JSplitPane();
		    secondSplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		    firstSplit.setRightComponent(secondSplit);
		   
		    coordinateScroll.setMinimumSize(new DimensionUIResource(350, 250));
		    coordinateScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Coordinate Di Monitoraggio"));
    
		    coordinateScroll.setViewportView(this.coordinatePanel);
		    secondSplit.setLeftComponent(coordinateScroll);
		  
		    parametriScroll.setMinimumSize(new DimensionUIResource(350, 250));
		    parametriScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Parametri Climatici"));
		   
		    parametriScroll.setViewportView(this.parametriPanel);
		    secondSplit.setRightComponent(parametriScroll);
		    
		}
		
		private JList<CentroDiMonitoraggio> createCentroList(){
			DefaultListModel<CentroDiMonitoraggio> centriList = new DefaultListModel<>();
			
			centriList.addAll(controller.getCentriStub());
		    
			JList<CentroDiMonitoraggio> cl = new JList<CentroDiMonitoraggio>(centriList);
			cl.setCellRenderer(new ListCellRenderer<CentroDiMonitoraggio>() {
				@Override
				public Component getListCellRendererComponent(JList<? extends CentroDiMonitoraggio> list,
						CentroDiMonitoraggio value, int index, boolean isSelected, boolean cellHasFocus) {
					return createCentroCard(value);
				}
			});
			
			cl.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		selectedCentro = cl.getModel().getElementAt(cl.getSelectedIndex());
		    		selectCoordinate(selectedCentro);
		    	}
		    	@Override
		    	public void mouseEntered(MouseEvent e) {
		    		cl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    	}
		    });
			return cl;
		}
		
		private void selectCoordinate(CentroDiMonitoraggio centro) {
			JList<CoordinateMonitoraggio> cm = createCoordinateList(centro.getIdcentro());
    		coordinatePanel.removeAll();
    		coordinatePanel.add(cm);
    		coordinateScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Coordinate Di Monitoraggio centro " + centro.getCentroname()));
    		parametriPanel.removeAll();
    		parametriPanel.repaint();
    		parametriPanel.revalidate();
    		coordinatePanel.repaint();
    		coordinatePanel.revalidate();
		}
		
		private JList<CoordinateMonitoraggio> createCoordinateList(int idCentro){
			DefaultListModel<CoordinateMonitoraggio> coordinateList = new DefaultListModel<>();
			
			coordinateList.addAll(controller.getCoordinateStub(idCentro));
		    
			JList<CoordinateMonitoraggio> cm = new JList<CoordinateMonitoraggio>(coordinateList);
			cm.setCellRenderer(new ListCellRenderer<CoordinateMonitoraggio>() {
				@Override
				public Component getListCellRendererComponent(JList<? extends CoordinateMonitoraggio> list,
						CoordinateMonitoraggio value, int index, boolean isSelected, boolean cellHasFocus) {
					return createCoordinateCard(value);
				}
			});
			
			cm.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		selectedCoordinate = cm.getModel().getElementAt(cm.getSelectedIndex());
		    		selectParametri(selectedCoordinate);		    		
		    	}
		    	@Override
		    	public void mouseEntered(MouseEvent e) {
		    		cm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    	}
		    });
			return cm;
		}
		
		private void selectParametri(CoordinateMonitoraggio coordinate) {
			JList<ParametriClimatici> pm = createParametriList(coordinate.getGeoname());
			parametriScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Parametri Climatici Area " + coordinate.getNomeArea()));
    		parametriPanel.removeAll();
    		parametriPanel.add(pm);
    		parametriPanel.repaint();
    		parametriPanel.revalidate();
		}
		
		private JList<ParametriClimatici> createParametriList(int geoname){
			DefaultListModel<ParametriClimatici> parametriList = new DefaultListModel<>();
			
			parametriList.addAll(controller.getParametriStub(geoname));
		    
			JList<ParametriClimatici> pc = new JList<ParametriClimatici>(parametriList);
			pc.setCellRenderer(new ListCellRenderer<ParametriClimatici>() {
				@Override
				public Component getListCellRendererComponent(JList<? extends ParametriClimatici> list,
						ParametriClimatici value, int index, boolean isSelected, boolean cellHasFocus) {
					return createParametriCard(value);
				}
			});
			return pc;
		}
		
		private Component createCentroCard(CentroDiMonitoraggio centro) {
			JPanel wrapper = new JPanel(new BorderLayout());
			JPanel card = new JPanel(new GridLayout(0, 1));
			card.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			card.setBackground(Color.WHITE);

			JLabel nomeCentro = new JLabel(centro.getCentroname());
			nomeCentro.setHorizontalAlignment(SwingConstants.CENTER);
			nomeCentro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			card.add(nomeCentro);

			JLabel indirizzoCentro = new JLabel(centro.getIndirizzo());
			indirizzoCentro.setHorizontalAlignment(SwingConstants.CENTER);
			indirizzoCentro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			card.add(indirizzoCentro);
			wrapper.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			wrapper.add(card, BorderLayout.PAGE_START);
			
			
			return wrapper;
		}
		
		private Component createCoordinateCard(CoordinateMonitoraggio coordinateMonitoraggio) {
			JPanel wrapper = new JPanel(new BorderLayout());
			JPanel card = new JPanel(new GridLayout(0, 1));
			card.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			card.setBackground(Color.WHITE);

			JLabel nomeArea = new JLabel(coordinateMonitoraggio.getNomeArea());
			nomeArea.setHorizontalAlignment(SwingConstants.CENTER);
			nomeArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			card.add(nomeArea);

			JLabel coordinate = new JLabel("Latitude: " + coordinateMonitoraggio.getLatitudine() + " Longitude: " + coordinateMonitoraggio.getLongitudine());
			coordinate.setHorizontalAlignment(SwingConstants.CENTER);
			coordinate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			card.add(coordinate);
			wrapper.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			wrapper.add(card, BorderLayout.PAGE_START);
			
			
			return wrapper;
		}
		
		private Component createParametriCard(ParametriClimatici parametriClimatici) {
			JPanel wrapper = new JPanel(new BorderLayout());
			JPanel card = new JPanel(new GridLayout(0, 1));
			card.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			card.setBackground(Color.WHITE);

			JLabel nomeArea = new JLabel("Precipitazioni: " + parametriClimatici.getPrecipitazioni() + " Massa Ghiacciai: " + parametriClimatici.getMassaGhiacciai());
			nomeArea.setHorizontalAlignment(SwingConstants.CENTER);
			nomeArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			card.add(nomeArea);

			JLabel coordinate = new JLabel(parametriClimatici.getNote());
			coordinate.setHorizontalAlignment(SwingConstants.CENTER);
			coordinate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			card.add(coordinate);
			wrapper.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			wrapper.add(card, BorderLayout.PAGE_START);
			
			
			return wrapper;
		}
}

