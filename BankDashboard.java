import java.awt.EventQueue;
import java.util.*;
import java.io.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class BankDashboard extends Load{

	public int CID;
	public JFrame BankMainframe;
	public String Username;
	private JTextField NameInfoField;
	private JTextField NIDInfoField;
	private JTextField AddressInfoField;
	private JTextField BalanceInfoField;
	public String fbalance,line,fnid,fuser,fpass,faddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	//				BankDashboard window = new BankDashboard();
		//			window.BankMainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public void set()
	{
		NameInfoField.setText(u[CID].sName);
		NIDInfoField.setText(u[CID].sNID);
		AddressInfoField.setText(u[CID].sAddress);
		BalanceInfoField.setText(""+u[CID].sBalance);
	}
	public void setBalance(double balance)
	{
		u[CID].sBalance = balance;
		BalanceInfoField.setText(""+u[CID].sBalance);
		//super.Show();
		Reload();
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public BankDashboard(String name, int cid) {
		Username = name;
		CID = cid;
		initialize();
		set();
		}
		/*try {
			String path = "C://Users//HP//eclipse-workspace//PROTYPE//src//info.txt";
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			boolean isLoginSuccess = false;
			
			while((line = br.readLine()) != null) {
				fuser = line.split(" ")[0];
				fpass = line.split(" ")[1];
				fnid = line.split(" ")[2];
				faddress = line.split(" ")[3];
				fbalance = line.split(" ")[4];
				if(fuser.equals(Username)) {
					NameInfoField.setText(fuser);
					NIDInfoField.setText(fnid);
					AddressInfoField.setText(faddress);
					BalanceInfoField.setText(fbalance);
				}
			}
			fr.close();
		}catch(Exception ep) {
			ep.printStackTrace();
	}*/
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BankMainframe = new JFrame("Welcome,"+Username);
		BankMainframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\79782932_3767576599922905_2993600181066268672_n.png"));
		BankMainframe.setBounds(100, 100, 568, 540);
		BankMainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BankMainframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(93, 13, 377, 39);
		BankMainframe.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(12, 88, 95, 16);
		BankMainframe.getContentPane().add(lblUsername);
		
		JLabel lblNid = new JLabel("NID:");
		lblNid.setBounds(12, 117, 56, 16);
		BankMainframe.getContentPane().add(lblNid);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 146, 56, 16);
		BankMainframe.getContentPane().add(lblAddress);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(12, 175, 56, 16);
		BankMainframe.getContentPane().add(lblBalance);
		
		NameInfoField = new JTextField();
		NameInfoField.setEditable(false);
		NameInfoField.setBounds(123, 85, 300, 22);
		BankMainframe.getContentPane().add(NameInfoField);
		NameInfoField.setColumns(10);
		
		NIDInfoField = new JTextField();
		NIDInfoField.setEditable(false);
		NIDInfoField.setBounds(123, 114, 300, 22);
		BankMainframe.getContentPane().add(NIDInfoField);
		NIDInfoField.setColumns(10);
		
		AddressInfoField = new JTextField();
		AddressInfoField.setEditable(false);
		AddressInfoField.setBounds(123, 143, 300, 22);
		BankMainframe.getContentPane().add(AddressInfoField);
		AddressInfoField.setColumns(10);
		
		BalanceInfoField = new JTextField();
		BalanceInfoField.setEditable(false);
		BalanceInfoField.setBounds(123, 172, 300, 22);
		BankMainframe.getContentPane().add(BalanceInfoField);
		BalanceInfoField.setColumns(10);
		
		JLabel lblOperations = new JLabel("Operations");
		lblOperations.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOperations.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperations.setBounds(230, 272, 107, 31);
		BankMainframe.getContentPane().add(lblOperations);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankMainframe.setVisible(false);
				DepositMenu depositmenu = new DepositMenu(u[CID].sName,CID);
				depositmenu.Depositframe.setVisible(true);
			}
		});
		btnDeposit.setBounds(230, 316, 107, 25);
		BankMainframe.getContentPane().add(btnDeposit);
		
		JButton btnWithdrawal = new JButton("Withdraw");
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankMainframe.setVisible(false);
				WithdrawMenu withdrawmenu = new WithdrawMenu(u[CID].sName,CID);
				withdrawmenu.Withdrawframe.setVisible(true);
				
			}
		});
		btnWithdrawal.setBounds(230, 354, 107, 25);
		BankMainframe.getContentPane().add(btnWithdrawal);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankMainframe.setVisible(false);
				DeleteMenu deletemenu = new DeleteMenu(u[CID].sName,CID);
				deletemenu.Deleteframe.setVisible(true);
				
			}
		});
		btnDeleteAccount.setBounds(205, 392, 153, 25);
		BankMainframe.getContentPane().add(btnDeleteAccount);
		
		
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankMainframe.setVisible(false);
				StartUp sup = new StartUp();
				String path = "C://Users//HP//eclipse-workspace//PROTYPE//src//info.txt";
				FileReader fr;
				try {
					fr = new FileReader(path);
					BufferedReader br = new BufferedReader(fr);
					fr.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sup.StartUpframe.setVisible(true);
			}
		});
		btnSignOut.setBounds(230, 430, 107, 25);
		BankMainframe.getContentPane().add(btnSignOut);
	}
}
