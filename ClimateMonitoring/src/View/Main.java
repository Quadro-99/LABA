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
		JButton b = new JButton("CHIUDI");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertNewCentro.dispose();
			}
		});
		insertNewCentro.add(b);
		
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
		    lblNewLabel1.setBounds(10, 220, 330, 40);
		    panel.add(lblNewLabel1);
		    
		    JLabel lblNewLabel2 = new JLabel("Codice fiscale");
		    lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblNewLabel2.setBounds(10, 170, 330, 40);
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

		    JTextField cognomeField = new JTextField();
		    cognomeField.setBounds(350, 270, 350, 40);
		    panel.add(cognomeField);
		    cognomeField.setColumns(10);
		    
		    JTextField cfField = new JTextField();
		    cfField.setBounds(350, 320, 350, 40);
		    panel.add(cfField);
		    cfField.setColumns(10);
		    
		    JTextField mailField = new JTextField();
		    mailField.setBounds(350, 170, 350, 40);
		    panel.add(mailField);
		    mailField.setColumns(10);
		    
		    JPasswordField passRegField = new JPasswordField();
		    passRegField.setBounds(350, 220, 350, 40);
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
