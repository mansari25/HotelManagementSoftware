import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class nameNpass extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nameNpass frame = new nameNpass();
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
	Connection conn=null;
	public nameNpass() {
		conn=SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 531);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose Username:");
		lblNewLabel.setBounds(48, 97, 133, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblCreatePassword = new JLabel("Create Password:");
		lblCreatePassword.setBounds(48, 126, 113, 23);
		contentPane.add(lblCreatePassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password:");
		lblReenterPassword.setBounds(48, 158, 133, 23);
		contentPane.add(lblReenterPassword);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(173, 95, 169, 26);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("");
		label.setBounds(158, 23, 61, 16);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Please Create A Username and Password:");
		lblNewLabel_1.setBounds(48, 51, 275, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Create User");
		Image user = new ImageIcon(this.getClass().getResource("/guest.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(user));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p1=passwordField_1.getText();
				String p2=passwordField.getText();

				if(p1.equals(p2)){
					try{
					String query="insert into Guests (UserName, Password) values (?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textField_2.getText());
					pst.setString(2, passwordField.getText());
					pst.execute();
					setVisible(false);
					logIn n = new logIn();
					n.frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Your Username has been created, please log in.");
					}catch(Exception f){
						JOptionPane.showMessageDialog(null, "This username already exists. Please choose another.");
					}
					
				
				}else{
					JOptionPane.showMessageDialog(null, "Passwords do no match. Please try again.");
				}
			}
		});
		btnNewButton.setBounds(143, 443, 226, 43);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 124, 169, 26);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(173, 156, 169, 26);
		contentPane.add(passwordField_1);
		
		JLabel logo = new JLabel("");
		Image logo1 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logo.setIcon(new ImageIcon(logo1));
		logo.setBounds(-17, 184, 541, 260);
		contentPane.add(logo);
	}

}
