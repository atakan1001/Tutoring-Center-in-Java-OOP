import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Models.Course;
import Models.Student;
import Models.Tutor;
import Models.User;
import data.Data;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JList;

public class AdminPanel {

	private JFrame frame;
	private User admin;
	private JTextField StudentNameText;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AdminPanel(User admin) {
		this.admin = admin;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 596, 595);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(admin.getUserName() + "'s Admin Panel");
		lblNewLabel.setBounds(21, 6, 182, 51);
		panel.add(lblNewLabel);
		
		JButton NewCourseButton = new JButton("Add New Course");
		NewCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCourse();
			}
		});
		NewCourseButton.setBounds(17, 55, 120, 35);
		panel.add(NewCourseButton);
		
		DefaultListModel ModelCourse = new DefaultListModel();
		final JList CourseList = new JList(ModelCourse);
		CourseList.setBounds(303, 6, 287, 295);
		panel.add(CourseList);
		int in = 0;
		for(Course course1 : Data.courseList) {
			ModelCourse.add(in, course1.getCourse_name());
			in ++;
		}
		JButton btnNewButton_1 = new JButton("<html>Select a Course <br >to Display Students <br >Registered</html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int constant = 0;
				for(Course coursee : Data.courseList) {
					if(coursee.getCourse_name().equals(CourseList.getSelectedValue().toString()) == true) {
						new DispStudentsInCourse(coursee);
						constant = 1;
					}
				}
				
				if (constant == 0) {
					JOptionPane.showMessageDialog(frame, "No Such a Course");
					SwingUtilities.updateComponentTreeUI(frame);
				}
			}
		});
		btnNewButton_1.setBounds(301, 313, 150, 70);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html>Select a Course <br >to Display Tutors' <br >Schedules</html>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Course coursee1 : Data.courseList) {
					if(coursee1.getCourse_name().equals(CourseList.getSelectedValue().toString()) == true) {
						new TutorSchedules(coursee1);
						
					}
				}
				
			}
		});
		btnNewButton_2.setBounds(449, 313, 141, 70);
		panel.add(btnNewButton_2);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Write Student Name:");
		lblNewLabel_1.setBounds(21, 102, 139, 35);
		panel.add(lblNewLabel_1);
		
		StudentNameText = new JTextField();
		StudentNameText.setBounds(161, 106, 130, 26);
		panel.add(StudentNameText);
		StudentNameText.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("<html> Inquire the Student </html> ");
		btnNewButton_3.setBounds(161, 130, 130, 35);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Incomes of Tutors");
		lblNewLabel_2.setBounds(21, 295, 130, 16);
		panel.add(lblNewLabel_2);
		
		
		
		JButton btnNewButton = new JButton("← Go Back");
		btnNewButton.setBounds(27, 554, 150, 35);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = 0;
				for(Student student1 : Data.studentList) {
					if(student1.getName().equals(StudentNameText.getText()) == true) {
						res = 1;
						new InquireStudent(student1);

					}
						
				}
				if (res == 0)
					JOptionPane.showMessageDialog(frame, "No Such a Student!");
	
			}
		});
		DefaultListModel ModelIncome = new DefaultListModel();
		JList IncomeList = new JList(ModelIncome);
		IncomeList.setBounds(17, 324, 160, 218);
		panel.add(IncomeList);
		for(Tutor tutorr : Data.tutorList) {
			 double income =   (tutorr.getTutoring_cost() * (100.0 - tutorr.getTutor_percentage())/100.0 * (tutorr.getTime_schedules().keySet().size()));
			 String str = Double.toString(income);
			 int indxx = str.indexOf(".");
			 double incomeLast = Double.parseDouble(str.substring(0, indxx ));
			 ModelIncome.addElement(tutorr.getTutor_name() + "'s Income: " + (incomeLast));
		}
	}

}
