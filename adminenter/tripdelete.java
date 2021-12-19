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

public class tripdelete {

	private JFrame frmDellTrip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tripdelete window = new tripdelete();
					window.frmDellTrip.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tripdelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDellTrip = new JFrame();
		frmDellTrip.setTitle("Delete trip");
		frmDellTrip.setBounds(100, 100, 450, 300);
		frmDellTrip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDellTrip.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("please choose type of trip to delete");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 35, 198, 30);
		frmDellTrip.getContentPane().add(lblNewLabel);
		
		
		String [] options = {"--Select--", "AirPlane", "Bus", "Train"};
		JComboBox<String> comboBox = new JComboBox<>(options);
		comboBox.setBounds(150, 100, 160, 30);
		frmDellTrip.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					
					JOptionPane.showMessageDialog( frmDellTrip,"Please Choose one option", "No option choosed", JOptionPane.ERROR_MESSAGE);
				}
				else if(comboBox.getSelectedIndex() == 1) {
					flightdell.main(new String[] {});
					frmDellTrip.dispose();
					
				}else if(comboBox.getSelectedIndex() == 2) {
					
					busdell.main(new String[] {});
					frmDellTrip.dispose();
				}else if(comboBox.getSelectedIndex() == 3) {
					
					Traindell.main(new String[] {});
					frmDellTrip.dispose();
				}
			}
		});
		btnNewButton.setBounds(303, 226, 99, 30);
		frmDellTrip.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admineter.main(new String[] {});
				frmDellTrip.dispose();
			}
		});
		btnNewButton_1.setBounds(28, 226, 99, 30);
		frmDellTrip.getContentPane().add(btnNewButton_1);
	}
}
