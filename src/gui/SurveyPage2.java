import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import org.json.simple.JSONObject;

public class SurveyPage2 {

	private JFrame frameSurveyP2;
	private JTextField tfQ4;
	
	private JSONObject studentJSON;
	private JSONObject surveyJSON;
	
	JLabel lblQ4;
	JLabel lblQ6;
	
	private JTextField tfCheckQ3;
	private JTextField tfCheckQ4;
	private JTextField tfCheckQ5;
	
	private JRadioButton rdbtnQ3Yes;
	private JRadioButton rdbtnQ3No;
	private JRadioButton rdbtnQ5Yes;
	private JRadioButton rdbtnQ5No;
	
	private JCheckBox chckbxQ6_1;
	private JCheckBox chckbxQ6_2;
	private JCheckBox chckbxQ6_3;
	private JCheckBox chckbxQ6_4;
	private JCheckBox chckbxQ6_5;
	private JCheckBox chckbxQ6_6;

	private JButton btnExit2;
	private JButton btnNextPage2;
	
	private Boolean checkQ3 = false;
	private Boolean checkQ4 = false;
	private Boolean checkQ5 = false;
	private Boolean checkQ6 = false;
	private JTextField tfCheckQ6;
	
	SurveyPage3 surveyPage3;
	
	/**
	 * @wbp.parser.constructor
	 */
	public SurveyPage2() {
		initialize();
	}
	
	/**
	 * Initialize page 2 with a student account and answers from previous page
	 */
	public SurveyPage2(JSONObject stud, JSONObject surv) {
		initialize();
		studentJSON = new JSONObject(stud);
		surveyJSON = new JSONObject(surv);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSurveyP2 = new JFrame();
		frameSurveyP2.setTitle("Survey Page 2/4");
		frameSurveyP2.setBounds(100, 100, 825, 500);
		frameSurveyP2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSurveyP2.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frameSurveyP2.setVisible(true);
		
		JPanel panelSurveyP2 = new JPanel();
		frameSurveyP2.getContentPane().add(panelSurveyP2);
		panelSurveyP2.setLayout(null);
		
		JLabel lblQ3 = new JLabel("3.) Are you currently living with anyone?");
		lblQ3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ3.setBounds(35, 40, 295, 20);
		panelSurveyP2.add(lblQ3);
		
		rdbtnQ3Yes = new JRadioButton("Yes");
		rdbtnQ3Yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ3Yes.setBounds(55, 65, 103, 21);
		panelSurveyP2.add(rdbtnQ3Yes);
		
		rdbtnQ3No = new JRadioButton("No");
		rdbtnQ3No.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ3No.setBounds(55, 90, 103, 21);
		panelSurveyP2.add(rdbtnQ3No);
		
		JLabel lblQ4 = new JLabel("4.) If yes, how many people? ");
		lblQ4.setEnabled(false);
		lblQ4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ4.setBounds(35, 125, 220, 20);
		panelSurveyP2.add(lblQ4);
		
		tfQ4 = new JTextField();
		tfQ4.setEnabled(false);
		tfQ4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfQ4.setColumns(10);
		tfQ4.setBounds(259, 125, 50, 20);
		panelSurveyP2.add(tfQ4);
		
		JLabel lblQ5 = new JLabel("5.) Do you have a mask? ");
		lblQ5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ5.setBounds(35, 160, 270, 20);
		panelSurveyP2.add(lblQ5);
		
		rdbtnQ5Yes = new JRadioButton("Yes");
		rdbtnQ5Yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ5Yes.setBounds(55, 185, 103, 21);
		panelSurveyP2.add(rdbtnQ5Yes);
		
		rdbtnQ5No = new JRadioButton("No");
		rdbtnQ5No.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnQ5No.setBounds(55, 210, 103, 21);
		panelSurveyP2.add(rdbtnQ5No);
		
		JLabel lblQ6 = new JLabel("6.) If yes, please check all that apply:");
		lblQ6.setEnabled(false);
		lblQ6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQ6.setBounds(35, 245, 285, 20);
		panelSurveyP2.add(lblQ6);
		
		chckbxQ6_1 = new JCheckBox("Paper Mask");
		chckbxQ6_1.setEnabled(false);
		chckbxQ6_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ6_1.setBounds(55, 270, 200, 20);
		panelSurveyP2.add(chckbxQ6_1);
		
		chckbxQ6_2 = new JCheckBox("Cloth (Reusable) Mask");
		chckbxQ6_2.setEnabled(false);
		chckbxQ6_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ6_2.setBounds(55, 292, 200, 20);
		panelSurveyP2.add(chckbxQ6_2);
		
		chckbxQ6_3 = new JCheckBox("Home-made mask");
		chckbxQ6_3.setEnabled(false);
		chckbxQ6_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ6_3.setBounds(55, 314, 200, 20);
		panelSurveyP2.add(chckbxQ6_3);
		
		chckbxQ6_4 = new JCheckBox("A KN95+ Certified Mask");
		chckbxQ6_4.setEnabled(false);
		chckbxQ6_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ6_4.setBounds(55, 336, 200, 20);
		panelSurveyP2.add(chckbxQ6_4);
		
		chckbxQ6_5 = new JCheckBox("An N95+ Certified Mask");
		chckbxQ6_5.setEnabled(false);
		chckbxQ6_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ6_5.setBounds(55, 358, 200, 20);
		panelSurveyP2.add(chckbxQ6_5);
		
		chckbxQ6_6 = new JCheckBox("A P95+ Certified Mask");
		chckbxQ6_6.setEnabled(false);
		chckbxQ6_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxQ6_6.setBounds(55, 380, 200, 20);
		panelSurveyP2.add(chckbxQ6_6);
		
		btnExit2 = new JButton("Cancel & Exit");
		btnExit2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit2.setBounds(10, 423, 130, 30);
		panelSurveyP2.add(btnExit2);
		
		btnNextPage2 = new JButton("Next Page");
		btnNextPage2.setEnabled(false);
		btnNextPage2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNextPage2.setBounds(671, 423, 130, 30);
		panelSurveyP2.add(btnNextPage2);
		
		ButtonGroup groupQ3 = new ButtonGroup();
		groupQ3.add(rdbtnQ3Yes);
		groupQ3.add(rdbtnQ3No);
		
		ButtonGroup groupQ5 = new ButtonGroup();
		groupQ5.add(rdbtnQ5Yes);
		groupQ5.add(rdbtnQ5No);
		
		tfCheckQ3 = new JTextField();
		tfCheckQ3.setEditable(false);
		tfCheckQ3.setEnabled(false);
		tfCheckQ3.setBackground(Color.RED);
		tfCheckQ3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ3.setColumns(10);
		tfCheckQ3.setBounds(340, 40, 20, 20);
		panelSurveyP2.add(tfCheckQ3);
		
		tfCheckQ4 = new JTextField();
		tfCheckQ4.setEnabled(false);
		tfCheckQ4.setEditable(false);
		tfCheckQ4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ4.setColumns(10);
		tfCheckQ4.setBackground(Color.RED);
		tfCheckQ4.setBounds(340, 125, 20, 20);
		panelSurveyP2.add(tfCheckQ4);
		
		tfCheckQ5 = new JTextField();
		tfCheckQ5.setEditable(false);
		tfCheckQ5.setEnabled(false);
		tfCheckQ5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ5.setColumns(10);
		tfCheckQ5.setBackground(Color.RED);
		tfCheckQ5.setBounds(340, 160, 20, 20);
		panelSurveyP2.add(tfCheckQ5);
		
		tfCheckQ6 = new JTextField();
		tfCheckQ6.setEnabled(false);
		tfCheckQ6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCheckQ6.setColumns(10);
		tfCheckQ6.setBackground(Color.RED);
		tfCheckQ6.setBounds(340, 245, 20, 20);
		panelSurveyP2.add(tfCheckQ6);
		
		rdbtnQ3Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
				lblQ4.setEnabled(true);
				tfQ4.setEnabled(true);
			}
		});
		
		rdbtnQ3No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
				lblQ4.setEnabled(false);
				tfQ4.setEnabled(false);
				tfQ4.setText("");
			}
		});
		
		tfQ4.getDocument().addDocumentListener(new DocumentListener() {

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
		
		rdbtnQ5Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
				lblQ6.setEnabled(true);
				
				chckbxQ6_1.setEnabled(true);
				chckbxQ6_2.setEnabled(true);
				chckbxQ6_3.setEnabled(true);
				chckbxQ6_4.setEnabled(true);
				chckbxQ6_5.setEnabled(true);
				chckbxQ6_6.setEnabled(true);		
			}
		});
		
		rdbtnQ5No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();
				lblQ6.setEnabled(false);
				
				chckbxQ6_1.setSelected(false);
				chckbxQ6_2.setSelected(false);
				chckbxQ6_3.setSelected(false);
				chckbxQ6_4.setSelected(false);
				chckbxQ6_5.setSelected(false);
				chckbxQ6_6.setSelected(false);
				
				chckbxQ6_1.setEnabled(false);
				chckbxQ6_2.setEnabled(false);
				chckbxQ6_3.setEnabled(false);
				chckbxQ6_4.setEnabled(false);
				chckbxQ6_5.setEnabled(false);
				chckbxQ6_6.setEnabled(false);
			}
		});
		
		chckbxQ6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();			
			}
		});
		
		chckbxQ6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();			
			}
		});
		
		chckbxQ6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();			
			}
		});
		
		chckbxQ6_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();			
			}
		});
		
		chckbxQ6_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();			
			}
		});
		
		chckbxQ6_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkNextPage();			
			}
		});
		
		btnNextPage2.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				
				// Just store numRoommates
				// If user says they have roommates, update the number
				int numRoommates = 0;
				if (rdbtnQ3Yes.isSelected()) {
					numRoommates += Integer.parseInt(tfQ4.getText());
				}
				
				// Set all the mask booleans
				boolean mask = false;
				if (rdbtnQ5Yes.isSelected()) {
					mask = true;
				} 
				boolean paperMask = false;
				if (chckbxQ6_1.isSelected()) {
					paperMask = true;
				}
				boolean clothMask = false;
				if (chckbxQ6_2.isSelected()) {
					clothMask = true;
				}
				boolean homemadeMask = false;
				if (chckbxQ6_3.isSelected()) {
					homemadeMask = true;
				}
				boolean kn95Mask = false;
				if (chckbxQ6_4.isSelected()) {
					kn95Mask = true;
				}
				boolean n95Mask = false;
				if (chckbxQ6_5.isSelected()) {
					n95Mask = true;
				}
				boolean p95Mask = false;
				if (chckbxQ6_6.isSelected()) {
					p95Mask = true;
				}
				
				// Put everything in JSONObject
				surveyJSON.put("numRoommates", numRoommates);
				surveyJSON.put("mask", mask);
				surveyJSON.put("paperMask", paperMask);
				surveyJSON.put("clothMask", clothMask);
				surveyJSON.put("homemadeMask", homemadeMask);
				surveyJSON.put("kn95Mask", kn95Mask);
				surveyJSON.put("n95Mask", n95Mask);
				surveyJSON.put("p95Mask", p95Mask);

				// Go to page 3
				surveyPage3 = new SurveyPage3(studentJSON, surveyJSON);
				
				frameSurveyP2.setVisible(false);
			}
		});
		
		btnExit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(1);
			}
		});
	}
	
	protected void checkNextPage() {
		
		if (rdbtnQ3No.isSelected()) {
			
			checkQ3 = true;
			tfCheckQ3.setBackground(Color.GREEN);
			
			checkQ4 = true;
			tfCheckQ4.setBackground(Color.GREEN);
		}
		else if (rdbtnQ3Yes.isSelected()) {
			
			checkQ3 = true;
			tfCheckQ3.setBackground(Color.GREEN);
			
			if (tfQ4.getText().equals("")) {
				
				checkQ4 = false;
				tfCheckQ4.setBackground(Color.RED);
			}
			else {
				
				String regexPeople = "[1-9][0-9]?";
				
				if (tfQ4.getText().matches(regexPeople)) {
					
					checkQ4 = true;
					tfCheckQ4.setBackground(Color.GREEN);
				}
				else {
					
					checkQ4 = false;
					tfCheckQ4.setBackground(Color.RED);
				}
			}
		}
		else {
			
			checkQ3 = false;
			tfCheckQ3.setBackground(Color.RED);
			
			checkQ4 = false;
			tfCheckQ4.setBackground(Color.RED);
		}
		
		if (rdbtnQ5No.isSelected()) {
			
			checkQ5 = true;
			tfCheckQ5.setBackground(Color.GREEN);
			
			checkQ6 = true;
			tfCheckQ6.setBackground(Color.GREEN);	
		}
		else if (rdbtnQ5Yes.isSelected()) {
				
			checkQ5 = true;
			tfCheckQ5.setBackground(Color.GREEN);
			
			if ((chckbxQ6_1.isSelected()) || (chckbxQ6_2.isSelected()) || (chckbxQ6_3.isSelected())
				|| (chckbxQ6_4.isSelected()) || (chckbxQ6_5.isSelected()) || (chckbxQ6_6.isSelected())) {
				
				checkQ6 = true;
				tfCheckQ6.setBackground(Color.GREEN);
			}
			else {
				
				checkQ6 = false;
				tfCheckQ6.setBackground(Color.RED);
			}
		}
		
		else {
			
			checkQ5 = false;
			tfCheckQ5.setBackground(Color.RED);
			
			checkQ6 = false;
			tfCheckQ6.setBackground(Color.RED);
		}
		
		
		
		if ((checkQ3) && (checkQ4) && (checkQ5) && (checkQ6)) {
			
			btnNextPage2.setEnabled(true);
		}
		else {
			
			btnNextPage2.setEnabled(false);
		}
		
	}
}
