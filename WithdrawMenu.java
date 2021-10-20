import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WithdrawMenu extends Load{
	String Name;
	int CID;
	public JFrame Withdrawframe;
	private JTextField WithdrawTextField;
	private JTextField BalanceInfoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawMenu window = new WithdrawMenu("",-1);
					window.Withdrawframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WithdrawMenu(String name, int cid) {
		initialize();
		Name=name;
		CID = cid;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Withdrawframe = new JFrame();
		Withdrawframe.setBounds(100, 100, 449, 179);
		Withdrawframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Withdrawframe.getContentPane().setLayout(null);
		
		JLabel lblWithdrawalAmount = new JLabel("Withdrawal Amount:");
		lblWithdrawalAmount.setBounds(12, 13, 125, 16);
		Withdrawframe.getContentPane().add(lblWithdrawalAmount);
		
		WithdrawTextField = new JTextField();
		WithdrawTextField.setBounds(149, 10, 270, 22);
		Withdrawframe.getContentPane().add(WithdrawTextField);
		WithdrawTextField.setColumns(10);
		
		JButton ConfirmWButton = new JButton("Confirm");
		ConfirmWButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(WithdrawTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(ConfirmWButton,"Enter Deposit Amount","Invalid Deposit",JOptionPane.WARNING_MESSAGE);
				}else {
					BankDashboard b = new BankDashboard(Name,CID);
					u[CID].sBalance= u[CID].sBalance - Double.parseDouble(WithdrawTextField.getText());
					
					JOptionPane.showMessageDialog(ConfirmWButton,"Amount Withdrawn Successfully", "Confirmation Message",JOptionPane.WARNING_MESSAGE);
					
					b.setBalance(u[CID].sBalance);
					b.BankMainframe.setVisible(true);
				}
			}
		});
		ConfirmWButton.setBounds(149, 55, 97, 25);
		Withdrawframe.getContentPane().add(ConfirmWButton);
		
		JButton CancelWButton = new JButton("Cancel");
		CancelWButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawframe.dispose();
			}
		});
		CancelWButton.setBounds(258, 55, 97, 25);
		Withdrawframe.getContentPane().add(CancelWButton);
	}
}
