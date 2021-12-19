package userenter;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ticketmain.userlogin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class usermain {

	private JFrame frmHomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usermain window = new usermain();
					window.frmHomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public usermain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomePage = new JFrame();
		frmHomePage.setTitle("Home Page");
		frmHomePage.setBounds(100, 100, 450, 300);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Reserve Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyticket.main(new String[] {});
				frmHomePage.dispose();
			}
		});
		btnNewButton.setBounds(150, 43, 128, 41);
		frmHomePage.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Tickets");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				askforticket.main(new String[] {});
				frmHomePage.dispose();
			}
		});
		btnNewButton_1.setBounds(150, 90, 128, 41);
		frmHomePage.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LogOut");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin.main(new String[] {});
				frmHomePage.dispose();
			}
		});
		btnNewButton_2.setBounds(22, 228, 117, 29);
		frmHomePage.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Explore");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previewloc.main(new String[] {});
				frmHomePage.dispose();
				
			}
		});
		btnNewButton_3.setBounds(150, 143, 128, 39);
		frmHomePage.getContentPane().add(btnNewButton_3);
	}

}
