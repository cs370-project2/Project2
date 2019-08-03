package CardHolder;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {
	private JTextField textFieldUN;//username textfield
	private JTextField textFieldCC;//creditcard textfield
	private JPasswordField passwordField;//password
	private JPasswordField passwordField_1;//retype
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp su = new SignUp();
					su.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		getContentPane().setFont(new Font("Sylfaen", Font.PLAIN, 30));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 601, 599);
		getContentPane().setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		username.setBounds(82, 198, 61, 26);
		getContentPane().add(username);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		password.setBounds(82, 336, 61, 26);
		getContentPane().add(password);
		
		JLabel retype = new JLabel("Re-Type Password");
		retype.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		retype.setBounds(23, 397, 120, 26);
		getContentPane().add(retype);
		
		JLabel creditCard = new JLabel("Credit Card");
		creditCard.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		creditCard.setBounds(71, 268, 72, 14);
		getContentPane().add(creditCard);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(183, 194, 179, 35);
		getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		textFieldCC = new JTextField();
		textFieldCC.setBounds(183, 258, 179, 35);
		getContentPane().add(textFieldCC);
		textFieldCC.setColumns(10);
		String creditcard = textFieldCC.getText();

		
		passwordField = new JPasswordField();
		passwordField.setBounds(183, 332, 179, 35);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(183, 393, 179, 35);
		getContentPane().add(passwordField_1);
		
		JButton activate = new JButton("Activate Account!");
		activate.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		activate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		activate.setBounds(361, 478, 192, 56);
		activate.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String pWord = new String(passwordField.getPassword());
				String pWord1 = new String(passwordField_1.getPassword());
				String uName = textFieldUN.getText();
				String cCard = textFieldCC.getText();
				
				
				System.out.println(pWord+pWord1+uName+cCard);
				if(checkCC(cCard)) {		//first check if creditcard is already in DB? check if that is a reasonable 
					if(pWord.equals(pWord1)) {
						if(checkPWord(pWord)) {
							System.out.println("Your username is : " + uName + "your password is : " + pWord);
							/*
							 * SAVE uName IN DB
							 * SAVE pWord IN DB
							 * set activated = true IN DB
							 * create Account object
							 */
							Account acnt = new Account();
							acnt.setVisible(true);
							dispose();
							
						}else
							JOptionPane.showMessageDialog(null, "That password is not alpanumeric " + "\n or is less than 6 characters." + pWord);
					}else
						JOptionPane.showMessageDialog(null, "Passwords don't match.");
				}else
					JOptionPane.showMessageDialog(null,"CRedit card is invalid");
					
			}
		});
		getContentPane().add(activate);
		
		JLabel title = new JLabel("Sign Up Today");
		title .setFont(new Font("Sylfaen", Font.PLAIN, 35));
		title .setBounds(141, 24, 251, 56);
		getContentPane().add(title );
		
		JButton haveAnAccount = new JButton("Returning User");
		haveAnAccount.setBackground(SystemColor.menu);
		haveAnAccount.setBounds(361, 91, 120, 23);
		haveAnAccount.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent click) {
						Login lgn = new Login();
						lgn.setVisible(true);
						dispose();						
					}
			
		});
		getContentPane().add(haveAnAccount);
	}
	public boolean checkPWord(String f) {
		if(f.length() < 6) {
			return false;
		}else
			for (char c : f.toCharArray()) {
				if (Character.isLetterOrDigit(c) == true) {
					return true;
				}
			}
		return false;
	}
	
	public boolean checkCC(String f) {
		if(f.length() != 4) {
			System.out.println("Credit card number is not four dgits.");
			return false;
		}else 
			try {
		        int d = Integer.parseInt(f);
		    } catch (NumberFormatException | NullPointerException nfe) {
		    	System.out.println("The credit card is inValid");
		        return false;
		    }
		return true;
	}

}
