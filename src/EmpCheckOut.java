import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpCheckOut extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static String TField(){
		return textField.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpCheckOut frame = new EmpCheckOut();
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
	public EmpCheckOut() {
		
		conn=SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check-Out");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(213, 18, 111, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Room Number:");
		lblNewLabel_1.setBounds(24, 83, 142, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(158, 81, 58, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Lookup Guest");
		Image search = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(search));
		btnNewButton.setBounds(325, 77, 193, 36);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(76, 285, 376, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setBounds(6, 27, 101, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name:");
		lblNewLabel_3.setBounds(6, 55, 101, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(63, 93, -53, 8);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Credit Card on file:");
		lblNewLabel_5.setBounds(6, 83, 130, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(93, 27, 61, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(93, 55, 61, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(135, 83, 61, 16);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Total Bill:   $");
		lblNewLabel_9.setBounds(6, 111, 92, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(93, 111, 61, 16);
		panel.add(lblNewLabel_10);
		
		JButton btnNewButton_1 = new JButton("Use Card on File");
		Image credit = new ImageIcon(this.getClass().getResource("/credit.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(credit));
		btnNewButton_1.setVisible(false);
		
		btnNewButton_1.setBounds(93, 124, 156, 44);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_11 = new JLabel("Check-out Successful!");
		lblNewLabel_11.setBounds(93, 166, 149, 16);
		panel.add(lblNewLabel_11);
		lblNewLabel_11.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Proceed with Check-out");
		Image check = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(check));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				conn.close();
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, "Err");
				}
				setVisible(false);
				lastOne lo=new lastOne();
				lo.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(333, 491, 185, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log Off");
		Image exit = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(exit));
		btnNewButton_3.setVisible(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Initial i=new Initial();
				i.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(6, 491, 117, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		Image backbutton = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(backbutton));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EmpSelection es=new EmpSelection();
				es.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(6, 6, 82, 29);
		contentPane.add(btnNewButton_4);
		
		JLabel logo = new JLabel("");
		Image logo1 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logo.setIcon(new ImageIcon(logo1));
		logo.setBounds(-17, 47, 551, 238);
		contentPane.add(logo);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				String rmNum=textField.getText();
				int num=Integer.parseInt(rmNum);
				String query="Select * from Guests where roomnum = ?";
				PreparedStatement pst=conn.prepareStatement(query);
				pst.setInt(1, num);
				ResultSet rs=pst.executeQuery();
				
				String first=rs.getString(3);
				String last=rs.getString(4);
				String cc=rs.getString(11);
				double bill=rs.getDouble(9);
				String bill2= Double.toString(bill);
				lblNewLabel_6.setText(first);
				lblNewLabel_7.setText(last);
				if(cc != null){
					lblNewLabel_8.setText("YES");
					btnNewButton_1.setVisible(true);
				}else{
					lblNewLabel_8.setText("NO");
				}
				lblNewLabel_10.setText(bill2+"0");
				
				panel.setVisible(true);
				
				}catch (Exception h){
					JOptionPane.showMessageDialog(null, "Room not Found!");
					
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String room=textField.getText();
					int num=Integer.parseInt(room);
					String query="Select * from Guests where roomnum = ?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setInt(1, num);
					ResultSet rs=pst.executeQuery();
					String last=rs.getString(4);
				
				String q="UPDATE Rooms SET Avail=null WHERE RoomNum =(SELECT Roomnum FROM Rooms WHERE Avail=?)";
				PreparedStatement pst3=conn.prepareStatement(q);
				pst3.setString(1, last);
				pst3.execute();
				String query2="Delete from Guests where roomnum = ?";
				PreparedStatement pst2=conn.prepareStatement(query2);
				pst2.setInt(1, num);
				pst2.executeUpdate();
				btnNewButton_1.setVisible(false);
				lblNewLabel_11.setVisible(true);
				btnNewButton_3.setVisible(true);
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, "Cannot check out guest!");
				}
			}
		});
	}
}
