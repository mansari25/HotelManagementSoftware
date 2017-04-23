import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
public class logIn {

	public JFrame frame;
	public static JTextField uField;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;
	
	public static String getUser(){
		return uField.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn window = new logIn();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn=null;
	
	public logIn() {
		initialize();
		conn=SQLconnection.dbConnector();
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.GRAY);
		frame.setBounds(100, 100, 555, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel enter = new JPanel();
		enter.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(enter, "name_1569341282938");
		enter.setLayout(null);
		
		JLabel uName = new JLabel("Username:");
		uName.setBounds(16, 72, 82, 23);
		enter.add(uName);
		
		JLabel pWord = new JLabel("Password:");
		pWord.setBounds(302, 72, 82, 23);
		enter.add(pWord);
		
		uField = new JTextField();
		uField.setBounds(94, 70, 149, 26);
		enter.add(uField);
		uField.setColumns(10);
		
		JButton logIn = new JButton("Log In");
		Image check = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		logIn.setIcon(new ImageIcon(check));
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				String lgQuery= "select * from Guests where Username=? and Password=?";
				PreparedStatement pst=conn.prepareStatement(lgQuery);
				pst.setString(1, uField.getText());
				pst.setString(2, passwordField.getText());
				
				ResultSet rs=pst.executeQuery();
				
				int count=0;
				while(rs.next()){
					count++;;
					
				}
				if(count==1){
					JOptionPane.showMessageDialog(null, "Thank You. Your credentials are valid.");
					frame.dispose();
					GuestInfo gst=new GuestInfo();
					gst.setVisible(true);
					
				}else if(count>1){
					JOptionPane.showMessageDialog(null, "I'm Sorry, there is a duplicate Username and Password.");
				}else{
					JOptionPane.showMessageDialog(null, "Your credentials are incorrect. Please try again.");
				}
				rs.close();
				pst.close();
					
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		logIn.setBackground(Color.YELLOW);
		
		logIn.setBounds(179, 385, 190, 39);
		enter.add(logIn);
		
		
		lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblNewLabel.setBounds(248, 22, 78, 39);
		enter.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(382, 70, 149, 26);
		enter.add(passwordField);
		
		JButton btnCreateUsername = new JButton("Create User");
		Image user = new ImageIcon(this.getClass().getResource("/guest.png")).getImage();
		btnCreateUsername.setIcon(new ImageIcon(user));
		btnCreateUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				nameNpass nnp=new nameNpass();
				nnp.setVisible(true);
				
			}
		});
		btnCreateUsername.setBackground(Color.YELLOW);
		btnCreateUsername.setBounds(179, 452, 194, 39);
		enter.add(btnCreateUsername);
		
		JLabel lblNewLabel_1 = new JLabel("OR");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setBounds(266, 436, 61, 16);
		enter.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		Image backbutton = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(backbutton));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Initial i=new Initial();
				i.setVisible(true);
			}
		});
		btnNewButton.setBounds(6, 6, 82, 29);
		enter.add(btnNewButton);
		
		JLabel logo = new JLabel("");
		Image logo1 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logo.setIcon(new ImageIcon(logo1));
		logo.setBounds(0, 114, 555, 268);
		enter.add(logo);
	}
}
