import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.json.simple.JSONObject;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;

public class SurveyPage4 {

	private JFrame frameSurveyP4;
	private JLabel lblQ11;
	private JLabel lblQ12;
	private JLabel lblQ13;
	
	private JRadioButton rdbtnQ11Yes;
	private JRadioButton rdbtnQ11No;
	private JRadioButton rdbtnQ13Yes;
	private JRadioButton rdbtnQ13No;
	
	private JTextField tfQ12Date;
	
	private ButtonGroup groupQ11;
	private ButtonGroup groupQ13;
	
	private JButton btnSubmit;
	private JButton btnExit4;
	
	private JSONObject studentJSON;
	private JSONObject surveyJSON;
	
	private SimpleDateFormat dateFormat;
	private Date todaysDate;
	private Date testDate;
	
	private Boolean checkQ11 = false;
	private Boolean checkQ12 = false;
	private Boolean checkQ13 = false;
	
	private JTextField tfCheckQ11;
	private JTextField tfCheckQ12;
	private JTextField tfCheckQ13;
	LoginSubmitController submitController = new LoginSubmitController();

	/**
	 * @wbp.parser.constructor
	 */
	public SurveyPage4() {
		initialize();
	}
	
	/**
	 * Initialize page 4 with student account and their answers from previous pages
	 */
	public SurveyPage4(JSONObject stud, JSONObject surv) {
		initialize();
		studentJSON = new JSONObject(stud);
		surveyJSON = new JSONObject(surv);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSurveyP4 = new JFrame();
		frameSurveyP4.setTitle("Survey Page 4/4");
		frameSurveyP4.setBounds(100, 100, 825, 500);
		frameSurveyP4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSurveyP4.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frameSurveyP4.setVisible(true);
		
		JPanel panelSurveyP4 = new JPanel();
		frameSurveyP4.getContentPane().add(panelSurveyP4);
		panelSurveyP4.setLayout(null);
		
		lblQ11 = new JLabel("11.) Have you taken a Covid test?");
		lblQ11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ11.setBounds(35, 15, 250, 20);
		panelSurveyP4.add(lblQ11);
		
		lblQ12 = new JLabel("12.) If yes, on what date did you take the test? (yyyy-mm-dd)");
		lblQ12.setEnabled(false);
		lblQ12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ12.setBounds(35, 150, 450, 20);
		panelSurveyP4.add(lblQ12);
		
		lblQ13 = new JLabel("13.) If yes, did you test positive for Covid?");
		lblQ13.setEnabled(false);
		lblQ13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ13.setBounds(35, 295, 350, 20);
		panelSurveyP4.add(lblQ13);
		
		rdbtnQ11Yes = new JRadioButton("Yes");
		rdbtnQ11Yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ11Yes.setBounds(57, 45, 110, 23);
		panelSurveyP4.add(rdbtnQ11Yes);
		
		rdbtnQ11No = new JRadioButton("No");
		rdbtnQ11No.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ11No.setBounds(57, 75, 110, 23);
		panelSurveyP4.add(rdbtnQ11No);
		
		rdbtnQ13Yes = new JRadioButton("Yes");
		rdbtnQ13Yes.setEnabled(false);
		rdbtnQ13Yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ13Yes.setBounds(57, 325, 110, 23);
		panelSurveyP4.add(rdbtnQ13Yes);
		
		rdbtnQ13No = new JRadioButton("No");
		rdbtnQ13No.setEnabled(false);
		rdbtnQ13No.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ13No.setBounds(57, 355, 110, 23);
		panelSurveyP4.add(rdbtnQ13No);
		
		tfQ12Date = new JTextField();
		tfQ12Date.setEnabled(false);
		tfQ12Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfQ12Date.setBounds(57, 183, 150, 30);
		panelSurveyP4.add(tfQ12Date);
		tfQ12Date.setColumns(10);
		
		groupQ11 = new ButtonGroup();
		groupQ11.add(rdbtnQ11Yes);
		groupQ11.add(rdbtnQ11No);
		
		groupQ13 = new ButtonGroup();
		groupQ13.add(rdbtnQ13Yes);
		groupQ13.add(rdbtnQ13No);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(671, 423, 130, 30);
		btnSubmit.setEnabled(false);
		panelSurveyP4.add(btnSubmit);
		
		btnExit4 = new JButton("Cancel & Exit");
		btnExit4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit4.setBounds(10, 423, 130, 30);
		panelSurveyP4.add(btnExit4);
		
		tfCheckQ11 = new JTextField();
		tfCheckQ11.setBackground(Color.RED);
		tfCheckQ11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ11.setColumns(10);
		tfCheckQ11.setBounds(495, 15, 20, 20);
		panelSurveyP4.add(tfCheckQ11);
		
		tfCheckQ12 = new JTextField();
		tfCheckQ12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ12.setColumns(10);
		tfCheckQ12.setBackground(Color.RED);
		tfCheckQ12.setBounds(495, 150, 20, 20);
		panelSurveyP4.add(tfCheckQ12);
		
		tfCheckQ13 = new JTextField();
		tfCheckQ13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ13.setColumns(10);
		tfCheckQ13.setBackground(Color.RED);
		tfCheckQ13.setBounds(495, 295, 20, 20);
		panelSurveyP4.add(tfCheckQ13);
		
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		todaysDate = new Date();
		testDate = todaysDate;
		dateFormat.setLenient(false);
		
		rdbtnQ11Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkSubmit();
				
				lblQ12.setEnabled(true);
				tfQ12Date.setEnabled(true);
				tfQ12Date.setText(dateFormat.format(todaysDate));
				
				lblQ13.setEnabled(true);
				rdbtnQ13Yes.setEnabled(true);
				rdbtnQ13No.setEnabled(true);
			}
		});
		
		rdbtnQ11No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkSubmit();
				
				lblQ12.setEnabled(false);
				tfQ12Date.setEnabled(false);
				tfQ12Date.setText("");
				
				lblQ13.setEnabled(false);
				rdbtnQ13Yes.setEnabled(false);
				rdbtnQ13No.setEnabled(false);
				
				groupQ13.clearSelection();
			}
		});
		
		tfQ12Date.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkSubmit();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkSubmit();
			}
		});
		
		
		rdbtnQ13Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkSubmit();
			}
		});
		
		rdbtnQ13No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkSubmit();
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				
				boolean tookTest = false;
				boolean positiveTest = false;
				String testDate = "";
				
				// test date and result are only relevant if patient took test
				if (rdbtnQ11Yes.isSelected()) {
					tookTest = true;
					testDate = tfQ12Date.getText();
					
					if (rdbtnQ13Yes.isSelected()) {
						positiveTest = true;
					}
				}

				// Store responses for page 4
				surveyJSON.put("tookTest", tookTest);
				surveyJSON.put("positiveTest", positiveTest);
				surveyJSON.put("testDate", testDate);
				
				
				// Store the answers to this survey in the student json (replaces old answers)
				studentJSON.put("survey", surveyJSON);
				
				// Once controller is implemented, studentJSON will go to controller instead of below code


				// Instantiate student
				String firstName = (String)studentJSON.get("firstName");
				String lastName = (String)studentJSON.get("lastName");
				String netID = (String)studentJSON.get("netID");
				String email = (String)studentJSON.get("email");
				Student student = new Student(netID, firstName, lastName, email);				
				
				// Instantiate TRL and assign to student
				
				TRL trl = null;
				
				try {
					trl = new TRL(surveyJSON.toString());
					student.setTRL(trl);
				} catch(Exception e) {
					System.out.println("parse error");
				}
				
				submitController.newRecord(student);
				
				DecimalFormat decFormat = new DecimalFormat("#.###");
				
				String fileName = "TRL-DB.txt";
				
				String filePath = Paths.get(fileName).toAbsolutePath().toString();
				filePath = filePath.replace("\\", "/");
				
				String messageString = "Your TRL Score is:  " + decFormat.format(student.getCurrTRL().getValue()) + 
									   "\n(Anything above 0.5 is considered higher risk.)" + 
						
									   "\n\nIf you would like to search for other students' TRL Scores, " +
									   "\nplease upload the File:" +
									   "\n\n     '" + fileName + "'" + 
									   "\n\nto the Google Drive folder after signing in, then restart this program.";
				
				JOptionPane.showMessageDialog(frameSurveyP4, messageString, "TRL Score", JOptionPane.INFORMATION_MESSAGE);
				

				String dbURL = "https://drive.google.com/drive/folders/1D9rDzVueiH66W3Mcwo4ppuVH9NliQ3j9?usp=sharing";
				try {
					
					Desktop.getDesktop().browse(java.net.URI.create(dbURL));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				String selectFile = "TRL-DB.txt";
				
				String selectPath = Paths.get(selectFile).toAbsolutePath().toString();
				
				try {
					Runtime.getRuntime().exec("explorer.exe /select," + selectPath);
				} catch (IOException e) {
					
					String infoMessage = "Please find the file manually in your explorer and upload it to Drive: \n\n" +
										 selectPath;
					
					JOptionPane.showMessageDialog(frameSurveyP4, infoMessage, "File Path", JOptionPane.INFORMATION_MESSAGE);
				}
				
				System.exit(1);
				
				frameSurveyP4.setVisible(false);
			}
		});
		
		btnExit4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(1);
			}
		});
	}

	protected void checkSubmit() {
		
		if (rdbtnQ11No.isSelected()) {
			
			checkQ11 = true;
			tfCheckQ11.setBackground(Color.GREEN);
			
			checkQ12 = true;
			tfCheckQ12.setBackground(Color.GREEN);
			
			checkQ13 = true;
			tfCheckQ13.setBackground(Color.GREEN);
		}
		else if (rdbtnQ11Yes.isSelected()) {
			
			checkQ11 = true;
			tfCheckQ11.setBackground(Color.GREEN);
			
			if (tfQ12Date.getText().equals("")) {
				
				checkQ12 = false;
				tfCheckQ12.setBackground(Color.RED);
			}
			else {
				
				String regexDate = "[2-9][0-9][0-9][0-9]-[0-9][0-2]-[0-3][0-9]";
				
				if (tfQ12Date.getText().matches(regexDate)) {
					
					try {

						testDate = dateFormat.parse(tfQ12Date.getText());
						
						if (testDate.compareTo(todaysDate) <= 0) {
							
							checkQ12 = true;
							tfCheckQ12.setBackground(Color.GREEN);
						}

					} catch (ParseException e) {

						checkQ12 = false;
						tfCheckQ12.setBackground(Color.RED);
					}
				}
				else { 
					
					checkQ12 = false;
					tfCheckQ12.setBackground(Color.RED);
				}
			} 
			
			if (rdbtnQ13Yes.isSelected() || rdbtnQ13No.isSelected()) {
				
				checkQ13 = true;
				tfCheckQ13.setBackground(Color.GREEN);
			}
			else {
				
				checkQ13 = false;
				tfCheckQ13.setBackground(Color.RED);
			}
		}
		else {
			
			checkQ11 = false;
			tfCheckQ11.setBackground(Color.RED);
			
			checkQ12 = false;
			tfCheckQ12.setBackground(Color.RED);
			
			checkQ13 = false;
			tfCheckQ13.setBackground(Color.RED);
		}
		
		if ((checkQ11) && (checkQ12) && (checkQ13)) {
			
			btnSubmit.setEnabled(true);
		}
		else {
			
			btnSubmit.setEnabled(false);
		}
	}
}
