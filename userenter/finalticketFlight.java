package userenter;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class finalticketFlight  {
	
	
	
	
	 String firstname;
	 String lastname;
	 String email;
	 String departure;
	 String arrival;
	 String date;
	 String type = "Flight";
	;
	private JFrame frame;
	private JTextField firstName;
	private JTextField textField;
	private JTextField Email_id;
	private JTextField Departure;
	private JTextField Arrival;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
			
		
					
			

		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalticketFlight window = new finalticketFlight();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public finalticketFlight() {
		initialize();
		
	}
	
	
	
	
	
	 
		


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("firstname");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 40, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		firstName = new JTextField();
		firstName.setBounds(93, 35, 130, 26);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel LabelLast = new JLabel("last name");
		LabelLast.setHorizontalAlignment(SwingConstants.CENTER);
		LabelLast.setBounds(20, 90, 61, 16);
		frame.getContentPane().add(LabelLast);
		
		textField = new JTextField();
		textField.setBounds(93, 85, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel LabelEmail = new JLabel("Email");
		LabelEmail.setHorizontalAlignment(SwingConstants.CENTER);
		LabelEmail.setBounds(20, 140, 61, 16);
		frame.getContentPane().add(LabelEmail);
		
		Email_id = new JTextField();
		Email_id.setBounds(93, 135, 130, 26);
		frame.getContentPane().add(Email_id);
		Email_id.setColumns(10);
		
		JLabel DepartureLabel = new JLabel("Departure");
		DepartureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DepartureLabel.setBounds(20, 189, 73, 16);
		frame.getContentPane().add(DepartureLabel);
		
		JLabel arrivalLabel = new JLabel("Arrival");
		arrivalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		arrivalLabel.setBounds(235, 189, 61, 16);
		frame.getContentPane().add(arrivalLabel);
		
		Departure = new JTextField();
		Departure.setBounds(93, 184, 130, 26);
		frame.getContentPane().add(Departure);
		Departure.setColumns(10);
		
		Arrival = new JTextField();
		Arrival.setBounds(302, 184, 130, 26);
		frame.getContentPane().add(Arrival);
		Arrival.setColumns(10);
		
		JLabel DateLabel = new JLabel("Date");
		DateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateLabel.setBounds(235, 140, 61, 16);
		frame.getContentPane().add(DateLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(308, 135, 124, 26);
		frame.getContentPane().add(dateChooser);
		
		 date  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		
		JButton btnNewButton = new JButton("Reserve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstname = firstName.getText();
				lastname = textField.getText();
				email = Email_id.getText();
				departure = Departure.getText();
				arrival = Arrival.getText();
				date  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				
				
				
				
				try {
                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reserved", "root", "Erfan_1374");

                    String query = "INSERT INTO res_list values('" + firstname + "','" + lastname + "','" + departure + "','" +
                        arrival + "','" + date + "','" + email + "','" + type + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "can not save the ticket");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "ticket is booked");
                    }
                    connection.close();
                    
                   
                	
                	
                }catch (Exception exception) {
                    exception.printStackTrace();
                }
                
				
			}
		});
		btnNewButton.setBounds(312, 232, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usermain.main(new String[] {});
				frame.dispose();
			}
			
		});
		btnNewButton_1.setBounds(20, 232, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}

