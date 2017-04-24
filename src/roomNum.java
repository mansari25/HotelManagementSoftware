import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class roomNum extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;

	public static String getUser() {
		return textField.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					roomNum frame = new roomNum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// creates a new db connection for the class.
	Connection conn = null;

	public roomNum() {
		// calls the SQLconnection dbConnector method.
		conn = SQLconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButtonBack = new JButton("");
		Image backbutton = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButtonBack.setIcon(new ImageIcon(backbutton));
		btnNewButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EmpSelection es = new EmpSelection();
				es.setVisible(true);
			}
		});
		btnNewButtonBack.setBounds(0, 6, 87, 29);
		contentPane.add(btnNewButtonBack);

		JLabel lblNewLabel = new JLabel("Guest's Room Number");
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 16));
		lblNewLabel.setBounds(122, 17, 186, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Please enter the Guest's Room Number:");
		lblNewLabel_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(6, 120, 275, 16);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(281, 115, 87, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		// This AL looks to see if there is a
		// guest in the room that is entered in the textFeild by the employee.
		// If there isn't there is a meesage thrown.
		JButton btnNewButton = new JButton("Order Room Service");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a room number.");
				} else {
					try {
						String query = "Select * from Rooms where roomnum=?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, textField.getText());
						ResultSet rs = pst.executeQuery();
						if (rs.getString(3).equals(null)) {
							JOptionPane.showMessageDialog(null, "Room Not Occupied");
						} else {
							setVisible(false);
							EmpRoomService ers = new EmpRoomService();
							ers.setVisible(true);

							try {
								conn.close();
							} catch (Exception h) {

							}
						}
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "Room Not Occupied");
					}

				}
			}
		});
		btnNewButton.setBounds(135, 197, 150, 29);
		contentPane.add(btnNewButton);
	}
}
