import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class lastOne extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lastOne frame = new lastOne();
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
	private JTextField textField_1;
	Connection conn=null;
	
	public lastOne() {
		conn=SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Check-out");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(152, 16, 87, 16);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cash Payment");
		rdbtnNewRadioButton.setBounds(29, 59, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Credit Card");
		rdbtnNewRadioButton_1.setBounds(29, 221, 141, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		JButton btnNewButton = new JButton("Select");
		Image selectbutton = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(selectbutton));
		btnNewButton.setBounds(137, 303, 133, 35);
		contentPane.add(btnNewButton);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(24, 83, 398, 121);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
	
		
		JLabel lblNewLabel_1 = new JLabel("Total Due: ");
		lblNewLabel_1.setBounds(6, 26, 70, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cash Tendered:   $");
		lblNewLabel_2.setBounds(6, 6, 122, 16);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(125, 1, 99, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(116, 26, 98, 16);
		panel.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_4 = new JLabel("Change Due:  ");
		lblNewLabel_4.setBounds(6, 46, 88, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(116, 46, 61, 16);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JLabel lblNewLabel_6 = new JLabel("Check-out Successful!");
		lblNewLabel_6.setBounds(126, 99, 204, 16);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(29, 245, 378, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel_7 = new JLabel("CC Number:");
		lblNewLabel_7.setBounds(6, 6, 80, 16);
		panel_1.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 1, 182, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("XXXX-XXXX-XXXX");
		lblNewLabel_8.setBounds(114, 31, 118, 16);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Example:");
		lblNewLabel_9.setBounds(38, 31, 61, 16);
		panel_1.add(lblNewLabel_9);
		
		JButton btnNewButton_1 = new JButton("Submit");
		
		
		
		
		btnNewButton_1.setBounds(271, 1, 101, 29);
		panel_1.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("");
		Image backbutton = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(backbutton));
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EmpCheckOut es=new EmpCheckOut();
				es.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(6, 3, 71, 29);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("Log out");
		Image exit = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		button.setIcon(new ImageIcon(exit));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Initial i=new Initial();
				i.setVisible(true);
			}
		});
		button.setBounds(6, 303, 99, 35);
		contentPane.add(button);
		lblNewLabel_6.setVisible(false);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonGroup bg=new ButtonGroup();
				bg.add(rdbtnNewRadioButton);
				bg.add(rdbtnNewRadioButton_1);
				
				if(bg.getSelection()==null){
					JOptionPane.showMessageDialog(null, "Please select an option.");
				}else if(rdbtnNewRadioButton.isSelected()){
					panel.setVisible(true);
					
					try{
						String rmNum=EmpCheckOut.TField();
						
						int num=Integer.parseInt(rmNum);
						String query="Select * from Guests where roomnum = ?";
						
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setInt(1, num);
						ResultSet rs=pst.executeQuery();
						double total=rs.getDouble(9);
						
						String tots=Double.toString(total);
						
						
						
						
						lblNewLabel_3.setText("$ "+tots);
						JButton btnCheckout = new JButton("Check-Out");
						btnCheckout.setBounds(116, 68, 117, 29);
						panel.add(btnCheckout);
						
						btnCheckout.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String tend=textField.getText();
								double tend2=Double.parseDouble(tend);
								
								double change=tend2-total;
								
								String change2=Double.toString(change);
								
								lblNewLabel_5.setText("$ "+change2);
								lblNewLabel_5.setVisible(true);
								
								try{
									
									String room=EmpCheckOut.TField();
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
								lblNewLabel_6.setVisible(true);
								btnCheckout.setVisible(false);
								btnNewButton.setVisible(false);
								conn.close();
								
								
								}catch(Exception u){
									JOptionPane.showMessageDialog(null, "Err");
								}
							}
						});
						
						
					}catch(Exception h){
						JOptionPane.showMessageDialog(null, "Error");
					}
					
				}else{
					panel_1.setVisible(true);
					String tf=textField_1.getText();
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(tf.equals(null)){
								JOptionPane.showMessageDialog(null, "Please enter a valid number.");
							
						}else{
							
								
							
							try{
								
								String room=EmpCheckOut.TField();
							int num=Integer.parseInt(room);
							String query="Select * from Guests where roomnum = ?";
							PreparedStatement pst=conn.prepareStatement(query);
							pst.setInt(1, num);
							ResultSet rs=pst.executeQuery();
							String last=rs.getString(4);
							System.out.println(last);
						
						String q="UPDATE Rooms SET Avail=null WHERE RoomNum =(SELECT Roomnum FROM Rooms WHERE Avail=?)";
						PreparedStatement pst3=conn.prepareStatement(q);
						pst3.setString(1, last);
						pst3.execute();
						String query2="Delete from Guests where roomnum = ?";
						PreparedStatement pst2=conn.prepareStatement(query2);
						pst2.setInt(1, num);
						pst2.executeUpdate();
						btnNewButton.setVisible(false);
						btnNewButton_1.setVisible(false);
						JOptionPane.showMessageDialog(null, "Check-out Successful");
						
						conn.close();
							}catch(Exception r){
								JOptionPane.showMessageDialog(null, "Error");
							}
								}
						
						
							
						}
					});
					
				}
			}
		});
		
	}
}
