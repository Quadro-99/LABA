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

public class Main {

	private JFrame frame;
	private JFrame jframefirst;
	private JTextField textField;
	private JTextField textField_1;
	private ClimateMonitoringController controller = new ClimateMonitoringController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.initfirst();
					window.showLogin(window.jframefirst);
					window.jframefirst.setVisible(true);
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

	private void disposeFirstFrame() {
		jframefirst.setVisible(false);
		initialize();
		frame.setVisible(true);
	}
	
	private void enterAsGuest () {
		disposeFirstFrame();
	}
	
	private void showRegister(JFrame f) {
		JLayeredPane panel = new JLayeredPane();
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(417, 169, 103, 60);
		panel.add(lblNewLabel);
		
		JLabel l = new JLabel("Test 2");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setBounds(417, 129, 103, 60);
		panel.add(l);
		
		JLabel lblNewLabel1 = new JLabel("PASSWORD");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(417, 293, 103, 100);
		panel.add(lblNewLabel1);
		
		textField = new JTextField();
		textField.setBounds(300, 363, 356, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(301, 217, 355, 50);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel1.setText(controller.test());
			}
		});
		btnNewButton.setBounds(342, 448, 258, 50);
		panel.add(btnNewButton);
		
		JButton b = new JButton("Test");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			disposeFrame(f);
			}
		});
		b.setBounds(342, 498, 258, 50);
		panel.add(b);
		f.validate();
	}
	
	private void disposeFrame(JFrame f) {
		f.getContentPane().removeAll();
		f.repaint();
	}
	
	private void showLogin(JFrame f) {
		JLayeredPane panel = new JLayeredPane();
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(417, 169, 103, 60);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("PASSWORD");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(417, 293, 103, 100);
		panel.add(lblNewLabel1);
		
		textField = new JTextField();
		textField.setBounds(300, 363, 356, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(301, 217, 355, 50);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel1.setText(controller.test());
			}
		});
		btnNewButton.setBounds(342, 448, 258, 50);
		panel.add(btnNewButton);
		
		JButton b = new JButton("Test");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			disposeFrame(f);
			enterAsGuest();
			
			}
		});
		b.setBounds(342, 498, 258, 50);
		panel.add(b);
		
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */

	private void initfirst() {
		jframefirst = new JFrame();
		jframefirst.setBounds(100, 100, 800, 600);
		jframefirst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframefirst.setTitle("Climate Monitoring");
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Climate Monitoring");
		
		
	}
}
