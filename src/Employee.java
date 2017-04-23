import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employee extends JFrame {

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
					Employee frame = new Employee();
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
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		Image backbutton = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(backbutton));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Initial i=new Initial();
				i.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 6, 87, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(21, 85, 87, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(21, 131, 87, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(108, 80, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(108, 126, 130, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		Image check = new ImageIcon(this.getClass().getResource("check.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(check));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textField.getText();
				String pword=passwordField.getText();
				if(user.equals("Admin")&&pword.equals("Admin")){
					setVisible(false);
					EmpSelection es=new EmpSelection();
					es.setVisible(true);
					
				}
			}
		});
		btnNewButton_1.setBounds(202, 389, 165, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Login");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(210, 34, 140, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel logo = new JLabel("");
		Image logo1 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logo.setIcon(new ImageIcon(logo1));
		logo.setBounds(6, 124, 553, 274);
		contentPane.add(logo);
	}
}
