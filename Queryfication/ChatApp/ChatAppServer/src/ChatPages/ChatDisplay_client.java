package ChatPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.*;
import java.io.*;

public class ChatDisplay_client extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JTextArea textArea;
	Socket socket;
    BufferedReader br;
    PrintWriter out;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatDisplay_client frame = new ChatDisplay_client();
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
	public ChatDisplay_client() {
		try{
            System.out.println("Sending request to server");
            socket = new Socket("127.0.0.1",7777);
            System.out.println("Connection Done.");

            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out= new PrintWriter(socket.getOutputStream());

            startReading();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 773);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173,20,87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173,20,87));
		panel.setBounds(0, 0, 825, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUERIFICATION");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 23, 268, 39);
		panel.add(lblNewLabel);
		
		JLabel lblServer = new JLabel("Client");
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setForeground(Color.WHITE);
		lblServer.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		lblServer.setBounds(563, 23, 161, 39);
		panel.add(lblServer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 92, 617, 514);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setBackground(new Color(233,30,99));
		
		textField = new JTextField();
		textField.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		textField.setBounds(105, 639, 526, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendbtn = new JButton("Send");
		sendbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = textField.getText();
				out.println(query);
				out.flush();
				textArea.append("Client  :   "+query+"\n");
				textField.setText("");
			}
		});
		sendbtn.setForeground(new Color(255, 255, 255));
		sendbtn.setBackground(new Color(233,30,99));
		sendbtn.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		sendbtn.setBounds(636, 639, 91, 56);
		contentPane.add(sendbtn);
	}
	
	 public void startReading() {
	        Runnable r1= () -> {
	            System.out.println("Reader Started");
	            try{
	            while(true)
	            {
	                
	                String msg = br.readLine();
	                if(msg.equals("exit"))
	                {
	                    System.out.println("Server terminated the chat");
	                    socket.close();
	                    break;
	                }
	                textArea.append("Server :   " + msg + "\n");
	                }
	                
	            }
	            catch(Exception e){
	                //e.printStackTrace();
	                System.out.println("connection is closed");
	            }

	        };
	        new Thread(r1).start();
	    }
	    
}
