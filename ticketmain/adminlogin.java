package ticketmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import adminenter.admineter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminlogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmAdminLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin window = new adminlogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setTitle("admin login");
		frmAdminLogin.setBounds(100, 100, 450, 300);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(62, 75, 61, 16);
		frmAdminLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(62, 157, 61, 16);
		frmAdminLogin.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstpage.main(new String[] {});
				frmAdminLogin.dispose();
			}
		});
		btnNewButton.setBounds(28, 230, 117, 29);
		frmAdminLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField.getText();
			      String password = String.valueOf(passwordField.getPassword());
			      if (name.equals("admin") && password.equals("admin")) {
			    	  admineter.main(new String[] {});
			    	  frmAdminLogin.dispose();
			      }

			}
		});
		btnNewButton_1.setBounds(299, 230, 117, 29);
		frmAdminLogin.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(181, 70, 130, 26);
		frmAdminLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 152, 130, 26);
		frmAdminLogin.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Enter user name and pass");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(105, 25, 250, 15);
		frmAdminLogin.getContentPane().add(lblNewLabel_2);
	}
}
