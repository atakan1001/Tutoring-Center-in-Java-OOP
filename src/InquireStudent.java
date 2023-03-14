import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Models.Course;
import Models.Student;
import Models.Tutor;
import data.Data;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class InquireStudent {

	private JFrame frame;
	private Student student;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public InquireStudent(Student student) {
		this.student = student;
	
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 606, 469);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inquire " + student.getName());
		lblNewLabel.setBounds(6, 6, 189, 24);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("← Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(6, 434, 117, 29);
		panel.add(btnNewButton);
		
		DefaultListModel ModelPassed = new DefaultListModel();
		JList PassedCourses = new JList(ModelPassed);
		PassedCourses.setBounds(35, 101, 148, 321);
		panel.add(PassedCourses);
		
		JLabel lblNewLabel_1 = new JLabel("Passed Courses");
		lblNewLabel_1.setBounds(35, 60, 137, 24);
		panel.add(lblNewLabel_1);
		
		DefaultListModel ModelRegistered = new DefaultListModel();
		JList RegisteredCourses = new JList(ModelRegistered);
		RegisteredCourses.setBounds(237, 101, 137, 321);
		panel.add(RegisteredCourses);
		
		JLabel lblNewLabel_1_1 = new JLabel("Registered Courses");
		lblNewLabel_1_1.setBounds(237, 60, 137, 24);
		panel.add(lblNewLabel_1_1);
		
		int indStudent;
		int indTutor;
		
		for(Course course1 : student.getPassed_courses()) {
		
			ModelPassed.addElement(course1.getCourse_name());
		}
		for(Course course1 : Data.courseList) {
			if(course1.getStudents().contains(student) &&
					ModelPassed.contains(course1.getCourse_name()) == false)
				
				ModelRegistered.addElement(course1.getCourse_name());
		}
		
		
		
		
			
					
		
		
	}

}
