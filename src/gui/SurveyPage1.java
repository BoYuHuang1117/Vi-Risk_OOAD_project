import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

import org.json.simple.JSONObject;

public class SurveyPage1 {

	private JFrame frameSurveyP1;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfNetID;
	private JTextField tfEmail;
	private JTextField tfQ2Zipcode;
	private JTextField tfQ2City;
	private JRadioButton rdbtnQ1Yes;
	private JRadioButton rdbtnQ1No;
	private ButtonGroup groupQ1;
	private JButton btnExit1;
	private JButton btnNextPage1;
	
	SurveyPage2 surveyPage2;
	
	private JTextField tfDate;
	private JTextField tfCheckFName;
	private JTextField tfCheckLName;
	private JTextField tfCheckNetID;
	private JTextField tfCheckEmail;
	private JTextField tfCheckDate;
	private JTextField tfCheckQ2City;
	private JTextField tfCheckQ2Zip;
	private JTextField tfCheckQ1;
	
	private SimpleDateFormat dateFormat;
	private Date todaysDate;
	private Date surveyDate;
	
	private Boolean checkNetID = false;
	private Boolean checkFirstName = false;
	private Boolean checkLastName = false;
	private Boolean checkEmail = false;
	private Boolean checkDate = false;
	
	private Boolean checkQ1 = false;
	private Boolean checkQ2City = false;
	private Boolean checkQ2Zipcode = false;

	
	/**
	 * @wbp.parser.constructor
	 */
	public SurveyPage1() {
		initialize();
	}


	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSurveyP1 = new JFrame();
		frameSurveyP1.setTitle("Survey Page 1/4");
		frameSurveyP1.setBounds(100, 100, 825, 500);
		frameSurveyP1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSurveyP1.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frameSurveyP1.setVisible(true);
		
		JPanel panelSurveyP1 = new JPanel();
		frameSurveyP1.getContentPane().add(panelSurveyP1);
		panelSurveyP1.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 42, 150, 15);
		panelSurveyP1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 72, 150, 15);
		panelSurveyP1.add(lblLastName);
		
		JLabel lblNetId = new JLabel("Net ID:");
		lblNetId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNetId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNetId.setBounds(10, 102, 150, 15);
		panelSurveyP1.add(lblNetId);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(10, 132, 150, 15);
		panelSurveyP1.add(lblEmail);

		tfFirstName = new JTextField();
		tfFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfFirstName.setBounds(170, 42, 150, 20);
		panelSurveyP1.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfLastName.setColumns(10);
		tfLastName.setBounds(170, 72, 150, 20);
		panelSurveyP1.add(tfLastName);
		
		tfNetID = new JTextField();
		tfNetID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNetID.setColumns(10);
		tfNetID.setBounds(170, 102, 100, 20);
		panelSurveyP1.add(tfNetID);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(170, 132, 200, 20);
		panelSurveyP1.add(tfEmail);
		
		
		JLabel lblQ1 = new JLabel("1.) Are you living on Campus as of Fall 2020? ");
		lblQ1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblQ1.setHorizontalAlignment(SwingConstants.LEFT);
		lblQ1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ1.setBounds(35, 222, 350, 16);
		panelSurveyP1.add(lblQ1);
		
		rdbtnQ1Yes = new JRadioButton("Yes");
		rdbtnQ1Yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ1Yes.setBounds(55, 247, 103, 21);
		panelSurveyP1.add(rdbtnQ1Yes);
		
		rdbtnQ1No = new JRadioButton("No");
		rdbtnQ1No.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ1No.setBounds(55, 272, 103, 21);
		panelSurveyP1.add(rdbtnQ1No);
		
		JLabel lblQ2 = new JLabel("2.) Where are you currently located in?");
		lblQ2.setHorizontalAlignment(SwingConstants.LEFT);
		lblQ2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ2.setBounds(35, 307, 350, 15);
		panelSurveyP1.add(lblQ2);
		
		JLabel lblQ2City = new JLabel("City:");
		lblQ2City.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQ2City.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ2City.setBounds(85, 337, 75, 15);
		panelSurveyP1.add(lblQ2City);
		
		JLabel lblQ2ZipCode = new JLabel("Zipcode:");
		lblQ2ZipCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQ2ZipCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ2ZipCode.setBounds(85, 367, 75, 15);
		panelSurveyP1.add(lblQ2ZipCode);
		
		tfQ2Zipcode = new JTextField();
		tfQ2Zipcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfQ2Zipcode.setColumns(10);
		tfQ2Zipcode.setBounds(170, 367, 100, 20);
		panelSurveyP1.add(tfQ2Zipcode);
		
		tfQ2City = new JTextField();
		tfQ2City.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfQ2City.setColumns(10);
		tfQ2City.setBounds(170, 337, 150, 20);
		panelSurveyP1.add(tfQ2City);
		
		btnExit1 = new JButton("Cancel & Exit");
		btnExit1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit1.setBounds(10, 423, 130, 30);
		panelSurveyP1.add(btnExit1);
		
		btnNextPage1 = new JButton("Next Page");
		btnNextPage1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNextPage1.setBounds(671, 423, 130, 30);
		btnNextPage1.setEnabled(false);
		panelSurveyP1.add(btnNextPage1);
		
		groupQ1 = new ButtonGroup();
		groupQ1.add(rdbtnQ1Yes);
		groupQ1.add(rdbtnQ1No);
		
		JLabel lblDate = new JLabel("Date (yyyy-mm-dd):");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDate.setBounds(10, 162, 150, 15);
		panelSurveyP1.add(lblDate);
		
		tfDate = new JTextField();
		tfDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDate.setColumns(10);
		tfDate.setBounds(170, 162, 100, 20);
		panelSurveyP1.add(tfDate);
		
		tfCheckFName = new JTextField();
		tfCheckFName.setBackground(Color.RED);
		tfCheckFName.setEnabled(false);
		tfCheckFName.setEditable(false);
		tfCheckFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckFName.setColumns(10);
		tfCheckFName.setBounds(400, 42, 20, 20);
		panelSurveyP1.add(tfCheckFName);
		
		tfCheckLName = new JTextField();
		tfCheckLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckLName.setEnabled(false);
		tfCheckLName.setEditable(false);
		tfCheckLName.setColumns(10);
		tfCheckLName.setBackground(Color.RED);
		tfCheckLName.setBounds(400, 72, 20, 20);
		panelSurveyP1.add(tfCheckLName);
		
		tfCheckNetID = new JTextField();
		tfCheckNetID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckNetID.setEnabled(false);
		tfCheckNetID.setEditable(false);
		tfCheckNetID.setColumns(10);
		tfCheckNetID.setBackground(Color.RED);
		tfCheckNetID.setBounds(400, 102, 20, 20);
		panelSurveyP1.add(tfCheckNetID);
		
		tfCheckEmail = new JTextField();
		tfCheckEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckEmail.setEnabled(false);
		tfCheckEmail.setEditable(false);
		tfCheckEmail.setColumns(10);
		tfCheckEmail.setBackground(Color.RED);
		tfCheckEmail.setBounds(400, 132, 20, 20);
		panelSurveyP1.add(tfCheckEmail);
		
		tfCheckDate = new JTextField();
		tfCheckDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckDate.setEnabled(false);
		tfCheckDate.setEditable(false);
		tfCheckDate.setColumns(10);
		tfCheckDate.setBackground(Color.RED);
		tfCheckDate.setBounds(400, 162, 20, 20);
		panelSurveyP1.add(tfCheckDate);
		
		tfCheckQ2City = new JTextField();
		tfCheckQ2City.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ2City.setEnabled(false);
		tfCheckQ2City.setEditable(false);
		tfCheckQ2City.setColumns(10);
		tfCheckQ2City.setBackground(Color.RED);
		tfCheckQ2City.setBounds(400, 337, 20, 20);
		panelSurveyP1.add(tfCheckQ2City);
		
		tfCheckQ2Zip = new JTextField();
		tfCheckQ2Zip.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ2Zip.setEnabled(false);
		tfCheckQ2Zip.setEditable(false);
		tfCheckQ2Zip.setColumns(10);
		tfCheckQ2Zip.setBackground(Color.RED);
		tfCheckQ2Zip.setBounds(400, 367, 20, 20);
		panelSurveyP1.add(tfCheckQ2Zip);
		
		tfCheckQ1 = new JTextField();
		tfCheckQ1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ1.setEnabled(false);
		tfCheckQ1.setEditable(false);
		tfCheckQ1.setColumns(10);
		tfCheckQ1.setBackground(Color.RED);
		tfCheckQ1.setBounds(400, 218, 20, 20);
		panelSurveyP1.add(tfCheckQ1);
		
		tfNetID.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkNextPage();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkNextPage();
			}
			
		});
		

		
		tfFirstName.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkNextPage();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkNextPage();
			}
			
		});
		
		tfLastName.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkNextPage();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkNextPage();
			}
			
		});
		
		tfEmail.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkNextPage();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkNextPage();
			}
			
		});
		
		tfDate.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkNextPage();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkNextPage();
			}
			
		});
		
		
		rdbtnQ1Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		rdbtnQ1No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		tfQ2City.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkNextPage();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkNextPage();
			}
			
		});
		
		tfQ2Zipcode.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkNextPage();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkNextPage();
			}
			
		});
		
		btnNextPage1.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				
				
				JSONObject studentJSON = new JSONObject();
				studentJSON.put("firstName", tfFirstName.getText());
				studentJSON.put("lastName", tfLastName.getText());
				studentJSON.put("email", tfEmail.getText());
				studentJSON.put("netID", tfNetID.getText());
				
				
				JSONObject surveyJSON = new JSONObject();
				surveyJSON.put("date", tfDate.getText());
				boolean onCampus = false;
				if (rdbtnQ1Yes.isSelected()) {
					onCampus = true;
				}
				surveyJSON.put("onCampus", onCampus);
				surveyJSON.put("city", tfQ2City.getText());
				surveyJSON.put("zip", tfQ2Zipcode.getText());

				
				// Pass student/survey data along to page 2
				surveyPage2 = new SurveyPage2(studentJSON, surveyJSON);
				
				frameSurveyP1.setVisible(false);
			}
		});
		
		btnExit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(1);
			}
		});
		
		tfNetID.setText(LoginPage.loginUserName);
		tfEmail.setText(LoginPage.loginUserName + "@utdallas.edu");
		
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		todaysDate = new Date();
		surveyDate = todaysDate;
		
		tfDate.setText(dateFormat.format(todaysDate));
		dateFormat.setLenient(false);
	}
	
	
	protected void checkNextPage() {
		
		if (!tfNetID.getText().equals("")) {
			
			String regexNet = "^[A-Za-z]{3}[0-9]{6}$";
			
			if (tfNetID.getText().matches(regexNet)) {
				
				checkNetID = true;
				tfCheckNetID.setBackground(Color.GREEN);
				
			} else {
				
				checkNetID = false;
				tfCheckNetID.setBackground(Color.RED);
			}
			
		}
		else {
			
			checkNetID = false;
			tfCheckNetID.setBackground(Color.RED);
		}
		
		
		if (!tfFirstName.getText().equals("")) {
			
			checkFirstName = true;
			tfCheckFName.setBackground(Color.GREEN);
			
		}
		else {
			
			checkFirstName = false;
			tfCheckFName.setBackground(Color.RED);
		}
		
		if (!tfLastName.getText().equals("")) {
			
			checkLastName = true;
			tfCheckLName.setBackground(Color.GREEN);
		}
		else {
			
			checkLastName = false;
			tfCheckLName.setBackground(Color.RED);
		}
		
		if (!tfEmail.getText().equals("")) {
			
			String regexEmail = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)";
			
			if (tfEmail.getText().matches(regexEmail)) {
				checkEmail = true;
				tfCheckEmail.setBackground(Color.GREEN);
			}
			else {
				
				checkEmail = false;
				tfCheckEmail.setBackground(Color.RED);
			}
		}
		else {
			
			checkEmail = false;
			tfCheckEmail.setBackground(Color.RED);
		}
		
		if (!tfDate.getText().equals("")) {
			
				
			String regexDate = "[2-9][0-9][0-9][0-9]-[0-9][0-2]-[0-3][0-9]";
			
			if (tfDate.getText().matches(regexDate)) {
				
				try {

					surveyDate = dateFormat.parse(tfDate.getText());
					
					if (surveyDate.compareTo(todaysDate) <= 0) {
						
						checkDate = true;
						tfCheckDate.setBackground(Color.GREEN);
					}

				} catch (ParseException e) {

					checkDate = false;
					tfCheckDate.setBackground(Color.RED);
				}
				
				
			} else {
				
				checkDate = false;
				tfCheckDate.setBackground(Color.RED);
			}
		}
		else {
		
			checkDate = false;
			tfCheckDate.setBackground(Color.RED);
		}
		
		if (rdbtnQ1Yes.isSelected() || rdbtnQ1No.isSelected()) {
			
			checkQ1 = true;
			tfCheckQ1.setBackground(Color.GREEN);
		}
		else {
			
			checkQ1 = false;
			tfCheckQ1.setBackground(Color.RED);
		}
		
		if (!tfQ2City.getText().equals("")) {
			
			checkQ2City = true;
			tfCheckQ2City.setBackground(Color.GREEN);
		}
		else {
			
			checkQ2City = false;
			tfCheckQ2City.setBackground(Color.RED);
		}
		
		
		if (tfQ2Zipcode.getText().length() == 5) {
			
			String regexZip = "[0-9]{5}";
			
			if (tfQ2Zipcode.getText().matches(regexZip)) {
			
				checkQ2Zipcode = true;
				tfCheckQ2Zip.setBackground(Color.GREEN);
			}
			else {
				
				checkQ2Zipcode = false;
				tfCheckQ2Zip.setBackground(Color.RED);
			}
		}
		else {
			
			checkQ2Zipcode = false;
			tfCheckQ2Zip.setBackground(Color.RED);
		}
		
		if ((checkNetID) && (checkFirstName) && (checkLastName) && (checkEmail)
			&& (checkDate) && (checkQ1) && (checkQ2City) && (checkQ2Zipcode)) {
			
			btnNextPage1.setEnabled(true);
		}
		else {
			
			btnNextPage1.setEnabled(false);
		}

	}
}
