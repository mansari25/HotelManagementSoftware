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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Initial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("GUEST");
		Image guest = new ImageIcon(this.getClass().getResource("/guest.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(guest));
		btnNewButton.setFont(new Font("American Typewriter", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				logIn lg=new logIn();
				lg.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(41, 301, 173, 62);
		contentPane.add(btnNewButton);
		
		JButton btnEmployee = new JButton("EMPLOYEE");
		Image employee = new ImageIcon(this.getClass().getResource("/employee.png")).getImage();
		btnEmployee.setIcon(new ImageIcon(employee));
		btnEmployee.setFont(new Font("American Typewriter", Font.BOLD, 16));
		btnEmployee.setBackground(Color.DARK_GRAY);
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
