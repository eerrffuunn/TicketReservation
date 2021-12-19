package View_Tickets;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import adminenter.Trainadd;
import adminenter.admineter;
import adminenter.airplaneadd;
import adminenter.busadd;

import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ViewHome {

	private JFrame frmViewTicket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHome window = new ViewHome();
					window.frmViewTicket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewTicket = new JFrame();
		frmViewTicket.setTitle("View Ticket ");
		frmViewTicket.setBounds(100, 100, 450, 300);
		frmViewTicket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewTicket.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which Type of Tickets to preview");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(111, 35, 208, 16);
		frmViewTicket.getContentPane().add(lblNewLabel);
		

		String [] options = {"--Select--", "AirPlane", "Bus", "Train"};
		JComboBox<String> comboBox = new JComboBox<>(options);
		comboBox.setBounds(111, 104, 208, 27);
		frmViewTicket.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.setBounds(295, 210, 117, 29);
		frmViewTicket.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					
					JOptionPane.showMessageDialog( frmViewTicket,"Please Choose one option", "No option choosed", JOptionPane.ERROR_MESSAGE);
				}
				else if(comboBox.getSelectedIndex() == 1) {
					ViewFlights.main(new String[] {});
					frmViewTicket.dispose();
					
				}else if(comboBox.getSelectedIndex() == 2) {
					
					ViewBus.main(new String[] {});
					frmViewTicket.dispose();
				}else if(comboBox.getSelectedIndex() == 3) {
					
					ViewTrains.main(new String[] {});
					frmViewTicket.dispose();
				}
			}
		});
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admineter.main(new String[] {});
				frmViewTicket.dispose();
			}
		});
		btnNewButton_1.setBounds(30, 210, 117, 29);
		frmViewTicket.getContentPane().add(btnNewButton_1);
	}

}
