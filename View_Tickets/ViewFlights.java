package View_Tickets;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.mysql.cj.protocol.Resultset;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewFlights {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFlights window = new ViewFlights();
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
	public ViewFlights() {
		initialize();
		showticket();
	}
	
	
	public ArrayList<Ticket> TicketList(){
		ArrayList<Ticket> TicketsList = new ArrayList<>();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/flight", "root", "Erfan_1374");
			String query = "SELECT * from flight_table";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Ticket ticket;
			while(rs.next()) {
				ticket = new Ticket(rs.getString("departure"),rs.getString("arrival"),rs.getString("date"));
				TicketsList.add(ticket);
			}
			
			
			
			
		}catch(SQLException ex) {
            ex.printStackTrace();
        }
		return TicketsList;
	}
	
	
	public void showticket() {
		ArrayList<Ticket> List = TicketList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.addColumn("departure");
		model.addColumn("arrival");
		model.addColumn("date");
		
		Object row[]= new Object[3];
		for(int i = 0 ; i<List.size();i++) {
			row[0] = List.get(i).getdeparture();
			row[1] = List.get(i).getarrival();
			row[2] = List.get(i).getdate();
			
			
			model.addRow(row);
			
			
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("View Flights");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewHome.main(new String[] {});
				frame.dispose();
			}
		});
		btnNewButton.setBounds(30, 225, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable( );
		
		table.setBounds(63, 42, 340, 160);
		frame.getContentPane().add(table);
		
	}
}
