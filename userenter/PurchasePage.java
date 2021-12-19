package userenter;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PurchasePage {

	private JFrame frmPurchaseTicket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchasePage window = new PurchasePage();
					window.frmPurchaseTicket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PurchasePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPurchaseTicket = new JFrame();
		frmPurchaseTicket.setTitle("Purchase Ticket");
		frmPurchaseTicket.setBounds(100, 100, 450, 300);
		frmPurchaseTicket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
