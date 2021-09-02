package login_reg;

import dbconnection.User_detail;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChatPages.ChatDisplay_server;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
	User_detail ud;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		ud = new User_detail();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233,30,99));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 36));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(159, 104, 224, 64);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(173,20,87));
		panel.setBounds(0, 0, 575, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("QUERYFICATION");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 35));
		lblNewLabel_1.setBounds(72, 10, 414, 74);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 26));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(97, 282, 144, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 26));
		lblNewLabel_2_1.setBounds(97, 342, 144, 36);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Gill Sans MT", Font.PLAIN, 19));
		textField.setBounds(318, 284, 180, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		passwordField.setBounds(318, 344, 180, 34);
		contentPane.add(passwordField);
		
		JButton Loginbtn = new JButton("Login");
		Loginbtn.setBackground(new Color(173,20,87));
		Loginbtn.setForeground(Color.WHITE);
		Loginbtn.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
		Loginbtn.setBounds(66, 449, 199, 43);
		contentPane.add(Loginbtn);
		Loginbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = textField.getText();
				String password = passwordField.getText();
				login(e, name, password);
				
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onclick(e);
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
		btnRegister.setBackground(new Color(173, 20, 87));
		btnRegister.setBounds(316, 449, 199, 43);
		contentPane.add(btnRegister);
	}
	protected void onclick(ActionEvent e) {
		registration_form rf = new registration_form();
		rf.setVisible(true);
		this.dispose();
		
	}

	private void login(ActionEvent e, String name, String password) {
		if(ud.LoginUser(name, password))
		{
			System.out.println(name+" this person logineed as server");
			ChatDisplay_server lp = new ChatDisplay_server(name);
			lp.setVisible(true);
			this.dispose();
		}
		
	}
}