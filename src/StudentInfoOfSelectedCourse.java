import java.awt.EventQueue;

import javax.swing.JFrame;

import Models.Course;
import Models.Student;
import Models.Tutor;
import data.Data;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JList;



public class StudentInfoOfSelectedCourse {
	int match = matchTutorStudent();
	private JFrame frame;
	private Tutor tutor;
	private String courseName;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public StudentInfoOfSelectedCourse(Tutor tutor, String courseName) {
		this.tutor = tutor;
		this.courseName = courseName;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(tutor.getTutor_name() + " -- " + courseName + " Students");
		lblNewLabel.setBounds(22, 6, 272, 36);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("← Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(6, 375, 141, 36);
		panel.add(btnNewButton);
		
		DefaultListModel ModelStudentList = new DefaultListModel();
		JList StudentList = new JList(ModelStudentList);
		StudentList.setBounds(53, 54, 141, 296);
		panel.add(StudentList);
		//System.out.println(tutor.getStudents());
		
		ArrayList<Student> studentListReal = new ArrayList<Student>();
		
		for(HashMap.Entry< Course, ArrayList<Student>> entry : tutor.getStudents().entrySet()) {
			Course course = (entry.getKey());
			int indd = 0;
			ArrayList<Student> studentList = (entry.getValue());
			if(course.getCourse_name().equals(courseName)) {
				ModelStudentList.add(indd, studentList.get(0).getName());
				indd ++;
				
				
			}
			
			
			
		}
		
		
	}
	public static int matchTutorStudent() {
		for(Course course : Data.courseList) {
			for (Student student : course.getStudents() ) {
				ArrayList<Student> studentss = new ArrayList<Student>();
				studentss.add(student);
				int tutorInd = new Random().nextInt(3);
				course.getTutors().get(tutorInd).getStudents().put(course, studentss);
			}
		}
		return 1;
	}

}
