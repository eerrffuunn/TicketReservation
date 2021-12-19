package adminenter;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class busdell {

	private JFrame frmDellBus;
	private JTextField textField;
	private JTextField textField_1;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					busdell window = new busdell();
					window.frmDellBus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public busdell() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDellBus = new JFrame();
		frmDellBus.setTitle("Delete Bus Trip ");
		frmDellBus.setBounds(100, 100, 450, 300);
		frmDellBus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDellBus.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Departure And Arrival city of Trip to delete");
		lblNewLabel.setBounds(46, 25, 379, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmDellBus.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Departure");
		lblNewLabel_1.setBounds(30, 75, 75, 16);
		frmDellBus.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Arrival");
		lblNewLabel_2.setBounds(30, 120, 61, 16);
		frmDellBus.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(144, 70, 130, 26);
		frmDellBus.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 115, 130, 25);
		frmDellBus.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Please enter Date of Trip");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(101, 169, 221, 16);
		frmDellBus.getContentPane().add(lblNewLabel_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(175, 213, 99, 26);
		frmDellBus.getContentPane().add(dateChooser);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addtrip.main(new String[] {});
				frmDellBus.dispose();
			}
		});
		btnNewButton.setBounds(17, 232, 80, 29);
		frmDellBus.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String departure = textField.getText();
				String  arrival = textField_1.getText();
				String date  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				
				
				
				try {
					
					 Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "Erfan_1374");
					  String query = "DELETE FROM bus_table WHERE departure='" + departure + "'and arrival='" + arrival + "' and date='" + date + "'";
					  Statement stmt = connection.createStatement();
				
					  int x = stmt.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnNewButton, "Not such Trip exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            "Bus Trip from"+"  "+departure + "   "+"to" + "   "+ arrival + "  " + "deleted");
	                    }
	                    connection.close();
					  
				}catch(SQLException ex) {
                    ex.printStackTrace();
                }
				
			}
		});

		btnNewButton_1.setBounds(327, 232, 117, 29);
		frmDellBus.getContentPane().add(btnNewButton_1);
	}	
}	

