package userenter;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;

public class previewloc extends JFrame  {
	
	
	
	public static float lat;
	public static float lang;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String dest;
	private JPanel contentPane;
	private JTextField arrival;

	/**
	 * Launch the application.
	 */@Test
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					previewloc frame = new previewloc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public previewloc() {
		
		setTitle("Ticket Reservation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Arrival");
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("PingFang HK", Font.BOLD, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(180, 131, 82, 29);
		contentPane.add(lblNewLabel_1);
		
		arrival = new JTextField();
		arrival.setBounds(133, 165, 228, 38);
		contentPane.add(arrival);
		arrival.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Please Enter Your Trip !");
		lblNewLabel_4.setFont(new Font("Hiragino Mincho ProN", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 153));
		lblNewLabel_4.setBounds(81, 103, 349, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("explore");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dest = arrival.getText();
				try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/citycordinate", "root", "Erfan_1374");
                    String query = "SELECT * FROM worldcities WHERE city='" + dest + "'";
                    try (Statement stmt = connection.createStatement()){
                    	ResultSet rs = stmt.executeQuery(query);
                    	while (rs.next()) {
                    		 lat = rs.getFloat("lat");
                    		 lang = rs.getFloat("lng");
                    		// System.out.println("lattitude is " + lat + "   " + "langitude is " + lang );
                    		 EngineOptions options =
                    	                EngineOptions.newBuilder(HARDWARE_ACCELERATED).build();
                    	        @SuppressWarnings("static-access")
								Engine engine = Engine.newInstance(
                    	                options.newBuilder(HARDWARE_ACCELERATED)
                    	                        .licenseKey("1BNDHFSC1G12VLNTQE722HVM7HC64Q5FLR7QQFX0YFNPFME02YEXXC2N6A093SQACVTQK7")
                    	                        .build());
                    	        Browser browser = engine.newBrowser();

                    	        SwingUtilities.invokeLater(() -> {
                    	            // Creating Swing component for rendering web content
                    	            // loaded in the given Browser instance.
                    	            BrowserView view = BrowserView.newInstance(browser);

                    	            // Creating and displaying Swing app frame.
                    	            JFrame frame = new JFrame("Hello World");
                    	            // Close Engine and onClose app window
                    	            frame.addWindowListener(new WindowAdapter() {
                    	                @Override
                    	                public void windowClosing(WindowEvent el) {
                    	                    engine.close();
                    	                }
                    	            });
                    	            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    	            JTextField addressBar = new JTextField("https://www.google.com/maps/@"+lat+","+lang+","+"11z");
                    	            addressBar.addActionListener(el ->
                    	                    browser.navigation().loadUrl(addressBar.getText()));
                    	            frame.add(addressBar, BorderLayout.NORTH);
                    	            frame.add(view, BorderLayout.CENTER);
                    	            frame.setSize(800, 500);
                    	            frame.setLocationRelativeTo(null);
                    	            frame.setVisible(true);

                    	            browser.navigation().loadUrl(addressBar.getText());
                    	        });
                    	}
                    }
                    }catch (SQLException ex) {
                    	ex.printStackTrace();;
                    }
			}
				
		});
		btnNewButton_1.setBounds(81, 301, 126, 38);
		contentPane.add(btnNewButton_1);
	}
}
