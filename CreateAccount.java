import java.awt.EventQueue;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CreateAccount extends Processing{
	
	public JFrame CAframe;
	private JTextField CAUsername;
	private JTextField CANID;
	private JTextField CAAddress;
	private JTextField CAInitialDeposit;
	private JTextField CAPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
					window.CAframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CAframe = new JFrame();
		CAframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\79782932_3767576599922905_2993600181066268672_n.png"));
		CAframe.setBounds(100, 100, 575, 481);
		CAframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CAframe.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 41, 102, 16);
		CAframe.getContentPane().add(lblUsername);
		
		JLabel lblNid = new JLabel("NID");
		lblNid.setBounds(12, 70, 102, 16);
		CAframe.getContentPane().add(lblNid);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(12, 103, 102, 16);
		CAframe.getContentPane().add(lblAddress);
		
		JLabel lblInitialDeposit = new JLabel("Initial Deposit");
		lblInitialDeposit.setBounds(12, 155, 102, 16);
		CAframe.getContentPane().add(lblInitialDeposit);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 184, 102, 16);
		CAframe.getContentPane().add(lblPassword);
		
		CAUsername = new JTextField();
		CAUsername.setBounds(151, 38, 116, 22);
		CAframe.getContentPane().add(CAUsername);
		CAUsername.setColumns(10);
		
		CANID = new JTextField();
		CANID.setBounds(151, 67, 116, 22);
		CAframe.getContentPane().add(CANID);
		CANID.setColumns(10);
		
		CAAddress = new JTextField();
		CAAddress.setBounds(151, 100, 116, 22);
		CAframe.getContentPane().add(CAAddress);
		CAAddress.setColumns(10);
		
		CAInitialDeposit = new JTextField();
		CAInitialDeposit.setBounds(151, 152, 116, 22);
		CAframe.getContentPane().add(CAInitialDeposit);
		CAInitialDeposit.setColumns(10);
		
		CAPasswordField = new JTextField();
		CAPasswordField.setBounds(151, 181, 116, 22);
		CAframe.getContentPane().add(CAPasswordField);
		CAPasswordField.setColumns(10);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String path = "C://Users//HP//eclipse-workspace//PROTYPE//src//info.txt";
					FileWriter myWriter = new FileWriter("C://Users//HP//eclipse-workspace//PROTYPE//src//info.txt",true);
					
					myWriter.write(CAUsername.getText()+" "+CAPasswordField.getText()+" "+CANID.getText()+" "+CAAddress.getText()+" "+CAInitialDeposit.getText()+"\n");
					myWriter.close();
					
					if(true) {
						JOptionPane.showMessageDialog(null,"Account Created Successfully!","Confirmation",JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(IOException ep){
					System.out.println("MISSING INFO! 404! ERROR!");
					ep.printStackTrace();
				}
				Login bank = new Login();
				bank.Loginframe.setVisible(true);
				CAframe.setVisible(false);
			}
		});
		btnCreateAccount.setBounds(151, 241, 156, 25);
		CAframe.getContentPane().add(btnCreateAccount);
	}
}
