import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class MainPage {
	
	private JFrame frameMain;
	private JButton btnSearchTRL;
	private JButton btnStartSurvey;
	private JLabel lblNote;
	private JButton btnExitMain;

	SurveyPage1 surveyPage1;
	SearchPage searchPage;
	LoginSubmitController loginController = new LoginSubmitController();
	
	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setTitle("Main Menu");
		frameMain.setBounds(100, 100, 825, 500);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		frameMain.setVisible(true);
		
		btnSearchTRL = new JButton("Search TRL by NetID");
		btnSearchTRL.setEnabled(false);
		btnSearchTRL.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSearchTRL.setBounds(252, 95, 320, 100);
		frameMain.getContentPane().add(btnSearchTRL);
		
		btnStartSurvey = new JButton("Start Survey");
		btnStartSurvey.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnStartSurvey.setBounds(252, 259, 320, 100);
		frameMain.getContentPane().add(btnStartSurvey);
		
		lblNote = new JLabel("(Available if you've completed a survey recently)");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNote.setBounds(260, 195, 320, 39);
		frameMain.getContentPane().add(lblNote);
		
		btnExitMain = new JButton("Cancel & Exit");
		btnExitMain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExitMain.setBounds(10, 423, 130, 30);
		frameMain.getContentPane().add(btnExitMain);
		
		btnSearchTRL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// Pass student account along to survey page 2
				searchPage = new SearchPage();
				
				
				frameMain.setVisible(false);
				frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frameMain.dispose();
				
			}
		});
		
		btnStartSurvey.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// Go to survey page 1
				surveyPage1 = new SurveyPage1();
				
				
				frameMain.setVisible(false);
				frameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frameMain.dispose();
				
			}
		});
		
		btnExitMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		
		try {
			if(!loginController.loginCheck(LoginPage.loginUserName))
				btnSearchTRL.setEnabled(false);
			else
				btnSearchTRL.setEnabled(true);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
	}
}
