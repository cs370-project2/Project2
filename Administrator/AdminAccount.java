package Administrator;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAccount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAccount frame = new AdminAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 601, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton createNewAccount = new JButton("Create New Account");
		createNewAccount.setBounds(46, 50, 174, 35);
		createNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewAccount cna = new CreateNewAccount();
				cna.setVisible(true);
			}
			
		});
		contentPane.add(createNewAccount);
		
		JButton delete = new JButton("Delete Existing Account");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * delete in DB
				 */
			}
		});
		delete.setBounds(46, 150, 174, 35);
		contentPane.add(delete);
		
		JButton modify = new JButton("Modify Existing Account");
		modify.setBounds(46, 250, 174, 35);
		contentPane.add(modify);
		
		JButton cardHolders = new JButton("View Card Holder Accounts");
		cardHolders.setBounds(46, 350, 174, 35);
		cardHolders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAllCardHolders vach = new ViewAllCardHolders();
				vach.setVisible(true);
			}
		});
		contentPane.add(cardHolders);
		
		JButton vendors = new JButton("View Vendor Accounts");
		vendors.setBounds(46, 450, 174, 35);
		vendors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAllVendors vav = new ViewAllVendors();
				vav.setVisible(true);
			}
		});
		contentPane.add(vendors);
	}
}
