package adminenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View_Tickets.ViewHome;
import ticketmain.firstpage;
import ticketmain.userlogin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class admineter {

	private JFrame frmAdminPortal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admineter window = new admineter();
					window.frmAdminPortal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public admineter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPortal = new JFrame();
		frmAdminPortal.setTitle("Admin Portal");
		frmAdminPortal.setBounds(100, 100, 450, 300);
		frmAdminPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPortal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("choose an option");
		lblNewLabel.setBounds(145, 35, 122, 16);
		frmAdminPortal.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("add trip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addtrip.main(new String[] {});
				frmAdminPortal.dispose();
			}
		});
		btnNewButton.setBounds(145, 80, 117, 29);
		frmAdminPortal.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("delete trip");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tripdelete.main(new String[] {});
				frmAdminPortal.dispose();
			}
		});
		btnNewButton_1.setBounds(150, 121, 117, 29);
		frmAdminPortal.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("log out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstpage.main(new String[] {});
				frmAdminPortal.dispose();
			}
		});
		btnNewButton_2.setBounds(150, 243, 117, 29);
		frmAdminPortal.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Tickets");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewHome.main(new String[] {});
				frmAdminPortal.dispose();
			}
		});
		btnNewButton_3.setBounds(150, 164, 117, 29);
		frmAdminPortal.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Issued tickets");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				  {
					
					
					
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reserved", "root", "Erfan_1374");
					 PreparedStatement st = (PreparedStatement) connection
		                       .prepareStatement("Select * from res_list ");

					 
				     
				   
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
		btnNewButton_4.setBounds(150, 202, 117, 29);
		frmAdminPortal.getContentPane().add(btnNewButton_4);
	}
}
