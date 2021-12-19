package adminenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;



import ticketmain.userlogin;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addtrip {

	private JFrame frmAddTrip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addtrip window = new addtrip();
					window.frmAddTrip.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addtrip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddTrip = new JFrame();
		frmAddTrip.setTitle("Add Trip");
		frmAddTrip.setBounds(100, 100, 450, 300);
		frmAddTrip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddTrip.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("please choose type of trip");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 35, 198, 30);
		frmAddTrip.getContentPane().add(lblNewLabel);
		
		
		String [] options = {"--Select--", "AirPlane", "Bus", "Train"};
		JComboBox<String> comboBox = new JComboBox<>(options);
		comboBox.setBounds(150, 100, 160, 30);
		frmAddTrip.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					
					JOptionPane.showMessageDialog( frmAddTrip,"Please Choose one option", "No option choosed", JOptionPane.ERROR_MESSAGE);
				}
				else if(comboBox.getSelectedIndex() == 1) {
					airplaneadd.main(new String[] {});
					frmAddTrip.dispose();
					
				}else if(comboBox.getSelectedIndex() == 2) {
					
					busadd.main(new String[] {});
					frmAddTrip.dispose();
				}else if(comboBox.getSelectedIndex() == 3) {
					
					Trainadd.main(new String[] {});
					frmAddTrip.dispose();
				}
			}
		});
		btnNewButton.setBounds(303, 226, 99, 30);
		frmAddTrip.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admineter.main(new String[] {});
				frmAddTrip.dispose();
			}
		});
		btnNewButton_1.setBounds(28, 226, 99, 30);
		frmAddTrip.getContentPane().add(btnNewButton_1);
	}
}
