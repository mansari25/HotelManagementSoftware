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
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField.AbstractFormatter;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

public class EmpBooking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpBooking frame = new EmpBooking();
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
	private JTextField textField_3;
	private JTextField textField_4;
	public EmpBooking() {
		conn=SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		//lblNewLabel.setText("Welcome " + logIn.getUser()+"!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(130, 6, 224, 20);
		contentPane.add(lblNewLabel);
		
		JTextField fnametextF = new JTextField();
		fnametextF.setBounds(121, 70, 130, 26);
		contentPane.add(fnametextF);
		fnametextF.setColumns(10);
		
		JLabel firstname = new JLabel("First Name*");
		firstname.setBounds(6, 75, 74, 16);
		contentPane.add(firstname);
		
		JLabel lastname = new JLabel("Last Name*");
		lastname.setBounds(6, 101, 74, 16);
		contentPane.add(lastname);
		
		JTextField lastnameTfield = new JTextField();
		lastnameTfield.setBounds(121, 96, 130, 26);
		contentPane.add(lastnameTfield);
		lastnameTfield.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(181, 124, 160, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel ccnum = new JLabel("Credit Card Number");
		ccnum.setBounds(6, 129, 135, 16);
		contentPane.add(ccnum);
		
		JLabel lblNewLabel_2 = new JLabel("XXXX-XXXX-XXXX-XXXX");
		lblNewLabel_2.setBounds(191, 151, 181, 16);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(132, 182, 119, 26);
		contentPane.add(dateChooser);
		

		JLabel lblNewLabel_3 = new JLabel("Check-In Date*");
		lblNewLabel_3.setBounds(6, 192, 101, 16);
		contentPane.add(lblNewLabel_3);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(132, 220, 119, 26);
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooser_1);
		
		JLabel lblCheckoutDate = new JLabel("Check-Out Date*");
		lblCheckoutDate.setBounds(6, 230, 114, 16);
		contentPane.add(lblCheckoutDate);
		
		JLabel lblNewLabel_4 = new JLabel("Number of Guests*");
		lblNewLabel_4.setBounds(311, 179, 135, 16);
		contentPane.add(lblNewLabel_4);
		
		JTextField textField = new JTextField();
		textField.setBounds(458, 175, 48, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Number of Beds*");
		lblNewLabel_5.setBounds(311, 230, 135, 16);
		contentPane.add(lblNewLabel_5);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(458, 225, 48, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Book Reservation");
		Image book = new ImageIcon(this.getClass().getResource("/book.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(book));
		System.out.println("hello");
		
		btnNewButton.setBounds(153, 447, 211, 36);
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
		btnNewButton_1.setBounds(24, 447, 117, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Booking");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_1.setBounds(181, 6, 151, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Check-In Guest");
		Image ok = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(ok));
		btnNewButton_2.setVisible(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EmpCheckIn ec=new EmpCheckIn();
				ec.setVisible(true);
				try{
					conn.close();
				}catch(Exception m){
					
				}
				}
		});
		btnNewButton_2.setBounds(376, 447, 143, 36);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Username*");
		lblNewLabel_6.setBounds(6, 47, 74, 16);
		contentPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 42, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Password*");
		lblNewLabel_7.setBounds(263, 47, 74, 16);
		contentPane.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(340, 42, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel logo = new JLabel("");
		Image logo1 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logo.setIcon(new ImageIcon(logo1));
		logo.setBounds(-13, 165, 532, 298);
		contentPane.add(logo);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setVisible(true);
				btnNewButton.setVisible(false);
				btnNewButton_2.setVisible(true);
				String user=textField_3.getText();
				String password=textField_4.getText();
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
			    	
			    	String query="insert into Guests (username, password, firstname, lastname, ccnum, ciDate, coDate, numGuests) values (?,?,?,?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, user);
					pst.setString(2, password);
					
					pst.setString(3, fname);
					pst.setString(4, lname);
					pst.setString(5, credit);
					pst.setString(6, date);
					pst.setString(7, date2);
					pst.setInt(8, guests);
					
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
