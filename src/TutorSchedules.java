import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import Models.Course;
import Models.Tutor;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;

public class TutorSchedules {

	private JFrame frame;
	private Course course;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TutorSchedules(Course course) {
		this.course = course;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 585, 419);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(course.getCourse_name() + "'s Schedules");
		lblNewLabel.setBounds(18, 0, 192, 71);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("← Back to");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 384, 137, 29);
		panel.add(btnNewButton);
		
		
		DefaultListModel ModelSchedules = new DefaultListModel();
		JList list = new JList(ModelSchedules);
		list.setBounds(17, 62, 153, 302);
		panel.add(list);
	
		for(Tutor tutor : course.getTutors()) {
			
			ModelSchedules.addElement(tutor.getTutor_name() + " " + tutor.getTime_schedules().get(course.getCourse_name()));
		}
		
		
		
	}

}
