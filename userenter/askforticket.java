package userenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class askforticket {

	private JFrame frmManageTickets;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					askforticket window = new askforticket();
					window.frmManageTickets.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public askforticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageTickets = new JFrame();
		frmManageTickets.setTitle("manage tickets");
		frmManageTickets.setBounds(100, 100, 450, 300);
		frmManageTickets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageTickets.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("enter your email address");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 94, 194, 16);
		frmManageTickets.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(162, 134, 130, 26);
		frmManageTickets.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				  {
					
					
					String email = textField.getText();
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reserved", "root", "Erfan_1374");
					 PreparedStatement st = (PreparedStatement) connection
		                       .prepareStatement("Select * from res_list where email=?");

					 st.setString(1, email);
				     
				    
				    
		              ResultSet res = st.executeQuery();
		              
				      String columns[] = { "firstname", "lastname", "departure", "Arrival" , "date", "email", "type"};
				      String data[][] = new String[10][7];
				    
				      int i = 0;
				      while (res.next()) {
				        String fn = res.getString("firstname");
				        String ln = res.getString("lastname");
				        String dp = res.getString("departure");
				        String ar = res.getString("arrival");
				        String dt = res.getString("date");
				        String em = res.getString("email");
				        String tp = res.getString("type");
				        data[i][0] = fn;
				        data[i][1] = ln;
				        data[i][2] = dp;
				        data[i][3] = ar;
				        data[i][4] = dt;
				        data[i][5] = em;
				        data[i][6] = tp;
				        
				        i++;
				      }
				    
				      DefaultTableModel model = new DefaultTableModel(data, columns);
				      JTable table = new JTable(model);
				      table.setShowGrid(true);
				      table.setShowVerticalLines(true);
				      JScrollPane pane = new JScrollPane(table);
				      pane.setBounds(23, 5, 450, 130);
				      JFrame frame = new JFrame(" tickets");
				      JPanel panel = new JPanel();
				      panel.setLayout(null);
				      panel.add(pane);
				      frame.getContentPane().add(panel);
				      
				      
				      frame.setSize(500, 250);
				      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				      frame.setVisible(true);
				    
				    }catch(SQLException ee) {
				        ee.printStackTrace();
				    }
			}
		});
		btnNewButton.setBounds(172, 172, 117, 29);
		frmManageTickets.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usermain.main(new String[] {});
				frmManageTickets.dispose();
			}
		});
		btnNewButton_1.setBounds(20, 230, 93, 29);
		frmManageTickets.getContentPane().add(btnNewButton_1);
	}

}
