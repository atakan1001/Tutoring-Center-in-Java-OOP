import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Models.User;
import core.RoleType;
import data.Data;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class LoginPanel {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel window = new LoginPanel();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPanel() {
		
		initialize();
		this.frame.setVisible(true);
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(172, 15, 130, 26);
		userField.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(userField);
		userField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Login");
		frame.getRootPane().setDefaultButton(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				boolean isSuccess = false;
				String userName = userField.getText();
				String password = passwordField.getText();
				
				for (User user : Data.userList) {
					
					if(user.getPassword().equals(password) && user.getUserName().equals(userName)) {
						
						isSuccess = true;
						//frame.setVisible(false);
						if (user.getRole().equals(RoleType.STUDENT)) {
							JOptionPane.showMessageDialog(frame, "Welcome to Student Panel!");
							new StudentPanel(user);
							break;
						}
						else if (user.getRole().equals(RoleType.TUTOR)) {
							JOptionPane.showMessageDialog(frame, "Welcome to Tutor Panel!");
							new TutorPanel(user);
							break;
						}
						
						else if (user.getRole().equals(RoleType.ADMINISTRATOR)) {
							JOptionPane.showMessageDialog(frame, "Welcome to Admin Panel!");
							new AdminPanel(user);
							break;
						}
						
						
					
					}
				}
					
				if(!isSuccess){
					JOptionPane.showMessageDialog(frame, "No Such a User!");
					
				}
				
				
				
			}
		});
		btnNewButton.setBounds(109, 144, 256, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(91, 20, 72, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(91, 58, 72, 16);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 53, 130, 26);
		panel.add(passwordField);
		
		JButton btnSignup = new JButton("Sign-up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				new SignUpPanel();
			}
		});
		btnSignup.setBounds(109, 198, 256, 29);
		panel.add(btnSignup);
	}
}


