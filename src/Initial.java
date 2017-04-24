import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Initial extends JFrame {

	private JPanel contentPane;

	//main code for the program to create
	//and run the initial frame for class Initial
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initial frame = new Initial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creates the Initial class so it can be instantiated in the main 
	//program above.
	public Initial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 437);
		//Creates a new jpanel for everything to be displayed on.
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creates the Guest button and 
		//associates the action performed by it when you click it.
		JButton btnNewButton = new JButton("GUEST");
		Image guest = new ImageIcon(this.getClass().getResource("/guest.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(guest));
		btnNewButton.setFont(new Font("American Typewriter", Font.BOLD, 16));
		//when clicked it sets the visibility to false and 
		//instantiates a login class to be shown.
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				logIn lg=new logIn();
				lg.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(41, 301, 173, 62);
		contentPane.add(btnNewButton);
		
		//Creates the Employee button and 
		//associates the action performed by it when you click it.
		JButton btnEmployee = new JButton("EMPLOYEE");
		Image employee = new ImageIcon(this.getClass().getResource("/employee.png")).getImage();
		btnEmployee.setIcon(new ImageIcon(employee));
		btnEmployee.setFont(new Font("American Typewriter", Font.BOLD, 16));
		btnEmployee.setBackground(Color.DARK_GRAY);
		//when clicked it sets the visibility to false and 
		//instantiates a Employee class to be shown.
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Employee emp=new Employee();
				emp.setVisible(true);
				}
		});
		btnEmployee.setBounds(346, 301, 173, 62);
		contentPane.add(btnEmployee);
		
		JLabel logo = new JLabel("");
		Image logo1 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logo.setIcon(new ImageIcon(logo1));
		logo.setBounds(0, 0, 553, 273);
		contentPane.add(logo);
		
	}
}
