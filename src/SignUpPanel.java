import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

import Models.User;
import core.RoleType;
import data.Data;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpPanel {

	private JFrame frame;
	private JTextField UsernameField;
	private JTextField PasswordField1;
	private JTextField PasswordField2;
	
	JRadioButton rdbtnStudent;
	JRadioButton rdbtnTutor;
	JRadioButton rdbtnAdministrator;
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public SignUpPanel() {
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
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUserName(UsernameField.getText());
				
				
				
				
				if(rdbtnStudent.isSelected()) {	
					user.setRole(RoleType.STUDENT);
				}
				
				else if(rdbtnTutor.isSelected()) {
					
					user.setRole(RoleType.TUTOR);
					
				}
				else {
					user.setRole(RoleType.ADMINISTRATOR);
				}
				
				
				if(PasswordField1.getText().equals(PasswordField2.getText())) {
					user.setPassword(PasswordField1.getText());
					String str = ("You Registered as " + user.getRole());
					JOptionPane.showMessageDialog(frame, str);

				}
				else {
					JOptionPane.showMessageDialog(frame, "Passwords do not match!");
					return;
				}
				
				Data.userList.add(user);
				
				frame.dispose();
				new LoginPanel();
				
				
			}
		});
		btnRegister.setBounds(177, 217, 117, 29);
		panel.add(btnRegister);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(164, 19, 130, 26);
		panel.add(UsernameField);
		UsernameField.setColumns(10);
		
		PasswordField1 = new JTextField();
		PasswordField1.setBounds(164, 73, 130, 26);
		panel.add(PasswordField1);
		PasswordField1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(29, 24, 102, 16);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(29, 78, 102, 16);
		panel.add(lblPassword);
		
		PasswordField2 = new JTextField();
		PasswordField2.setBounds(164, 122, 130, 26);
		panel.add(PasswordField2);
		PasswordField2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password Again");
		lblNewLabel_1.setBounds(29, 127, 102, 16);
		panel.add(lblNewLabel_1);
		
	
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(6, 189, 141, 23);
		panel.add(rdbtnStudent);
		
		rdbtnTutor = new JRadioButton("Tutor");
		rdbtnTutor.setBounds(142, 189, 141, 23);
		panel.add(rdbtnTutor);
		
		rdbtnAdministrator = new JRadioButton("Administrator");
		rdbtnAdministrator.setBounds(303, 189, 141, 23);
		panel.add(rdbtnAdministrator);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnStudent);
		group.add(rdbtnAdministrator);
		group.add(rdbtnTutor);
		
		btnNewButton = new JButton("← Back to");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(14, 237, 117, 29);
		panel.add(btnNewButton);
		
	}
	
	

	
	
}
