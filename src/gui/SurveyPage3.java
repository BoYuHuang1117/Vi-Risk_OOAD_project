import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import java.awt.Color;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class SurveyPage3 {

	private JFrame frameSurveyP3;
	private JLabel lblQ7;
	private JRadioButton rdbtnQ7No;
	private JRadioButton rdbtnQ7Yes;
	private JLabel lblQ8;
	private JCheckBox chckbxQ8_1;
	private JCheckBox chckbxQ8_2;
	private JCheckBox chckbxQ8_3;
	private JCheckBox chckbxQ8_4;
	private JLabel lblQ9;
	private JRadioButton rdbtnQ9Yes;
	private JRadioButton rdbtnQ9No;
	private JLabel lblQ10;
	private JRadioButton rdbtnQ10Yes;
	private JRadioButton rdbtnQ10No;
	private ButtonGroup groupQ7;
	private ButtonGroup groupQ9;
	private ButtonGroup groupQ10;
	private JButton btnNextPage3;
	private JButton btnExit3;
	
	private Boolean checkQ7 = false;
	private Boolean checkQ8 = false;
	private Boolean checkQ9 = false;
	private Boolean checkQ10 = false;
	
	SurveyPage4 surveyPage4;
	private JSONObject studentJSON;
	private JSONObject surveyJSON;
	private JTextField tfCheckQ7;
	private JTextField tfCheckQ8;
	private JTextField tfCheckQ9;
	private JTextField tfCheckQ10;
	
	/**
	 * @wbp.parser.constructor
	 */
	public SurveyPage3() {
		initialize();
	}
	
	
	/**
	 * Initialize page 3 using a student account and their answers from previous pages
	 */
	public SurveyPage3(JSONObject stud, JSONObject surv) {
		initialize();
		studentJSON = new JSONObject(stud);
		surveyJSON = new JSONObject(surv);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSurveyP3 = new JFrame();
		frameSurveyP3.setTitle("Survey Page 3/4");
		frameSurveyP3.setBounds(100, 100, 825, 500);
		frameSurveyP3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSurveyP3.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frameSurveyP3.setVisible(true);
		
		JPanel panelSurveyp3 = new JPanel();
		frameSurveyP3.getContentPane().add(panelSurveyp3);
		panelSurveyp3.setLayout(null);
		
		lblQ7 = new JLabel("7.) Do you personally know anyone with Covid?");
		lblQ7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ7.setBounds(35, 10, 350, 20);
		panelSurveyp3.add(lblQ7);
		
		rdbtnQ7Yes = new JRadioButton("Yes");
		rdbtnQ7Yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ7Yes.setBounds(55, 36, 111, 23);
		panelSurveyp3.add(rdbtnQ7Yes);
		
		rdbtnQ7No = new JRadioButton("No");
		rdbtnQ7No.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ7No.setBounds(55, 65, 111, 23);
		panelSurveyp3.add(rdbtnQ7No);
		
		lblQ8 = new JLabel("8.) If yes, what is your relationship to them?");
		lblQ8.setEnabled(false);
		lblQ8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ8.setBounds(35, 113, 350, 20);
		panelSurveyp3.add(lblQ8);
		
		lblQ9 = new JLabel("9.) Have you been in contact with anyone with Covid within the last 2 weeks?");
		lblQ9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ9.setBounds(35, 245, 566, 20);
		panelSurveyp3.add(lblQ9);
		
		lblQ10 = new JLabel("10.) Have you attended a gathering with five or more people within seven days?");
		lblQ10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ10.setBounds(35, 339, 575, 20);
		panelSurveyp3.add(lblQ10);
		
		chckbxQ8_1 = new JCheckBox("Family");
		chckbxQ8_1.setEnabled(false);
		chckbxQ8_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ8_1.setBounds(55, 146, 99, 23);
		panelSurveyp3.add(chckbxQ8_1);
		
		chckbxQ8_2 = new JCheckBox("Work");
		chckbxQ8_2.setEnabled(false);
		chckbxQ8_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ8_2.setBounds(55, 172, 99, 23);
		panelSurveyp3.add(chckbxQ8_2);
		
		chckbxQ8_3 = new JCheckBox("School");
		chckbxQ8_3.setEnabled(false);
		chckbxQ8_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ8_3.setBounds(55, 200, 99, 23);
		panelSurveyp3.add(chckbxQ8_3);
		
		chckbxQ8_4 = new JCheckBox("Other");
		chckbxQ8_4.setEnabled(false);
		chckbxQ8_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ8_4.setBounds(197, 146, 99, 23);
		panelSurveyp3.add(chckbxQ8_4);
		
		rdbtnQ9Yes = new JRadioButton("Yes");
		rdbtnQ9Yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ9Yes.setBounds(56, 270, 111, 23);
		panelSurveyp3.add(rdbtnQ9Yes);
		
		rdbtnQ9No = new JRadioButton("No");
		rdbtnQ9No.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ9No.setBounds(56, 294, 111, 23);
		panelSurveyp3.add(rdbtnQ9No);
		
		rdbtnQ10Yes = new JRadioButton("Yes");
		rdbtnQ10Yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ10Yes.setBounds(55, 361, 111, 23);
		panelSurveyp3.add(rdbtnQ10Yes);
		
		rdbtnQ10No = new JRadioButton("No");
		rdbtnQ10No.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ10No.setBounds(55, 387, 111, 23);
		panelSurveyp3.add(rdbtnQ10No);
		
		groupQ7 = new ButtonGroup();
		groupQ7.add(rdbtnQ7Yes);
		groupQ7.add(rdbtnQ7No);
		
		groupQ9 = new ButtonGroup();
		groupQ9.add(rdbtnQ9Yes);
		groupQ9.add(rdbtnQ9No);
		
		groupQ10 = new ButtonGroup();
		groupQ10.add(rdbtnQ10Yes);
		groupQ10.add(rdbtnQ10No);
		
		btnNextPage3 = new JButton("Next Page");
		btnNextPage3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNextPage3.setBounds(671, 423, 130, 30);
		panelSurveyp3.add(btnNextPage3);
		
		btnExit3 = new JButton("Cancel & Exit");
		btnExit3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit3.setBounds(10, 423, 130, 30);
		panelSurveyp3.add(btnExit3);
		
		tfCheckQ7 = new JTextField();
		tfCheckQ7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ7.setEnabled(false);
		tfCheckQ7.setEditable(false);
		tfCheckQ7.setColumns(10);
		tfCheckQ7.setBackground(Color.RED);
		tfCheckQ7.setBounds(395, 10, 20, 20);
		panelSurveyp3.add(tfCheckQ7);
		
		tfCheckQ8 = new JTextField();
		tfCheckQ8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ8.setEnabled(false);
		tfCheckQ8.setEditable(false);
		tfCheckQ8.setColumns(10);
		tfCheckQ8.setBackground(Color.RED);
		tfCheckQ8.setBounds(395, 113, 20, 20);
		panelSurveyp3.add(tfCheckQ8);
		
		tfCheckQ9 = new JTextField();
		tfCheckQ9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ9.setEnabled(false);
		tfCheckQ9.setEditable(false);
		tfCheckQ9.setColumns(10);
		tfCheckQ9.setBackground(Color.RED);
		tfCheckQ9.setBounds(620, 245, 20, 20);
		panelSurveyp3.add(tfCheckQ9);
		
		tfCheckQ10 = new JTextField();
		tfCheckQ10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ10.setEnabled(false);
		tfCheckQ10.setEditable(false);
		tfCheckQ10.setColumns(10);
		tfCheckQ10.setBackground(Color.RED);
		tfCheckQ10.setBounds(620, 339, 20, 20);
		panelSurveyp3.add(tfCheckQ10);
		
		rdbtnQ7Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
				lblQ8.setEnabled(true);
				
				chckbxQ8_1.setEnabled(true);
				chckbxQ8_2.setEnabled(true);
				chckbxQ8_3.setEnabled(true);
				chckbxQ8_4.setEnabled(true);
			}
		});
		
		rdbtnQ7No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
				lblQ8.setEnabled(false);
				
				chckbxQ8_1.setSelected(false);
				chckbxQ8_2.setSelected(false);
				chckbxQ8_3.setSelected(false);
				chckbxQ8_4.setSelected(false);
				
				chckbxQ8_1.setEnabled(false);
				chckbxQ8_2.setEnabled(false);
				chckbxQ8_3.setEnabled(false);
				chckbxQ8_4.setEnabled(false);
			}
		});
		
		chckbxQ8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		chckbxQ8_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		chckbxQ8_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		chckbxQ8_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		rdbtnQ9Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		rdbtnQ9No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		rdbtnQ10Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		rdbtnQ10No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
			}
		});
		
		btnNextPage3.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				
				
				boolean knowsPatient = false;
				JSONArray relationships = new JSONArray();
				boolean patientContact = false;
				boolean gathering = false;
				
				// relationships and patientContact are only relevant if knowsPatient==true
				if (rdbtnQ7Yes.isSelected()) {
					knowsPatient = true;
							
					if (chckbxQ8_1.isSelected()) {
						relationships.add(chckbxQ8_1.getText());
					}
					if (chckbxQ8_2.isSelected()) {
						relationships.add(chckbxQ8_2.getText());
					}
					if (chckbxQ8_3.isSelected()) {
						relationships.add(chckbxQ8_3.getText());
					}
					if (chckbxQ8_4.isSelected()) {
						relationships.add(chckbxQ8_4.getText());
					}
					if (rdbtnQ9Yes.isSelected()) {
						patientContact = true;
					}
				}
				
				if (rdbtnQ10Yes.isSelected()) {
					gathering = true;
				}
				
				
				surveyJSON.put("knowsPatient", knowsPatient);
				surveyJSON.put("relationships", relationships);
				surveyJSON.put("patientContact", patientContact);
				surveyJSON.put("gathering", gathering);
				

				
				// Go to page 4
				surveyPage4 = new SurveyPage4(studentJSON, surveyJSON);
				
				frameSurveyP3.setVisible(false);
			}
		});
		
		btnExit3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		
		
	}
	
	protected void checkNextPage() {
		
		if (rdbtnQ7No.isSelected()) {
			
			checkQ7 = true;
			tfCheckQ7.setBackground(Color.GREEN);
			
			checkQ8 = true;
			tfCheckQ8.setBackground(Color.GREEN);	
		}
		else if (rdbtnQ7Yes.isSelected()) {
				
			checkQ7 = true;
			tfCheckQ7.setBackground(Color.GREEN);
			
			if ((chckbxQ8_1.isSelected()) || (chckbxQ8_2.isSelected())
				|| (chckbxQ8_3.isSelected()) || (chckbxQ8_4.isSelected())) {
				
				checkQ8 = true;
				tfCheckQ8.setBackground(Color.GREEN);
			}
			else {
				
				checkQ8 = false;
				tfCheckQ8.setBackground(Color.RED);
			}
		}	
		else {
			
			checkQ7 = false;
			tfCheckQ7.setBackground(Color.RED);
			
			checkQ8 = false;
			tfCheckQ8.setBackground(Color.RED);
		}
		
		if (rdbtnQ9Yes.isSelected() || rdbtnQ9No.isSelected()) {
			
			checkQ9 = true;
			tfCheckQ9.setBackground(Color.GREEN);
		}
		else {
			
			checkQ9 = false;
			tfCheckQ9.setBackground(Color.RED);
		}
		
		if (rdbtnQ10Yes.isSelected() || rdbtnQ10No.isSelected()) {
			
			checkQ10 = true;
			tfCheckQ10.setBackground(Color.GREEN);
		}
		else {
			
			checkQ10 = false;
			tfCheckQ10.setBackground(Color.RED);
		}
		
		
		if ((checkQ7) && (checkQ8) && (checkQ9) && (checkQ10)) {
			
			btnNextPage3.setEnabled(true);
		}
		else {
			
			btnNextPage3.setEnabled(false);
		}
	}
}
