package userenter;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showFlight {
	public static String d ;
	public static String a ;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					showFlight window = new showFlight();
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
	public showFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		try 
		  {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/flight", "root", "Erfan_1374");
			 PreparedStatement st = (PreparedStatement) connection
                       .prepareStatement("Select * from flight_table where departure=? and arrival=?");

		    
		     
		    
		      st.setString(1, d);
              st.setString(2, a);
              ResultSet res = st.executeQuery();
		      String columns[] = { "Departure", "Arrival", "Date" };
		      String data[][] = new String[8][3];
		    
		      int i = 0;
		      while (res.next()) {
		        String dep = res.getString("departure");
		        String arr = res.getString("arrival");
		        String dat = res.getString("date");
		        data[i][0] = dep;
		        data[i][1] = arr;
		        data[i][2] = dat;
		        i++;
		      }
		    
		      DefaultTableModel model = new DefaultTableModel(data, columns);
		      JTable table = new JTable(model);
		      table.setShowGrid(true);
		      table.setShowVerticalLines(true);
		      JScrollPane pane = new JScrollPane(table);
		      pane.setBounds(23, 5, 450, 130);
		      
		      JPanel panel = new JPanel();
		      panel.setLayout(null);
		      panel.add(pane);
		      frame.getContentPane().add(panel);
		      
		      JButton btnNewButton = new JButton("Reserve a ticket");
		      btnNewButton.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		finalticketFlight.main(new String[] {});
		      		frame.dispose();
		      	}
		      });
		      btnNewButton.setBounds(150, 147, 160, 29);
		      panel.add(btnNewButton);
		      frame.setSize(500, 250);
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      
		    
		    }catch(SQLException e) {
		        e.printStackTrace();
		    }
		
	}

}
