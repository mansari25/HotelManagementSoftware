import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JFormattedTextField.AbstractFormatter;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Booking extends JFrame {

	private JPanel contentPane;
	private JTextField fnametextF;
	private JTextField lastnameTfield;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
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
	/**
	 * 
	 */
	Connection conn=null;
	public Booking() {
		conn=SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Welcome " + logIn.getUser()+"!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(198, 6, 224, 20);
		contentPane.add(lblNewLabel);
		
		fnametextF = new JTextField();
		fnametextF.setBounds(121, 70, 130, 26);
		contentPane.add(fnametextF);
		fnametextF.setColumns(10);
		
		JLabel firstname = new JLabel("First Name*");
		firstname.setBounds(6, 75, 74, 16);
		contentPane.add(firstname);
		
		JLabel lastname = new JLabel("Last Name*");
		lastname.setBounds(6, 101, 74, 16);
		contentPane.add(lastname);
		
		lastnameTfield = new JTextField();
		lastnameTfield.setBounds(121, 96, 130, 26);
		contentPane.add(lastnameTfield);
		lastnameTfield.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 124, 160, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel ccnum = new JLabel("Credit Card Number");
		ccnum.setBounds(6, 129, 146, 16);
		contentPane.add(ccnum);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image card = new ImageIcon(this.getClass().getResource("/cardExample.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(card));
		lblNewLabel_2.setBounds(296, 87, 297, 63);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		
		dateChooser.setDateFormatString("dd MM yyyy");
		dateChooser.setBounds(132, 182, 119, 26);
		contentPane.add(dateChooser);
		

		JLabel lblNewLabel_3 = new JLabel("Check-In Date*");
		lblNewLabel_3.setBounds(6, 180, 101, 16);
		contentPane.add(lblNewLabel_3);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(132, 220, 119, 26);
		dateChooser_1.setDateFormatString("dd MM yyyy");
		contentPane.add(dateChooser_1);
		
		JLabel lblCheckoutDate = new JLabel("Check-Out Date*");
		lblCheckoutDate.setBounds(6, 232, 114, 16);
		contentPane.add(lblCheckoutDate);
		
		JLabel lblNewLabel_4 = new JLabel("Number of Guests*");
		lblNewLabel_4.setBounds(6, 392, 135, 16);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(130, 382, 48, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Number of Beds*");
		lblNewLabel_5.setBounds(6, 431, 135, 16);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 426, 48, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Book Reservation");
		Image book = new ImageIcon(this.getClass().getResource("/book.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(book));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		System.out.println("helo");
		
		btnNewButton.setBounds(306, 478, 211, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log Off");
		Image exit = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(exit));
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Initial i= new Initial();
				i.setVisible(true);
				try{
					conn.close();
				}catch(Exception g){
					
				}
			}
		});
		btnNewButton_1.setBounds(16, 478, 117, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel logo = new JLabel("");
		Image logo1 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logo.setIcon(new ImageIcon(logo1));
		logo.setBounds(6, 129, 558, 279);
		contentPane.add(logo);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(false);
				String fname=fnametextF.getText();
				String lname=lastnameTfield.getText();
				String credit=textField_2.getText();
				String numguests=textField.getText();
				int guests=Integer.parseInt(numguests);
				String numbeds=textField_1.getText();
				System.out.println("hello");
				int beds=Integer.parseInt(numbeds);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			    String date = sdf.format(dateChooser.getDate());
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
			    String date2= sdf2.format(dateChooser_1.getDate());
			 
			    
			    try{
			    	String user=logIn.getUser();
			    	String query="update Guests set firstname= ?, lastname=?, ccnum=?, ciDate=?, coDate=?, numGuests=? where username = ?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, fname);
					pst.setString(2, lname);
					pst.setString(3, credit);
					pst.setString(4, date);
					pst.setString(5, date2);
					pst.setInt(6, guests);
					pst.setString(7, user);
					pst.execute();	
					btnNewButton_1.setVisible(true);
					
					if(beds==1){
						String q2= "UPDATE Rooms SET Avail=? WHERE RoomNum =(SELECT Roomnum FROM Rooms WHERE Beds='1' and Avail is null ORDER BY Roomnum LIMIT 1)";
						PreparedStatement pst2=conn.prepareStatement(q2);
						pst2.setString(1, lname);
						pst2.execute();
						System.out.println("hwllo");
						String qry="select Roomnum from Rooms where Avail=?";
						PreparedStatement prep=conn.prepareStatement(qry);
						prep.setString(1, lname);
						System.out.println(lname);
						ResultSet rs=prep.executeQuery();
						System.out.println(rs.getInt(1));
						int Room=rs.getInt(1);
						
						System.out.println(Room);
						String q4="Update guests set roomnum=? where lastname=?";
						PreparedStatement prep2=conn.prepareStatement(q4);
						prep2.setInt(1, Room);
					
						prep2.setString(2, lname);
						prep2.execute();
						conn.close();
						
						
					}else if (beds==2){
						String q3= "UPDATE Rooms SET Avail=? WHERE RoomNum =(SELECT Roomnum FROM Rooms WHERE Beds='2' and Avail is null ORDER BY Roomnum LIMIT 1)";
						PreparedStatement pst3=conn.prepareStatement(q3);
						pst3.setString(1, lname);
						pst3.execute();
						
						String qry3="select Roomnum from Rooms where Avail=?";
						PreparedStatement prep3=conn.prepareStatement(qry3);
						prep3.setString(1, lname);
						
						ResultSet rs2=prep3.executeQuery();
						System.out.println(rs2.getInt(1));
						int Room=rs2.getInt(1);
						
						System.out.println(Room);
						String q5="Update guests set roomnum=? where lastname=?";
						PreparedStatement prep4=conn.prepareStatement(q5);
						prep4.setInt(1, Room);
					
						prep4.setString(2, lname);
						prep4.execute();
						conn.close();
						
					}else{
						JOptionPane.showMessageDialog(null, "Please enter one or two beds.");
					
					}
					
					JOptionPane.showMessageDialog(null, "Booking Sucessful!");
					
					
			    	
			    }catch(Exception f){
			    	JOptionPane.showMessageDialog(null, "Please fill out all the fields correctly.");
			    	
			    }
				
				
			}
		});
	
		
		
	
	}
}
