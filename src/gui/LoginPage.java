import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginPage {

	static LoginPage loginPage;
	private JFrame frameLogin;
	private JTextField tfUserName;
	private JPasswordField tfPassword;
	private JButton btnLogin;

	MainPage mainPage;
	
	static String loginUserName = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB_mgr.downloadFile();
					DB_mgr.checkDate();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					loginPage = new LoginPage();
					loginPage.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setTitle("TRL Survey App");
		frameLogin.setBounds(100, 100, 825, 500);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelLogin = new JPanel();
		frameLogin.getContentPane().add(panelLogin);
		
		JLabel lblLoginPortal = new JLabel("UTD Login Portal");
		lblLoginPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPortal.setBounds(300, 130, 225, 30);
		lblLoginPortal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblUserName = new JLabel("username:");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setBounds(295, 195, 77, 20);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(298, 230, 73, 20);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tfUserName = new JTextField();
		tfUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUserName.setBounds(376, 195, 149, 20);
		tfUserName.setColumns(10);
		panelLogin.setLayout(null);
		panelLogin.add(lblLoginPortal);
		panelLogin.add(lblUserName);
		panelLogin.add(lblPassword);
		panelLogin.add(tfUserName);
		
		btnLogin = new JButton("Login");
		btnLogin.setEnabled(false);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(295, 283, 230, 48);
		panelLogin.add(btnLogin);
		
		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPassword.setBounds(376, 230, 149, 20);
		panelLogin.add(tfPassword);
		
		
		tfUserName.getDocument().addDocumentListener(new DocumentListener() {
			  
				@Override
				public void insertUpdate(DocumentEvent e) {
					
					checkLogin();
				}
			
				@Override
				public void removeUpdate(DocumentEvent e) {
					
					checkLogin();
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {	
				}
		});
		
		tfPassword.getDocument().addDocumentListener(new DocumentListener() {
			  
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				checkLogin();
			}
		
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				checkLogin();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {	
			}
	});

		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				loginUserName = tfUserName.getText();

				// Go to main menu
				mainPage = new MainPage();
				
				
				frameLogin.setVisible(false);
				frameLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frameLogin.dispose();
				
			}
	     });
	
	}
	
	@SuppressWarnings("deprecation")
	protected void checkLogin() {
		
		if(!tfUserName.getText().equals("") && !tfPassword.getText().equals("")) {
			
			String regex = "^[A-Za-z]{3}[0-9]{6}$";
			String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
			
			if (tfUserName.getText().matches(regex) && tfPassword.getText().matches(regexPassword)) {
				
				btnLogin.setEnabled(true);
				
			} else {
				
				btnLogin.setEnabled(false);
			}
	        
	    }else {
	    	
	    	btnLogin.setEnabled(false);
	    }
	}
}
