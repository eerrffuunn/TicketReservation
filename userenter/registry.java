package userenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import View_Tickets.Ticket;
import ticketmain.firstpage;
import ticketmain.userlogin;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class registry {

	
	
	
	
	private String firstName;
	private String lastName;
	private	String email;
	private JFrame frmRegistry;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField email_id;
	private JPasswordField passwordField;
	
	
	public registry(String firstName , String lastName , String email) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
		
	public String getemail() {
		return email;
	}
	public String getfirstname() {
		return firstName;
	}
	public String getlastname() {
		return lastName;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registry window = new registry();
					window.frmRegistry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registry() {
		initialize();
		showuser();
	}
	
	
	public ArrayList <User> Userlist(){
    	ArrayList<User> userslist = new ArrayList<>();
    	User user = new User(firstname.getText() , lastname.getText() , email_id.getText());
    	userslist.add(user);
    	
    	return userslist;
    }
	
	public void showuser() {
		ArrayList<User> List = Userlist();
		for(int i = 0 ; i<List.size();i++) {
			System.out.println(List.get(i).getfirstname());
			
		}
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistry = new JFrame();
		frmRegistry.setTitle("Registry");
		frmRegistry.setBounds(100, 100, 450, 300);
		frmRegistry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistry.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(20, 80, 80, 16);
		frmRegistry.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(20, 108, 80, 16);
		frmRegistry.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(20, 136, 61, 16);
		frmRegistry.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(20, 165, 61, 16);
		frmRegistry.getContentPane().add(lblNewLabel_3);
		
		firstname = new JTextField();
		firstname.setBounds(140, 75, 130, 26);
		frmRegistry.getContentPane().add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(140, 108, 130, 26);
		frmRegistry.getContentPane().add(lastname);
		lastname.setColumns(10);
		
		email_id = new JTextField();
		email_id.setBounds(140, 136, 130, 26);
		frmRegistry.getContentPane().add(email_id);
		email_id.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 165, 130, 26);
		frmRegistry.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin.main(new String[] {});
                frmRegistry.dispose();
            	
			}
		});
		btnNewButton.setBounds(20, 232, 80, 29);
		frmRegistry.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 firstName = firstname.getText();
				 lastName = lastname.getText();
				 email = email_id.getText();
                String password = passwordField.getText();
                
                
                
                
                try {
                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Erfan_1374");

                    String query = "INSERT INTO user_data values('" + firstName + "','" + lastName + "','" + email + "','" +
                        password + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton_1, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton_1,
                            "Welcome, " + "   "+ firstName + "    "+ "Your account is sucessfully created");
                    }
                    connection.close();
                    
                   
                	
                	
                }catch (Exception exception) {
                    exception.printStackTrace();
                }
                
                usermain.main(new String[] {});
                frmRegistry.dispose();
			}
		});
		btnNewButton_1.setBounds(315, 232, 117, 29);
		frmRegistry.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Please fill form below");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(120, 28, 180, 16);
		frmRegistry.getContentPane().add(lblNewLabel_4);
	}
}
