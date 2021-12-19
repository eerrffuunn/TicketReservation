package userenter;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import adminenter.Trainadd;
import adminenter.airplaneadd;
import adminenter.busadd;

import javax.swing.JTextField;
import javax.swing.JButton;

public class buyticket {

	private JFrame frmReserveTicket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buyticket window = new buyticket();
					window.frmReserveTicket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public buyticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReserveTicket = new JFrame();
		frmReserveTicket.setTitle("Reserve Ticket");
		frmReserveTicket.setBounds(100, 100, 450, 300);
		frmReserveTicket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReserveTicket.getContentPane().setLayout(null);
		
		String [] options = {"--Select--", "AirPlane", "Bus", "Train"};
		JComboBox<String> comboBox = new JComboBox<>(options);
		comboBox.setBounds(140, 135, 150, 20);
		frmReserveTicket.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Choose Type of Trip");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(105, 90, 195, 16);
		frmReserveTicket.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(20, 230, 75, 26);
		frmReserveTicket.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usermain.main(new String[] {});
				frmReserveTicket.dispose();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(158, 179, 117, 29);
		frmReserveTicket.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					
					JOptionPane.showMessageDialog( frmReserveTicket,"Please Choose one option", "No option choosed", JOptionPane.ERROR_MESSAGE);
				}
				else if(comboBox.getSelectedIndex() == 1) {
					BuyFlight.main(new String[] {});
					frmReserveTicket.dispose();
					
				}else if(comboBox.getSelectedIndex() == 2) {
					
					BuyBus.main(new String[] {});
					frmReserveTicket.dispose();
				}else if(comboBox.getSelectedIndex() == 3) {
					
					BuyTrain.main(new String[] {});
					frmReserveTicket.dispose();
				}
			}
		});
	}
}
