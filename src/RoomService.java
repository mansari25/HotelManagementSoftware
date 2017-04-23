import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class RoomService extends JFrame {

	private JPanel contentPane;
	private int total;
	 
	 
          
      
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomService frame = new RoomService();
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
	public RoomService() {
		conn=SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("hello");
		setBounds(100, 100, 622, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel totalLabel = new JLabel("");
		totalLabel.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		totalLabel.setBounds(235, 319, 150, 16);
		contentPane.add(totalLabel);
		
		
		
		  ActionListener actionListener = new ActionListener() {
	          
	            public void actionPerformed(ActionEvent e) {
	                JCheckBox checkBox = (JCheckBox)e.getSource();
	                int value = (int) checkBox.getClientProperty("price");
	                if(checkBox.isSelected()){
	                	total=total+value;
	                }else{
	                	total=total-value;
	                }
	               
	                System.out.println(total);
	                StringBuilder sb = new StringBuilder("Total: ").append("$"+total+".00");
	                totalLabel.setText(sb.toString());
	               
	            }
	        };
		
		JLabel lblNewLabel = new JLabel("Room Service Menu");
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		lblNewLabel.setBounds(193, 8, 227, 23);
		contentPane.add(lblNewLabel);
		System.out.println("hello");
		JCheckBox sprite = new JCheckBox("Sprite   ($2.00)");
		sprite.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		sprite.setBounds(30, 102, 159, 23);
		contentPane.add(sprite);
		System.out.println("hello");
		sprite.addActionListener(actionListener);
		sprite.putClientProperty("price", (int)2);
		System.out.println("hello");
		JCheckBox coke = new JCheckBox("Coke    ($2.00)");
		coke.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		coke.setBounds(30, 279, 159, 23);
		coke.addActionListener(actionListener);
		contentPane.add(coke);
		coke.putClientProperty("price", (int)2);
		
		JLabel lblNewLabel_1 = new JLabel("Beverages");
		lblNewLabel_1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		lblNewLabel_1.setBounds(51, 61, 102, 23);
		contentPane.add(lblNewLabel_1);
		
		
		JCheckBox DC = new JCheckBox("Diet Coke   ($2.00)");
		DC.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		DC.setBounds(30, 137, 159, 23);
		contentPane.add(DC);
		DC.addActionListener(actionListener);
		DC.putClientProperty("price", (int)2); 
		
		JCheckBox BL = new JCheckBox("Bud Light   ($4.00)");
		BL.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		BL.setBounds(30, 172, 170, 23);
		contentPane.add(BL);
		BL.addActionListener(actionListener);
		BL.putClientProperty("price", (int)4);
		
		JCheckBox WW = new JCheckBox("White Wine   ($5.00)");
		WW.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		WW.setBounds(30, 208, 185, 23);
		contentPane.add(WW);
		WW.addActionListener(actionListener);
		WW.putClientProperty("price", (int)5);
		
		JCheckBox RW = new JCheckBox("Red Wine  ($5.00)");
		RW.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		RW.setBounds(30, 244, 170, 23);
		contentPane.add(RW);
		RW.addActionListener(actionListener);
		RW.putClientProperty("price", (int)5);
		
		JLabel lblSnacks = new JLabel("Snacks");
		lblSnacks.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		lblSnacks.setBounds(252, 64, 75, 20);
		contentPane.add(lblSnacks);
		
		
		JCheckBox Chips = new JCheckBox("Chips  ($2.00)");
		Chips.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		Chips.setBounds(225, 279, 128, 23);
		contentPane.add(Chips);
		Chips.addActionListener(actionListener);
		Chips.putClientProperty("price", (int)2);
		
		JCheckBox Cookies = new JCheckBox("Cookies  ($1.00)");
		Cookies.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		Cookies.setBounds(225, 102, 145, 23);
		contentPane.add(Cookies);
		Cookies.addActionListener(actionListener);
	    Cookies.putClientProperty("price", (int)1);
		
		JCheckBox PC = new JCheckBox("Popcorn ($2.00)");
		PC.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		PC.setBounds(225, 137, 145, 23);
		contentPane.add(PC);
		PC.addActionListener(actionListener);
		PC.putClientProperty("price", (int)2);
		
		JCheckBox fries = new JCheckBox("Fries  ($3.00)");
		fries.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		fries.setBounds(225, 172, 128, 23);
		contentPane.add(fries);
		fries.addActionListener(actionListener);
		fries.putClientProperty("price", (int)3);
		
		JCheckBox chicktend = new JCheckBox("Chicken Tenders ($4.00)");
		chicktend.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		chicktend.setBounds(225, 208, 195, 23);
		contentPane.add(chicktend);
		chicktend.addActionListener(actionListener);
		chicktend.putClientProperty("price", (int)4);
		
		JCheckBox FS = new JCheckBox("Fruit Salad ($4.00)");
		FS.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		FS.setBounds(225, 244, 170, 23);
		contentPane.add(FS);
		FS.addActionListener(actionListener);
		FS.putClientProperty("price", (int)4);
		
		JCheckBox pizza = new JCheckBox("Pizza  ($7.00)");
		pizza.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		pizza.setBounds(422, 208, 128, 23);
		contentPane.add(pizza);
		pizza.addActionListener(actionListener);
		pizza.putClientProperty("price", (int)7);
		
		JLabel lblNewLabel_2 = new JLabel("Entrees");
		lblNewLabel_2.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		lblNewLabel_2.setBounds(446, 64, 61, 20);
		contentPane.add(lblNewLabel_2);
		
		
		JCheckBox ham = new JCheckBox("Hamburger  ($6.00)");
		ham.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		ham.setBounds(425, 102, 191, 23);
		contentPane.add(ham);
		ham.addActionListener(actionListener);
		ham.putClientProperty("price", (int)6);
		
		JCheckBox Nachos = new JCheckBox("Nachos ($6.00)");
		Nachos.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		Nachos.setBounds(425, 137, 170, 23);
		contentPane.add(Nachos);
		Nachos.addActionListener(actionListener);
		Nachos.putClientProperty("price", (int)6);
		
		JCheckBox salad= new JCheckBox("Salad  ($6.00)");
		salad.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		salad.setBounds(425, 172, 128, 23);
		contentPane.add(salad);
		salad.addActionListener(actionListener);
		salad.putClientProperty("price", (int)6);
		
		JButton btnNewButton = new JButton("Log Out");
		Image exit = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(exit));
		btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		btnNewButton.setBounds(225, 388, 117, 36);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Initial in=new Initial();
				in.setVisible(true);
			}
		});
	      
		
		JButton Order = new JButton("Place Order");
		Image ok = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		Order.setIcon(new ImageIcon(ok));
		Order.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		Order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String user=logIn.getUser();
					String query="Select * from Guests where username = ?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, user);
					
					ResultSet rs=pst.executeQuery();
				
					int tots=rs.getInt(9);
					total=tots+total;
					System.out.println(total);
				
					String query2="Update Guests set totaldue=? where username=?";
					PreparedStatement pst2=conn.prepareStatement(query2);
					System.out.println("jjjuuu");
					pst2.setInt(1, total);
					System.out.println("jjjff");
					pst2.setString(2, user);
					System.out.println("jjjrrr");
					pst2.execute();
					System.out.println("jjjiii");
					Order.setVisible(false);
					btnNewButton.setVisible(true);
					try{
						conn.close();
					}catch(Exception h){
						JOptionPane.showMessageDialog(null, "Error");
					}
					JOptionPane.showMessageDialog(null, "Your order has been sucessfully sent!" );
				}catch(Exception g){
					JOptionPane.showMessageDialog(null, "Error");
					
				}
			}
		});
		Order.setBounds(193, 347, 177, 29);
		contentPane.add(Order);
		
		JButton backButton = new JButton("");
		Image backbutton1 = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		backButton.setIcon(new ImageIcon(backbutton1));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backButton.setFont(new Font("American Typewriter", Font.PLAIN, 9));
		backButton.setBounds(6, 8, 67, 21);
		contentPane.add(backButton);
		
	

		
		
	}
}
