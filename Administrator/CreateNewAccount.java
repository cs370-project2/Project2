package Administrator;

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

public class CreateNewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewAccount frame = new CreateNewAccount();
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
	public CreateNewAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 601, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateANew = new JLabel("Create a new Credit Card User Account");
		lblCreateANew.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblCreateANew.setBounds(139, 64, 294, 45);
		contentPane.add(lblCreateANew);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(66, 169, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblCreditcardNumber = new JLabel("CreditCard Number :");
		lblCreditcardNumber.setBounds(38, 249, 134, 14);
		contentPane.add(lblCreditcardNumber);
		
		JLabel lblCreditLimit = new JLabel("Credit Limit :");
		lblCreditLimit.setBounds(66, 329, 68, 14);
		contentPane.add(lblCreditLimit);
		
		textField = new JTextField();
		textField.setBounds(204, 169, 161, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 249, 161, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 329, 161, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton create = new JButton("Create");
		create.setBounds(333, 404, 89, 23);
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Create an account with  activated set to false? in DB
				 */
				System.out.println("Create an account");
				dispose();
			}
			
		});
		contentPane.add(create);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(333, 458, 89, 23);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(cancel);
	}

}
