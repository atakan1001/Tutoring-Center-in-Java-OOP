import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Models.Course;
import Models.Tutor;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeSchedule {

	private JFrame frame;
	private Tutor tutor;
	private String course;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TimeSchedule(Tutor tutor, String course) {
		this.tutor = tutor;
		this.course = course;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<String> Times = new ArrayList<String>();
		Times.add("08.00 - 09.00");
		Times.add("09.00 - 10.00");
		Times.add("10.00 - 11.00");
		Times.add("11.00 - 12.00");
		Times.add("13.00 - 14.00");
		Times.add("14.00 - 15.00");
		Times.add("15.00 - 16.00");
		Times.add("16.00 - 17.00");
		Times.add("17.00 - 18.00");
		Times.add("18.00 - 19.00");
		Times.add("19.00 - 20.00");
		Times.add("20.00 - 21.00");
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 410);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel TimeLabel = new JLabel("Unavailable Times");
		TimeLabel.setBounds(31, 22, 133, 30);
		panel.add(TimeLabel);
		
		final DefaultListModel ModelTime = new DefaultListModel();
		JList TimeList = new JList(ModelTime);
		TimeList.setBounds(31, 57, 125, 279);
		panel.add(TimeList);
		
		final DefaultListModel ModelTimeAvailable = new DefaultListModel();
		final JList AvailableTimeList = new JList(ModelTimeAvailable);
		AvailableTimeList.setBounds(412, 57, 133, 279);
		panel.add(AvailableTimeList);
		
		int indx1 = 0;
		int indx2 = 0;
		for(String courseTime : Times) {
			
			if(tutor.getTime_schedules().values().contains(courseTime)) {
				ModelTime.add(indx1, courseTime);
				indx1 ++;
				
			}
			
			else {
				ModelTimeAvailable.add(indx2, courseTime);
				indx2 ++;
			}
			
			
			
		}
		
		JLabel lblAvailableTimes = new JLabel("Available Times");
		lblAvailableTimes.setBounds(423, 22, 133, 30);
		panel.add(lblAvailableTimes);
		
		JButton SelectButton = new JButton("← Select Time Schedule ←");
		SelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AvailableTimeList.getSelectedValue() != null) {
					JOptionPane.showMessageDialog(frame, tutor.getTutor_name() + " will teach " + course + "\nbetween " + AvailableTimeList.getSelectedValue());
					ModelTime.add(ModelTime.getSize(), AvailableTimeList.getSelectedValue());
					ModelTimeAvailable.remove(AvailableTimeList.getSelectedIndex());
				}
				else {
					JOptionPane.showMessageDialog(frame, "Please Select a time schedule to Teach " + course);

				}
				
			//	frame.setVisible(false);
				
			}
		});
		SelectButton.setBounds(167, 201, 219, 55);
		panel.add(SelectButton);
		
		JButton btnNewButton = new JButton("← Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(31, 348, 117, 29);
		panel.add(btnNewButton);
		
	}
}
