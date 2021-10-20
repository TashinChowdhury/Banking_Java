import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteMenu extends Load{
	String Name;
	int CID;
	public JFrame Deleteframe;
	private JTextField WithdrawTextField;
	private JTextField BalanceInfoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMenu window = new DeleteMenu("",-1);
					window.Deleteframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteMenu(String name, int cid) {
		initialize();
		Name=name;
		CID = cid;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Deleteframe = new JFrame();
		Deleteframe.setBounds(100, 100, 449, 179);
		Deleteframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Deleteframe.getContentPane().setLayout(null);
		
		
		JButton ConfirmWButton = new JButton("Confirm");
		ConfirmWButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ReWrite(CID);
					JOptionPane.showMessageDialog(ConfirmWButton,"Account deleted Successfully", "Confirmation Message",JOptionPane.WARNING_MESSAGE);
					Login l = new Login();
					l.Loginframe.setVisible(true);
			}
		});
		ConfirmWButton.setBounds(149, 55, 97, 25);
		Deleteframe.getContentPane().add(ConfirmWButton);
		
		JButton CancelWButton = new JButton("Cancel");
		CancelWButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deleteframe.dispose();
			}
		});
		CancelWButton.setBounds(258, 55, 97, 25);
		Deleteframe.getContentPane().add(CancelWButton);
	}
}
