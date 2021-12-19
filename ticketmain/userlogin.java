package ticketmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import adminenter.addtrip;
import userenter.registry;
import userenter.usermain;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class userlogin {
	private String pwd ;
	public String Email;
	public boolean logged = false;
	private JFrame frmClientsPortal;
	private JTextField email_id;
	private JPasswordField password_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin window = new userlogin();
					window.frmClientsPortal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userlogin() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientsPortal = new JFrame();
		frmClientsPortal.setTitle("user login");
		frmClientsPortal.setBounds(100, 100, 450, 300);
		frmClientsPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientsPortal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("email");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 54, 61, 16);
		frmClientsPortal.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(50, 128, 61, 16);
		frmClientsPortal.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstpage.main(new String[] {});
				frmClientsPortal.dispose();
			}
			
		});
		btnNewButton.setBounds(20, 243, 117, 29);
		frmClientsPortal.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("login");
		btnNewButton_1.setBounds(310, 243, 117, 29);
		frmClientsPortal.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Email = email_id.getText();
				 pwd = password_id.getText();
				
				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Erfan_1374");

	                    PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("Select email, password from user_data where email=? and password=?");

	                    st.setString(1, Email);
	                    st.setString(2, pwd);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                     
	                        JOptionPane.showMessageDialog(btnNewButton_1, "You have successfully logged in");
	                        logged = true;
	                        usermain.main(new String[] {});
	        				frmClientsPortal.dispose();
	        				
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton_1, "Wrong Username & Password");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
	            
				
				
				
			}
		});
		
		
		
		email_id = new JTextField();
		email_id.setBounds(182, 49, 130, 26);
		frmClientsPortal.getContentPane().add(email_id);
		email_id.setColumns(10);
		
		password_id = new JPasswordField();
		password_id.setBounds(182, 125, 130, 21);
		frmClientsPortal.getContentPane().add(password_id);
		
		JButton btnNewButton_2 = new JButton("Not Registered Yet");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				registry.main(new String[] {});
				frmClientsPortal.dispose();
			}
		});
		btnNewButton_2.setBounds(118, 184, 257, 29);
		frmClientsPortal.getContentPane().add(btnNewButton_2);
	}

	

	

}
