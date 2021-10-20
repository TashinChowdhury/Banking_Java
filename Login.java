import java.awt.EventQueue;
import java.io.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.SystemColor;

public class Login {

	public int CID=-1;
	public JFrame Loginframe;
	private JTextField UsernameField;
	private JPasswordField passwordField;
	public String line,fuser,fpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.Loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Loginframe = new JFrame();
		Loginframe.getContentPane().setBackground(new Color(224, 255, 255));
		Loginframe.setBackground(new Color(255, 255, 255));
		Loginframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\79782932_3767576599922905_2993600181066268672_n.png"));
		Loginframe.setForeground(Color.RED);
		Loginframe.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 16));
		Loginframe.getContentPane().setForeground(Color.BLACK);
		Loginframe.setTitle("TAT BANKING SYSTEM");
		Loginframe.setBounds(100, 100, 450, 300);
		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Loginframe.getContentPane().setLayout(null);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBackground(new Color(123, 104, 238));
		UsernameLabel.setBounds(45, 39, 82, 16);
		Loginframe.getContentPane().add(UsernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(45, 78, 82, 16);
		Loginframe.getContentPane().add(PasswordLabel);
		
		UsernameField = new JTextField();
		UsernameField.setToolTipText("Enter Your First name\r\n");
		UsernameField.setBounds(155, 36, 207, 22);
		Loginframe.getContentPane().add(UsernameField);
		UsernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter 3-digit Password");
		passwordField.setBounds(155, 75, 207, 22);
		Loginframe.getContentPane().add(passwordField);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.setBackground(new Color(0, 255, 127));
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = UsernameField.getText().toString();
				String pass = passwordField.getText().toString();
				
				try {
					String path = "C://Users//HP//eclipse-workspace//PROTYPE//src//info.txt";
					FileReader fr = new FileReader(path);
					BufferedReader br = new BufferedReader(fr);
					
					boolean isLoginSuccess = false;
					int i=-1;
					while((line = br.readLine()) != null) {
						fuser = line.split(" ")[0];
						fpass = line.split(" ")[1];
						++i;
						if(fuser.equals(name) && fpass.equals(pass)) {
							isLoginSuccess = true;
							CID = i;
							BankDashboard BM = new BankDashboard(name,CID);
							BM.BankMainframe.setVisible(true);
							Loginframe.setVisible(false);

						break;
						}
					}
					if(!isLoginSuccess) {
						JOptionPane.showMessageDialog(null,"Username or Password is INCORRECT!","WARNING!", JOptionPane.WARNING_MESSAGE);
					}
					fr.close();
				}
			
		catch(Exception ep){
				ep.printStackTrace();
			}
		}
	});
		LoginButton.setBounds(265, 110, 97, 25);
		Loginframe.getContentPane().add(LoginButton);
		
		JButton CreateAccountButton = new JButton("Create New Account");
		CreateAccountButton.setBackground(new Color(255, 127, 80));
		CreateAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateAccount ca = new CreateAccount();
				Loginframe.setVisible(false);
				ca.CAframe.setVisible(true);
			}
		});
		CreateAccountButton.setBounds(118, 195, 169, 25);
		Loginframe.getContentPane().add(CreateAccountButton);
		
		JLabel lblor = new JLabel("-----OR-----");
		lblor.setBounds(165, 166, 97, 16);
		Loginframe.getContentPane().add(lblor);
	}
}
