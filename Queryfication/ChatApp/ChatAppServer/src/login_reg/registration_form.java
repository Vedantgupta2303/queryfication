package login_reg;

import dbconnection.User_detail;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registration_form extends JFrame {
	private User_detail ud;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration_form frame = new registration_form();
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
	public registration_form() {
		ud=new User_detail();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 769);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233,30,99));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(173, 20, 87));
		panel.setBounds(0, 0, 687, 94);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("QUERYFICATION");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.BOLD, 35));
		lblNewLabel_1.setBounds(123, 10, 414, 74);
		panel.add(lblNewLabel_1);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setForeground(Color.WHITE);
		lblRegistration.setFont(new Font("Gill Sans MT", Font.BOLD, 36));
		lblRegistration.setBounds(208, 104, 224, 64);
		contentPane.add(lblRegistration);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(84, 218, 149, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Gill Sans MT", Font.PLAIN, 27));
		lblPassword.setBounds(84, 268, 149, 33);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_2_1 = new JLabel("Reg No.");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 27));
		lblNewLabel_2_1.setBounds(84, 315, 149, 33);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email Id");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 27));
		lblNewLabel_2_2.setBounds(84, 371, 149, 33);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Phone Number");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 27));
		lblNewLabel_2_2_1.setBounds(84, 424, 186, 33);
		contentPane.add(lblNewLabel_2_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField.setBounds(336, 218, 186, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 21));
		textField_1.setColumns(10);
		textField_1.setBounds(336, 322, 186, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(336, 371, 186, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(336, 431, 186, 32);
		contentPane.add(textField_3);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
		btnRegister.setBackground(new Color(173, 20, 87));
		btnRegister.setBounds(208, 525, 199, 43);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = textField.getText();
				String password = passwordField.getText();
				String regno = textField_1.getText();
				String phoneno = textField_2.getText();
				String email = textField_3.getText();
				register(e, name, password, regno, phoneno, email);
			}
		});


		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Gill Sans MT", Font.PLAIN, 21));
		passwordField.setBounds(336, 268, 186, 32);
		contentPane.add(passwordField);
	}
	private void register(ActionEvent e, String name, String password, String regno, String phoneno, String email) {
		ud.RegisterUser(name, password, regno, phoneno, email);
		LoginPage lp = new LoginPage();
		lp.setVisible(true);
		this.dispose();
		
		
	}
}