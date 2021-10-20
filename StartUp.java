import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class StartUp {

	public JFrame StartUpframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUp window = new StartUp();
					window.StartUpframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		StartUpframe = new JFrame();
		StartUpframe.setForeground(Color.RED);
		StartUpframe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		StartUpframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\79782932_3767576599922905_2993600181066268672_n.png"));
		StartUpframe.setResizable(false);
		StartUpframe.getContentPane().setBackground(Color.WHITE);
		StartUpframe.setBackground(Color.BLACK);
		StartUpframe.setTitle("TAT Banking System");
		StartUpframe.getContentPane().setForeground(Color.BLACK);
		StartUpframe.setBounds(100, 100, 599, 449);
		StartUpframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StartUpframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\79782932_3767576599922905_2993600181066268672_n.png"));
		lblNewLabel.setBounds(192, 13, 198, 178);
		StartUpframe.getContentPane().add(lblNewLabel);
		
		JButton btnStart = new JButton("Start ");
		btnStart.setBackground(Color.GREEN);
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login sup = new Login();
				StartUpframe.setVisible(false);
				sup.Loginframe.setVisible(true);
			}
		});
		btnStart.setBounds(246, 285, 97, 25);
		StartUpframe.getContentPane().add(btnStart);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartUpframe.dispose();
			}
		});
		btnExit.setBounds(246, 323, 97, 25);
		StartUpframe.getContentPane().add(btnExit);
		
		JLabel lblWelcomeTo = new JLabel("WELCOME TO,");
		lblWelcomeTo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeTo.setBounds(228, 204, 145, 16);
		StartUpframe.getContentPane().add(lblWelcomeTo);
		
		JLabel lblTatBankingSystem = new JLabel("TAT BANKING SYSTEM");
		lblTatBankingSystem.setFont(new Font("Calibri", Font.BOLD, 40));
		lblTatBankingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTatBankingSystem.setBounds(115, 233, 372, 39);
		StartUpframe.getContentPane().add(lblTatBankingSystem);
	}
}
