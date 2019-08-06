package CardHolder;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.time.*;
import java.sql.*;
import java.math.BigDecimal;

public class MakeAPayment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeAPayment frame = new MakeAPayment("2255");
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
	public MakeAPayment(String card) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 601, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(429, 462, 89, 23);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acnt = new Account(card);
				acnt.setVisible(true);
				dispose();
			}
			
		});
		contentPane.add(cancel);
		
		textField = new JTextField();
		textField.setBounds(215, 189, 223, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAmountYouWant = new JLabel("Amount you want to pay :");
		lblAmountYouWant.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblAmountYouWant.setBounds(10, 189, 163, 36);
		contentPane.add(lblAmountYouWant);
		
		JLabel Msg = new JLabel("");
		Msg.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		Msg.setForeground(Color.red);
		Msg.setBounds(150, 239, 350, 26);
		getContentPane().add(Msg);
		
		JButton payNow = new JButton("Pay Now");
		payNow.setBackground(Color.GREEN);
		payNow.setForeground(Color.BLACK);
		payNow.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		payNow.setBounds(335, 290, 152, 56);
		payNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String money = textField.getText();
				
				if (!isNumeric(money)) {
					Msg.setText("Wrong input! Please insert correct numbers."); 
				} else  {
					pay(new BigDecimal(money), card);
					/*
					 * check that money is a number and the number is less than the balance
					 */
					//System.out.println("You paid " + money + ". Thankyou.");
					
					Account acnt = new Account(card);
					acnt.setVisible(true);
					dispose();
				}
				
			}
			
		});
		contentPane.add(payNow);
	}
	
	public void pay(BigDecimal money, String card) {
		java.util.Date date=new java.util.Date();	
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		try {
			Connection myConn = DriverManager.getConnection(
		               "jdbc:mysql://localhost:3306/cs370",
		               "root", "tashah1948");
			Statement myStmt = myConn.createStatement();
			String query = "insert into payments (card_number, date, amount) values (?, ?, ?)";
			PreparedStatement preparedStmt = myConn.prepareStatement(query);
			 preparedStmt.setString(1, card);
		     preparedStmt.setDate(2, sqlDate);
		     preparedStmt.setBigDecimal(3, money);
		     preparedStmt.execute();
		     myStmt.executeUpdate("update cardholders set balance = balance - " + money +" where cardNumber =" + card +";");
		     myConn.close();		
	    } catch (Exception exc) {
	        System.err.println("Got an exception!");
	        System.err.println(exc.getMessage());
	    }
	}
	
	public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }
}
