package CardHolder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Account extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account frame = new Account();
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
	public Account() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 601, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea top = new JTextArea();
		top.setEditable(false);
		top.setBounds(29, 53, 525, 97);
		top.setText("Account name: \nCard number: \nCredit limit: \nAmount due :");
		contentPane.add(top);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(29, 187, 525, 228);
		contentPane.add(textArea);
		
		JLabel lblAccountStatement = new JLabel("Account Statement");
		lblAccountStatement.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblAccountStatement.setBounds(29, 11, 210, 31);
		contentPane.add(lblAccountStatement);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(537, 187, 17, 229);
		contentPane.add(scrollBar);
		
		JLabel lblRecentPurchases = new JLabel("Recent Purchases :");
		lblRecentPurchases.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblRecentPurchases.setBounds(29, 155, 120, 31);
		contentPane.add(lblRecentPurchases);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(29, 454, 525, 63);
		contentPane.add(textArea_1);
		
		JLabel payments = new JLabel("Payments :");
		payments.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		payments.setBounds(29, 429, 71, 14);
		contentPane.add(payments);
		
		JButton viewAll = new JButton("View All");
		viewAll.setBounds(465, 420, 89, 23);
		contentPane.add(viewAll);
		
		JButton makeAPayment = new JButton("Make a Payment");
		makeAPayment.setBounds(421, 526, 133, 23);
		makeAPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MakeAPayment map = new MakeAPayment();
				map.setVisible(true);
			}
		});
		contentPane.add(makeAPayment);
	}
}
