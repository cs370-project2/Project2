package CardHolder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
					MakeAPayment frame = new MakeAPayment();
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
	public MakeAPayment() {
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
				setVisible(false);
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
		
		JButton payNow = new JButton("Pay Now");
		payNow.setBackground(Color.GREEN);
		payNow.setForeground(Color.BLACK);
		payNow.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		payNow.setBounds(335, 290, 152, 56);
		payNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String money = textField.getText();
				/*
				 * check that money is a number and the number is less than the balance
				 */
				
				System.out.println("You paid " + money + ". Thankyou.");
				
			}
			
		});
		contentPane.add(payNow);
	}
}
