import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Student;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DisplayStudentInformationPanel {

	private JFrame frame;
	private JTextField textFieldTCKN;
	static JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldBalance;
	private Student student;
	final static ArrayList<String> names = new ArrayList<String>();


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public DisplayStudentInformationPanel(Student student) {
		
		this.student = student;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TCKN: " + student.getTCKN());
		lblNewLabel.setBounds(18, 6, 186, 34);
		panel.add(lblNewLabel);
		
		textFieldTCKN = new JTextField();
		textFieldTCKN.setBounds(228, 10, 186, 26);
		panel.add(textFieldTCKN);
		textFieldTCKN.setColumns(10);
		
		JLabel lblEnterYourName = new JLabel("Name: " + student.getName());
		lblEnterYourName.setBounds(18, 76, 121, 34);
		panel.add(lblEnterYourName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(228, 80, 186, 26);
		panel.add(textFieldName);
		
		JLabel lblEnterYourAge = new JLabel("Age: " + student.getAge());
		lblEnterYourAge.setBounds(18, 144, 121, 34);
		panel.add(lblEnterYourAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(228, 148, 186, 26);
		panel.add(textFieldAge);
		
		JLabel lblEnterYour = new JLabel("Balance: " + student.getMonetary_balance() + "$");
		lblEnterYour.setBounds(18, 216, 145, 34);
		panel.add(lblEnterYour);
		
		textFieldBalance = new JTextField();
		textFieldBalance.setColumns(10);
		textFieldBalance.setBounds(228, 220, 186, 26);
		panel.add(textFieldBalance);
		
		JButton TCKNButton = new JButton("Change");
		TCKNButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.setTCKN(textFieldTCKN.getText());
				JOptionPane.showMessageDialog(frame, "TCKN of " + student.getName() + " is changed to " + textFieldTCKN.getText());
				

			}
		});
		TCKNButton.setBounds(327, 34, 117, 29);
		panel.add(TCKNButton);
		
		JButton NameButton = new JButton("Change");
		names.add(student.getName());
		NameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldName = student.getName();
				names.add(textFieldName.getText());
				student.setName(textFieldName.getText());
				JOptionPane.showMessageDialog(frame, "Name of " + oldName + " is changed to " + textFieldName.getText());
			}
		});
		NameButton.setBounds(327, 107, 117, 29);
		panel.add(NameButton);
		
		JButton AgeButton = new JButton("Change");
		AgeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.setAge(Integer.parseInt(textFieldAge.getText()));
				JOptionPane.showMessageDialog(frame, "Age of " + student.getName() + " is changed to " + textFieldAge.getText());
			}
		});
		AgeButton.setBounds(327, 172, 117, 29);
		panel.add(AgeButton);
		
		JButton BalanceButton = new JButton("Change");
		BalanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.setMonetary_balance(Integer.parseInt(textFieldBalance.getText()));
				JOptionPane.showMessageDialog(frame, "Balance of " + student.getName() + " is changed to " + textFieldBalance.getText());
			}
		});
		BalanceButton.setBounds(327, 246, 117, 29);
		panel.add(BalanceButton);
		
		JButton btnNewButton = new JButton("<html> ← Back to <br> Student Panel</html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(6, 262, 157, 42);
		panel.add(btnNewButton);
	}
}
