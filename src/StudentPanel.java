import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Models.Course;
import Models.Student;
import Models.User;
import data.Data;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class StudentPanel {

	private JFrame frame;
	
	private User user;
	private String name;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	
	public StudentPanel(User user) {
		this.user = user;
		initialize();
		
		this.frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 591, 497);
		frame.getContentPane().add(panel);
		
		DefaultListModel ModelPassed = new DefaultListModel();
		JList PassedCourses = new JList(ModelPassed);
		
		for (Student student : Data.studentList ) {
			if (student.getName().equals(user.getUserName())) {
				int i = 0;
				for(Course course : student.getPassed_courses()) {
					ModelPassed.add(i, course.getCourse_name());
					i = i+1;
				}
			
		 
		    }
		
		}
		
		final DefaultListModel ModelRegistered = new DefaultListModel();
		final JList RegisteredCourses = new JList(ModelRegistered);
		
		for (Student student : Data.studentList ) {
			if (student.getName().equals(user.getUserName())) {
				name = student.getName();
				int j = 0;
				for(Course course : Data.courseList) {
						if (course.getStudents().contains(student) ==  true && 
									ModelRegistered.contains(course.getCourse_name()) == false && 
										ModelPassed.contains(course.getCourse_name()) == false) {
							student.getRegistered_courses().add(course);
							ModelRegistered.add(j, course.getCourse_name());
							j = j+1;
							
						}
						
	
				}
			}
		}
		


		
		final DefaultListModel ModelAvailable = new DefaultListModel();
		final JList AvailableCourses = new JList(ModelAvailable);
		int indexOfStudent = 0;
		for(Student student: Data.studentList) {
			if (student.getName().equals(user.getUserName())) {
				indexOfStudent = Data.studentList.indexOf(student);
				int k = 0;
			
				for(Course course : Data.courseList) {
					if(student.getPassed_courses().contains(course) == false &&
							ModelAvailable.contains(course.getCourse_name()) == false &&
								ModelRegistered.contains(course.getCourse_name()) == false) {
								
						ModelAvailable.add(k, course.getCourse_name());
						k = k+1;
					}
				}
				
			}
		}
		
		int balance = Data.studentList.get(indexOfStudent).getMonetary_balance();
		final JLabel Balance = new JLabel("<html>Inıtial Balance: <br>" + Data.studentList.get(indexOfStudent).getMonetary_balance() + "$</html>");

		JButton btnNewButton = new JButton("<html>Drop<br>Selected<br>Courses</html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelAvailable.add(ModelAvailable.getSize(), RegisteredCourses.getSelectedValue());
				ModelRegistered.remove(RegisteredCourses.getSelectedIndex());
			}
		});
		
		JButton btnAddSelectedCourse = new JButton("<html>Add<br>Selected<br>Courses</html>");
		btnAddSelectedCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind = 0;
				for(Student student: Data.studentList) {
					if (student.getName().equals(user.getUserName())) {
						ind = Data.studentList.indexOf(student);
					}
				}
				new CourseEquipmentPanel(Data.studentList.get(ind), Data.courseList.get(AvailableCourses.getSelectedIndex()).getCourse_name());
				ModelRegistered.add(ModelRegistered.getSize(), AvailableCourses.getSelectedValue());
				ModelAvailable.remove(AvailableCourses.getSelectedIndex());
				
			}
		});
		
		int balanceLast = Data.studentList.get(indexOfStudent).getMonetary_balance();
		
		if(balance != balanceLast) {
			Balance.setText("Balance: " + Data.studentList.get(indexOfStudent).getMonetary_balance() + "$");
		}

		JLabel lblNewLabel = new JLabel("<html>Passed<br>Courses</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblregisteredcourses = new JLabel("<html>Registered<br>Courses</html>");
		lblregisteredcourses.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblavailablecourses = new JLabel("<html>Available<br>Courses</html>");
		lblavailablecourses.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_1 = new JButton("Display/Modify" + user.getUserName() + "'s Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind = 0;
				for(Student student: Data.studentList) {
					if (student.getName().equals(user.getUserName())) {
						ind = Data.studentList.indexOf(student);
					}
				}
				new DisplayStudentInformationPanel(Data.studentList.get(ind));
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(UIManager.getColor("Button.light"));
		
		final JLabel NameLabel = new JLabel(user.getUserName() + "'s Student Panel");
		NameLabel.setBackground(new Color(0, 0, 255));
		NameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		NameLabel.setForeground(new Color(135, 206, 250));
		
		JButton RefreshButton = new JButton("Refresh the Page");
		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int ind11 = 0;
				for(Student student: Data.studentList) {
					if (student.getName().equals(user.getUserName())) {
						ind11 = Data.studentList.indexOf(student);
					}
				}
				Balance.setText("<html>Balance: <br>" + Data.studentList.get(ind11).getMonetary_balance() + "$</html>");
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
		
		
		

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(PassedCourses, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(RegisteredCourses, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(1))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnNewButton_1)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGap(80)
								.addComponent(lblregisteredcourses, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnAddSelectedCourse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(AvailableCourses, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(Balance, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblavailablecourses, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(39))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addComponent(NameLabel, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(237, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(66)
					.addComponent(RefreshButton, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(335, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(NameLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(Balance))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAddSelectedCourse, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(92))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(lblregisteredcourses, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(RegisteredCourses, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(PassedCourses, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(62)
									.addComponent(lblavailablecourses, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(AvailableCourses, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(79)
					.addComponent(RefreshButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(339, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton_2 = new JButton("← Go Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(6, 515, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
	}
}
