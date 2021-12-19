package ticketmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class firstpage extends JFrame {

	private JFrame frmTicketReservation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstpage window = new firstpage();
					window.frmTicketReservation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public firstpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicketReservation = new JFrame();
		frmTicketReservation.setTitle("Ticket Reservation");
		frmTicketReservation.setBounds(100, 100, 450, 300);
		frmTicketReservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicketReservation.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin.main(new String[] {});
				frmTicketReservation.dispose();
			}
		});
		btnNewButton.setBounds(154, 99, 117, 29);
		frmTicketReservation.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("user");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin.main(new String[] {});
				frmTicketReservation.dispose();
			}
		});
		btnNewButton_1.setBounds(154, 183, 117, 29);
		frmTicketReservation.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("welcome choose an option");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 33, 261, 16);
		frmTicketReservation.getContentPane().add(lblNewLabel);
	}

}
