import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Models.Course;
import Models.Tutor;
import core.CourseLevel;
import data.Data;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddCourse {

	private JFrame frame;
	private JTextField CourseNameTextField;
	private String newCourseType;
	private ArrayList<Course> prereq = new ArrayList<Course>();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AddCourse() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 608, 592);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Set Course Name:");
		lblNewLabel.setBounds(21, 31, 141, 50);
		panel.add(lblNewLabel);
		
		CourseNameTextField = new JTextField();
		CourseNameTextField.setBounds(292, 43, 226, 26);
		panel.add(CourseNameTextField);
		CourseNameTextField.setColumns(10);
		
		JButton SetNameButton = new JButton("Set");
		SetNameButton.setBounds(401, 71, 117, 29);
		panel.add(SetNameButton);
		
		JLabel lblSetCourseLevel = new JLabel("Set Course Level:");
		lblSetCourseLevel.setBounds(21, 156, 141, 50);
		panel.add(lblSetCourseLevel);
		
		JLabel lblSetAPrerequisite = new JLabel("<html> Set Prerequisite <br> Course: </html>");
		lblSetAPrerequisite.setBounds(21, 299, 141, 50);
		panel.add(lblSetAPrerequisite);
		
		final JRadioButton AdvancedButton = new JRadioButton("Advanced");
		AdvancedButton.setBounds(402, 169, 141, 23);
		panel.add(AdvancedButton);
		
		JRadioButton BeginnerButton = new JRadioButton("Beginner");
		BeginnerButton.setBounds(229, 169, 138, 23);
		panel.add(BeginnerButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(AdvancedButton);
		group.add(BeginnerButton);
		
		
		JButton SetLevelButton = new JButton("Set");
		SetLevelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PrereqCourseName = null;
				
				if (AdvancedButton.isSelected()) {
					newCourseType = CourseLevel.ADVANCED;
					final DefaultListModel ModelSelection = new DefaultListModel();
					final JList list = new JList(ModelSelection);
					list.setBounds(353, 308, 181, 212);
					int indd = 0;
					for(Course course : Data.courseList) {
						if(course.getCourse_name().equals(CourseNameTextField.getText()) == false &&
								ModelSelection.contains(course.getCourse_name()) == false){
							ModelSelection.add(indd, course.getCourse_name());
							indd++;
						}
					}
	
					panel.add(list);
					SwingUtilities.updateComponentTreeUI(frame);
					if(list.getSelectedValue() != null) {
						PrereqCourseName = list.getSelectedValue().toString();
					}
					

				}
				
				else {
					newCourseType = CourseLevel.BEGINNER;
					final DefaultListModel ModelSelection = new DefaultListModel();
					final JList list = new JList(ModelSelection);
					list.setBounds(353, 308, 181, 212);
					int indd = 0;
					for(Course course : Data.courseList) {
						if(course.getCourse_name().equals(CourseNameTextField.getText()) == false && 
								course.getType().equals(CourseLevel.BEGINNER) == true &&
								ModelSelection.contains(course.getCourse_name()) == false){
							
							ModelSelection.add(indd, course.getCourse_name());
							indd++;
						}
					}
	
					panel.add(list);
					SwingUtilities.updateComponentTreeUI(frame);
					if(list.getSelectedValue() != null) {
						PrereqCourseName = list.getSelectedValue().toString();
					}

				}
				
				for(Course course1 : Data.courseList) {
					if(course1.getCourse_name().equals(PrereqCourseName)) {
						prereq.add(course1);
					}
				}
			}
			
			
		
			
		});
		

		
		SetLevelButton.setBounds(401, 204, 117, 29);
		panel.add(SetLevelButton);
		
		JButton PrereqButton = new JButton("Select as Prerequisite");
		PrereqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course NewCourse = Data.createCourse(CourseNameTextField.getText().toString(), newCourseType, prereq);
				
				JOptionPane.showMessageDialog(frame, CourseNameTextField.getText().toString() + " is added to Course List!" );

				frame.setVisible(false);

			}
		});
		PrereqButton.setBounds(401, 532, 158, 40);
		panel.add(PrereqButton);
		
		JButton btnNewButton = new JButton(" ← Back to ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(21, 538, 141, 26);
		panel.add(btnNewButton);
		
		
		
		

		
	}
}
