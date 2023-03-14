import java.awt.EventQueue;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Models.Course;
import Models.Student;
import data.Data;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class SortbyAge implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
    	if(a.getAge() < b.getAge()) return 1;
    	
    	else if(a.getAge() == b.getAge()) {
    		if(a.getGender().equals("female") == true) return 1;
    		else return -1;
    	}
    	
    	else return -1;
    }
}
public class DispStudentsInCourse {

	private JFrame frame;
	private Course course;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public DispStudentsInCourse(Course course) {
		this.course = course;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 619, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 613, 416);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Students Registered in " + course.getCourse_name());
		lblNewLabel.setBounds(19, 6, 226, 33);
		panel.add(lblNewLabel);
		
		DefaultListModel ModelStudents = new DefaultListModel();
		JList list = new JList(ModelStudents);
		list.setBounds(19, 56, 263, 320);
		panel.add(list);
		
		JButton btnNewButton = new JButton("← Back to");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(19, 388, 158, 22);
		panel.add(btnNewButton);
        Collections.sort(course.getStudents(), new SortbyAge());
        
        int ind2 = 0;
		for(Student student : course.getStudents()) {
			ModelStudents.add(ind2, student.getName() + " Age: " + student.getAge() + " Gender: " + student.getGender());
			
		}
		
	}
	
	

}
