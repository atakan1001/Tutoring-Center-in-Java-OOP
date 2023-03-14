import java.awt.EventQueue;

import javax.swing.JFrame;

import Models.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DisplayTutorInformationPanel {
	public static int constant = 0;
	private JFrame frame;
	private Tutor tutor;
	private JTextField NameTextField;
	private JTextField IDTextField;
	private JTextField BalanceTextField;
	final static ArrayList<String> names = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public DisplayTutorInformationPanel(Tutor tutor) {
		this.tutor = tutor;
		initialize();
		this.frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: " + tutor.getTutor_name());
		lblNewLabel.setBounds(22, 23, 166, 36);
		panel.add(lblNewLabel);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(289, 23, 225, 31);
		panel.add(NameTextField);
		NameTextField.setColumns(10);
		
		JButton NameButton = new JButton("Change");
		
		
		names.add(tutor.getTutor_name());
		
		NameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldName = names.get(0);
				tutor.setTutor_name(NameTextField.getText());
				names.add(NameTextField.getText());
				JOptionPane.showMessageDialog(frame, "Name of " + oldName + " is changed to " + NameTextField.getText());
				
			}
		});
		NameButton.setBounds(397, 60, 117, 29);
		panel.add(NameButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID: " + tutor.getID());
		lblNewLabel_1.setBounds(22, 119, 166, 36);
		panel.add(lblNewLabel_1);
		
		IDTextField = new JTextField();
		IDTextField.setColumns(10);
		IDTextField.setBounds(289, 124, 225, 31);
		panel.add(IDTextField);
		
		JButton IDButton = new JButton("Change");
		IDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutor.setID(Integer.parseInt(IDTextField.getText()));
				JOptionPane.showMessageDialog(frame, "ID of " + tutor.getTutor_name() + " is changed to " + IDTextField.getText());

			}
		});
		IDButton.setBounds(397, 155, 117, 29);
		panel.add(IDButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Balance: " + tutor.getMonetary_balance());
		lblNewLabel_1_1.setBounds(22, 219, 166, 36);
		panel.add(lblNewLabel_1_1);
		
		BalanceTextField = new JTextField();
		BalanceTextField.setColumns(10);
		BalanceTextField.setBounds(289, 224, 225, 31);
		panel.add(BalanceTextField);
		
		JButton BalanceButton = new JButton("Change");
		BalanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutor.setMonetary_balance(Integer.parseInt(BalanceTextField.getText()));
				JOptionPane.showMessageDialog(frame, "Balance of " + tutor.getTutor_name() + " is changed to " + BalanceTextField.getText());

			}
		});
		BalanceButton.setBounds(397, 254, 117, 29);
		panel.add(BalanceButton);
		
		JButton btnNewButton = new JButton("<html> ← Back to <br> Tutor Panel</html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(22, 374, 180, 42);
		panel.add(btnNewButton);
	}

	public static int getConstant() {
		return constant;
	}

	public static void setConstant(int constant) {
		DisplayTutorInformationPanel.constant = constant;
	}
	
}
