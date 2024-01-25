package View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.ClimateMonitoringController;
import javax.swing.SwingConstants;


import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

public class Main {

	private JFrame frame = new JFrame();
	private JFrame jframefirst = new JFrame();
	private JFrame registerFrame = new JFrame();
	private JFrame guestFrame = new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private ClimateMonitoringController controller = new ClimateMonitoringController();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
		
					window.showLogin(window.jframefirst);
					window.jframefirst.setVisible(true);
					window.jframefirst.validate();
				

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
		
		//initialize(); 
	}

	
	private void showLogin(JFrame f) {
		f.removeAll();
		JLayeredPane panel = new JLayeredPane();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(398, 158, 147, 60);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("PASSWORD");
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(381, 277, 186, 100);
		panel.add(lblNewLabel1);
		
		textField = new JTextField();
		textField.setBounds(266, 363, 430, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(266, 217, 430, 50);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel1.setText(controller.test());
			}
		});
		btnNewButton.setBounds(300, 448, 172, 50);
		panel.add(btnNewButton);
		
		JButton b = new JButton("ACCEDI COME OSPITE");
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			disposeFrame(f);
			enterAsGuest();
			
			}
		});
		b.setBounds(345, 533, 258, 50);
		panel.add(b);
		
		JButton btnNewButton_1 = new JButton("REGISTRATI");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showRegister(registerFrame);
				f.setVisible(false);
				registerFrame.setVisible(true);
				registerFrame.validate();
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(482, 448, 174, 50);
		panel.add(btnNewButton_1);
	
	f.repaint();

	}
		
		private void showRegister(JFrame registerFrame) {
		    registerFrame.removeAll();
		    registerFrame.setBounds(100, 100, 800, 600);
		    registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		    registerFrame.setTitle("Registrazione");

		   
		    JPanel panel = new JPanel();
		    panel.setBackground(Color.WHITE);
		    registerFrame.getContentPane().add(panel, BorderLayout.CENTER);
		    panel.setLayout(null);

		    
		    JLabel lblNewLabel = new JLabel("Nome");
		    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel.setBounds(120, 122, 196, 35);
		    panel.add(lblNewLabel);

		    JLabel lblNewLabel1 = new JLabel("Cognome");
		    lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel1.setBounds(120, 218, 196, 35);
		    panel.add(lblNewLabel1);
		    
		    JLabel lblNewLabel2 = new JLabel("Codice fiscale");
		    lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel2.setBounds(120, 173, 196, 35);
		    panel.add(lblNewLabel2);
		    
		    JLabel lblNewLabel3 = new JLabel("e-mail");
		    lblNewLabel3.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel3.setBounds(120, 266, 196, 35);
		    panel.add(lblNewLabel3);
		    
		    JLabel lblNewLabel4 = new JLabel("Password");
		    lblNewLabel4.setFont(new Font("Tahoma", Font.BOLD, 18));
		    lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		    lblNewLabel4.setBounds(120, 311, 196, 35);
		    panel.add(lblNewLabel4);

		    JTextField textField = new JTextField();
		    textField.setBounds(291, 122, 355, 35);
		    panel.add(textField);
		    textField.setColumns(10);

		    JTextField textField_1 = new JTextField();
		    textField_1.setBounds(291, 266, 355, 35);
		    panel.add(textField_1);
		    textField_1.setColumns(10);
		    
		    textField_2 = new JTextField();
		    textField_2.setBounds(291, 311, 355, 35);
		    panel.add(textField_2);
		    textField_2.setColumns(10);
		    
		    textField_3 = new JTextField();
		    textField_3.setBounds(291, 173, 355, 35);
		    panel.add(textField_3);
		    textField_3.setColumns(10);
		    
		    textField_4 = new JTextField();
		    textField_4.setBounds(291, 218, 355, 35);
		    panel.add(textField_4);
		    textField_4.setColumns(10);
		    
		    JButton btnNewButton_2 = new JButton("REGISTRATI");
		    btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    btnNewButton_2.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    	}
		    });
		    btnNewButton_2.setBounds(232, 394, 300, 50);
		    panel.add(btnNewButton_2);
		    
		    JButton btnNewButton_3 = new JButton("INDIETRO");
		    btnNewButton_3.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		showLogin(jframefirst);
					registerFrame.setVisible(false);
					jframefirst.setVisible(true);
					jframefirst.validate();
		    		
		    	}
		    });
		    btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		    btnNewButton_3.setBounds(57, 35, 157, 35);
		    panel.add(btnNewButton_3);

		    registerFrame.repaint();
		}

		private void guestFrame(JFrame guestFrame) {
			
		    guestFrame.setBounds(100, 100, 800, 600);
		    guestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    guestFrame.setTitle("Climate Monitoring - Guest");

		    JPanel panel = new JPanel();
		    guestFrame.getContentPane().add(panel, BorderLayout.CENTER);
		    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		    guestFrame.setVisible(true);
		}
	
		
private void operatorFrame(JFrame operatorFrame) {
			
		    operatorFrame.setBounds(100, 100, 800, 600);
		    operatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    operatorFrame.setTitle("Climate Monitoring - Guest");

		    JPanel panel = new JPanel();
		    operatorFrame.getContentPane().add(panel, BorderLayout.CENTER);
		    operatorFrame.getContentPane().setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		    operatorFrame.setVisible(true);
		}
		
		
	private void disposeFrame(JFrame f) {
		f.getContentPane().removeAll();
		f.repaint();
	}
	
	
	private void enterAsGuest () {
		
	
	}
	
	/**
	 * Initialize the contents of the frame.
	 */

	private void initfirst() {
	
		jframefirst.setBounds(100, 100, 800, 600);
		jframefirst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframefirst.setTitle("Climate Monitoring");
		
	}
	
	private void initialize() {
	
		frame.setBounds(100, 100, 1200, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Climate Monitoring");
		
		
	}
}
