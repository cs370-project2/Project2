package CardHolder;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton forgotPassword;
	private JButton newUser;
	private JButton loginBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 601, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		username.setBounds(82, 198, 61, 26);
		getContentPane().add(username);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		password.setBounds(82, 259, 61, 26);
		getContentPane().add(password);
		
		textField = new JTextField();
		textField.setBounds(183, 194, 179, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(183, 255, 179, 35);
		getContentPane().add(passwordField);
		
		JLabel title = new JLabel("Login");
		title .setFont(new Font("Sylfaen", Font.PLAIN, 35));
		title .setBounds(183, 24, 251, 56);
		getContentPane().add(title );
		
		forgotPassword = new JButton("Forgot password?");
		forgotPassword.setBounds(183, 301, 151, 26);
		contentPane.add(forgotPassword);
		
		newUser = new JButton("New User");
		newUser.setBounds(183, 338, 119, 35);
		newUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent click) {
						SignUp signup = new SignUp();
						signup.setVisible(true);
						dispose();
					}
				});
		contentPane.add(newUser);
		
		loginBtn = new JButton("Login");
		loginBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String pWord = passwordField.getText().toString();
				if(checkPWord(pWord)) {
					System.out.println("Your password is : " + pWord);
					/*
					 * check if the username and password are on a "activated" account
					 */
				}else
					System.out.println("That password is incorrect.");
			}
		});
		
		loginBtn.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		loginBtn.setBounds(412, 449, 151, 75);
		contentPane.add(loginBtn);
	}
	
	public boolean checkPWord(String f) {
		if(f.length() < 6) {
			return false;
		}else
			for (char c : f.toCharArray()) {
				if (Character.isDigit(c) == true) {
					return true;
				}
			}
		return false;
	}
}
