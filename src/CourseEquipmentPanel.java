import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Models.Course;
import Models.Equipment;
import Models.Student;
import data.Data;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseEquipmentPanel {

	private JFrame frame;
	private JFrame frame1;
	private String courseName;
	private Student student;
	protected Integer tot;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CourseEquipmentPanel(Student student ,String courseName) {
		this.courseName = courseName;
		this.student = student;
		initialize();
		
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 322, 272);
		frame.getContentPane().add(panel);
		
		
		DefaultListModel ModelEquipments = new DefaultListModel();
		JList CourseEquipments = new JList(ModelEquipments);
		CourseEquipments.setBounds(29, 60, 237, 131);
		int totalCost = 0;
		
		for(Course course: Data.courseList) {
			if (course.getCourse_name().equals(courseName)) {
				int count = 0;
				
				for(Equipment equipment : course.getReq_equipments()) {
					
					if(ModelEquipments.contains(equipment.getName() + " " + equipment.getPrice() + "$ ") == false) {
						ModelEquipments.add(count, "" + equipment.getName() + " " + equipment.getPrice() + "$ ");
						count ++;
						totalCost += equipment.getPrice();
					}
					
				}
				tot = totalCost;
				
			}
		}
		panel.setLayout(null);
		panel.add(CourseEquipments);
		panel.add(CourseEquipments);
		
		JButton btnNewButton = new JButton("Buy All (" + totalCost + "$)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.setMonetary_balance(student.getMonetary_balance() - tot);
				//SwingUtilities.updateComponentTreeUI(StudentPanel.getFrame());

				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(19, 203, 145, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Required Equipments");
		lblNewLabel.setBounds(29, 22, 221, 42);
		panel.add(lblNewLabel);
		
	
	}
}
