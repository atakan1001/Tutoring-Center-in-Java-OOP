import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Models.ALevelTutor;
import Models.Course;
import Models.Student;
import Models.Tutor;
import Models.User;
import core.CourseLevel;
import data.Data;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TutorPanel {
	
	private JFrame frame;
	private User tutor;
	private int index;
	private JList CoursesTaught;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TutorPanel(User tutor) {
		
		this.tutor = tutor;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		for(Tutor tutor1 : Data.tutorList) {
			if(tutor1.getTutor_name().equals(tutor.getUserName())) {
				index = Data.tutorList.indexOf(tutor1);
				
			}
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 593, 418);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JLabel LabelTutorPanel = new JLabel(tutor.getUserName() + "'s Tutor Panel");
		LabelTutorPanel.setBounds(66, 6, 203, 44);
		panel.add(LabelTutorPanel);
		
		final DefaultListModel ModelTaught = new DefaultListModel();
		CoursesTaught = new JList(ModelTaught);
		CoursesTaught.setBounds(6, 159, 131, 224);
		panel.add(CoursesTaught);
		
		int i = 0;
		for(String courseName : Data.tutorList.get(index).getTime_schedules().keySet()) {
			ModelTaught.add(i, courseName);
			i ++;
		}
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Courses Taught");
		lblNewLabel_1.setBounds(18, 118, 119, 48);
		panel.add(lblNewLabel_1);
		
		final DefaultListModel ModelToTeach = new DefaultListModel();
		final JList CourseTeach = new JList(ModelToTeach);
		CourseTeach.setBounds(438, 159, 149, 252);
		panel.add(CourseTeach);
		
		int j = 0;
		for(Course course : Data.courseList) {
			if(ModelTaught.contains(course.getCourse_name()) == false && ModelToTeach.contains(course.getCourse_name()) == false) {
				ModelToTeach.add(j, course.getCourse_name());
				j ++;
			}
			
		}
		
		
		JLabel lblNewLabel_2 = new JLabel("To Teach");
		lblNewLabel_2.setBounds(478, 115, 149, 34);
		panel.add(lblNewLabel_2);
		
		JButton TeachButton = new JButton("← Teach ←");
		TeachButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int courseIndex = 0;
				
				if(Data.tutorList.get(index) instanceof ALevelTutor) {
					new TimeSchedule(Data.tutorList.get(index), CourseTeach.getSelectedValue().toString());
					
					ModelTaught.add(ModelTaught.getSize(), CourseTeach.getSelectedValue());
					ModelToTeach.remove(CourseTeach.getSelectedIndex());
				}
				else {
					
					
					for(Course course : Data.courseList) {
						if (course.getCourse_name().equals(CourseTeach.getSelectedValue())) {
							courseIndex = Data.courseList.indexOf(course);
						}
					}
					
					if(Data.courseList.get(courseIndex).getType().equals(CourseLevel.ADVANCED)) {
						JOptionPane.showMessageDialog(frame, "You Cannot Select an Advanced Course! ");
					}
					else {
						new TimeSchedule(Data.tutorList.get(index), CourseTeach.getSelectedValue().toString());

						ModelTaught.add(ModelTaught.getSize(), Data.courseList.get(courseIndex).getCourse_name());
						ModelToTeach.remove(CourseTeach.getSelectedIndex());
					}
					
				}
				
				
			}
		});
		TeachButton.setBounds(199, 167, 187, 48);
		panel.add(TeachButton);
		
		
		JButton DropButton = new JButton("→ Drop →");
		DropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModelToTeach.add(ModelToTeach.getSize(), CoursesTaught.getSelectedValue());
				ModelTaught.remove(CoursesTaught.getSelectedIndex());
				
			}
		});
		DropButton.setBounds(199, 243, 187, 48);
		panel.add(DropButton);
		
		final JButton DisplayButton = new JButton("Display/Modify" + tutor.getUserName() + "'s Information");
		DisplayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayTutorInformationPanel(Data.tutorList.get(index));

			}
		});
		DisplayButton.setBounds(20, 50, 295, 29);
		panel.add(DisplayButton);
		
		JButton btnNewButton = new JButton("Student Informations for Selected Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentInfoOfSelectedCourse(Data.tutorList.get(index), CoursesTaught.getSelectedValue().toString());
			}
		});
		btnNewButton.setBounds(18, 83, 301, 34);
		panel.add(btnNewButton);
		
		JButton RefreshButton = new JButton("Refresh the Page");
		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DisplayTutorInformationPanel.names.size() != 0) {
					LabelTutorPanel.setText(DisplayTutorInformationPanel.names.get(DisplayTutorInformationPanel.names.size() - 1) + "'s Tutor Panel");

				}
			}
		});
		RefreshButton.setBounds(218, 340, 149, 48);
		panel.add(RefreshButton);
		
		JButton btnNewButton_1 = new JButton("← Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(16, 383, 117, 29);
		panel.add(btnNewButton_1);
		
		JLabel ImageLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/tutor.png")).getImage();
		ImageLabel.setIcon(new ImageIcon(image));
		ImageLabel.setBounds(426, 19, 161, 83);
		panel.add(ImageLabel);
		
		
	
		
		
		
		
		
		
	}
}
