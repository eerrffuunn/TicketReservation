package userenter;

import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;



import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;



import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class BuyTrain {
	public String departure;
	public String arrival;
	private JFrame frmbuytrain;
	private JTextField textField;
	private JTextField textField_1;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyTrain window = new BuyTrain();
					window.frmbuytrain.setVisible(true);
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuyTrain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmbuytrain = new JFrame();
		frmbuytrain.setTitle(" Train Trip Details");
		frmbuytrain.setBounds(100, 100, 450, 300);
		frmbuytrain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmbuytrain.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Departure And Arrival city");
		lblNewLabel.setBounds(101, 25, 262, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmbuytrain.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Departure");
		lblNewLabel_1.setBounds(30, 75, 75, 16);
		frmbuytrain.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Arrival");
		lblNewLabel_2.setBounds(30, 120, 61, 16);
		frmbuytrain.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(144, 70, 130, 26);
		frmbuytrain.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 115, 130, 25);
		frmbuytrain.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyticket.main(new String[] {});
				frmbuytrain.dispose();
			}
		});
		btnNewButton.setBounds(17, 232, 80, 29);
		frmbuytrain.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("search");
		btnNewButton_1.setBounds(327, 232, 117, 29);
		frmbuytrain.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 departure = textField.getText();
				 arrival = textField_1.getText();
				showTrain strt = new showTrain();
					strt.d=textField.getText();
					strt.a=textField_1.getText();
					
					
				
				
			try {
				
					 Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/train", "root", "Erfan_1374");
					 PreparedStatement st = (PreparedStatement) connection
		                        .prepareStatement("Select departure, arrival from train_table where departure=? and arrival=?");

					 st.setString(1, departure);
	                    st.setString(2, arrival);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                     
	             
	                        
	                        showTrain.main(new String[] {});
	    					frmbuytrain.dispose();
	        				
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            "not such trip found");
	                    }
	                    connection.close();
				  
				}catch(SQLException ex) {
                   ex.printStackTrace();
               }
			btnNewButton_1.setBounds(327, 232, 117, 29);
			frmbuytrain.getContentPane().add(btnNewButton_1);
			}
		});

		
	}	

	}

