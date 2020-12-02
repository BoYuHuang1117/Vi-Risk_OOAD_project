import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.json.simple.JSONObject;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.ActionEvent;

public class SearchPage {

	private JFrame frameSearch;
	private JTextField tfSearch;
	private JButton btnExitSearch;
	private JButton btnBackMain;
	
	private JLabel lblNewLabel;
	private JButton btnSearch;
	
	Student student;
	MainPage mainPage;
	SearchController searchController = new SearchController();

	/**
	 * Create the application.
	 */
	public SearchPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSearch = new JFrame();
		frameSearch.setTitle("Search");
		frameSearch.setBounds(100, 100, 825, 500);
		frameSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSearch.getContentPane().setLayout(null);
		frameSearch.setVisible(true);
		
		btnSearch = new JButton("Search");
		btnSearch.setEnabled(false);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSearch.setBounds(262, 200, 300, 100);
		frameSearch.getContentPane().add(btnSearch);
		
		lblNewLabel = new JLabel("Net ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(302, 150, 60, 20);
		frameSearch.getContentPane().add(lblNewLabel);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfSearch.setBounds(372, 148, 150, 24);
		frameSearch.getContentPane().add(tfSearch);
		tfSearch.setColumns(10);
		
		btnExitSearch = new JButton("Cancel & Exit");
		btnExitSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExitSearch.setBounds(10, 423, 130, 30);
		frameSearch.getContentPane().add(btnExitSearch);
		
		btnBackMain = new JButton("Main Menu");
		btnBackMain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBackMain.setBounds(10, 10, 130, 30);
		frameSearch.getContentPane().add(btnBackMain);
		
		tfSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkQuery();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkQuery();
			}
			
		});
		
		btnBackMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// Go to main menu
				mainPage = new MainPage();
				
				
				frameSearch.setVisible(false);
				frameSearch.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frameSearch.dispose();
				
			}
		});
		
		btnExitSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				System.exit(0);
				
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String netID = tfSearch.getText();
					JSONObject jsonObject = searchController.searchStudent(netID);;
					
					if (jsonObject != null) {
					
						Map trlInfo = ((Map)jsonObject.get("trl")); 
						Iterator<Map.Entry> itr1 = trlInfo.entrySet().iterator(); 
						
						Map.Entry datePair = itr1.next(); 
						String surveyDateString = (String) datePair.getValue(); 
						
						Map.Entry trlPair = itr1.next(); 
						double surveyTRLScore = (double) trlPair.getValue();
						
						String titleString = "Student Found: " + netID;
						
						DecimalFormat decFormat = new DecimalFormat("#.###");
						
						String messageString = "Student's Name:  " + (String) jsonObject.get("firstName") + " " + (String) jsonObject.get("lastName") +
											   "\nDate Survey Submitted:  " + surveyDateString +
											   "\nStudent's TRL Score:  " + decFormat.format(surveyTRLScore) + 
											   "\n\n(Anything above 0.5 is considered higher risk.)";
						
						JOptionPane.showMessageDialog(frameSearch, messageString, titleString, JOptionPane.INFORMATION_MESSAGE);
					}
					
					else {
						
						String titleString = "Error: Student Not Found: " + netID;
						JOptionPane.showMessageDialog(frameSearch, "Error, student could not be found.", titleString, JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	protected void checkQuery() {
		
		if(!tfSearch.getText().equals("")) {
			
			String regex = "^[A-Za-z]{3}[0-9]{6}$";
			
			if (tfSearch.getText().matches(regex)) {
				
				btnSearch.setEnabled(true);
				
			} else {
				
				btnSearch.setEnabled(false);
			}
	        
	    }else {
	    	
	    	btnSearch.setEnabled(false);
	    }
		
	}
}
