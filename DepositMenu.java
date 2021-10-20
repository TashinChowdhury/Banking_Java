import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositMenu extends Load{
	String Name;
	int CID;
	public JFrame Depositframe;
	private JTextField DepositField;
	public JTextField BalanceInfoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositMenu window = new DepositMenu("",-1);
					window.Depositframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DepositMenu(String name,int cid) {
		initialize();
		Name= name;
		CID = cid;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Depositframe = new JFrame();
		Depositframe.setBounds(100, 100, 450, 145);
		Depositframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Depositframe.getContentPane().setLayout(null);
		
		JLabel lblDepositAmount = new JLabel("Deposit Amount:");
		lblDepositAmount.setBounds(12, 13, 105, 16);
		Depositframe.getContentPane().add(lblDepositAmount);
		
		DepositField = new JTextField();
		DepositField.setBounds(129, 10, 291, 22);
		Depositframe.getContentPane().add(DepositField);
		DepositField.setColumns(10);
		
		JButton ConfirmDButton = new JButton("Confirm");
		ConfirmDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(DepositField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(ConfirmDButton,"Enter Deposit Amount","Invalid Deposit",JOptionPane.WARNING_MESSAGE);
				}else {
					BankDashboard b = new BankDashboard(Name,CID);
					u[CID].sBalance= u[CID].sBalance + Double.parseDouble(DepositField.getText());
					JOptionPane.showMessageDialog(ConfirmDButton,"Amount Deposited Successfully", "Confirmation Success",JOptionPane.WARNING_MESSAGE);
					
					b.setBalance(u[CID].sBalance);
					b.BankMainframe.setVisible(true);
				}
			}
		});
		ConfirmDButton.setBounds(129, 45, 97, 25);
		Depositframe.getContentPane().add(ConfirmDButton);
		
		JButton CancelDButton = new JButton("Cancel");
		CancelDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Depositframe.dispose();
			}
		});
		CancelDButton.setBounds(238, 45, 97, 25);
		Depositframe.getContentPane().add(CancelDButton);
	}
}
