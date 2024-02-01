import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;

public class MainTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTest window = new MainTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel nomeCentro = new JLabel("Nome Centro");
		nomeCentro.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(nomeCentro, "4, 4");
		
		JLabel nomePlaceHolder = new JLabel("");
		nomePlaceHolder.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(nomePlaceHolder, "8, 4");
		
		JLabel indirizzoCentro = new JLabel("Indirizzo");
		indirizzoCentro.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(indirizzoCentro, "4, 8");
		
		JLabel indirizzoPlaceHolder = new JLabel("");
		indirizzoPlaceHolder.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(indirizzoPlaceHolder, "8, 8");
	}

}
