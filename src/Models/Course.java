package Models;
import java.util.ArrayList;

import core.CourseLevel;

public class Course {
	
	private String course_name;
	private ArrayList<Tutor> tutors;
	private ArrayList<Student> students;
	private ArrayList<Course> pre_req = new ArrayList<Course>();
	private ArrayList<Equipment> req_equipments;
	private String type;
	
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public ArrayList<Tutor> getTutors() {
		return tutors;
	}
	public void setTutors(ArrayList<Tutor> tutors) {
		this.tutors = tutors;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public ArrayList<Course> getPre_req() {
		return pre_req;
	}
	public void setPre_req(ArrayList<Course> pre_req) {
		this.pre_req = pre_req;
	}
	public ArrayList<Equipment> getReq_equipments() {
		return req_equipments;
	}
	public void setReq_equipments(ArrayList<Equipment> req_equipments) {
		this.req_equipments = req_equipments;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
