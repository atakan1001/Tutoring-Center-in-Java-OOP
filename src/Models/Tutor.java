package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;



public abstract class Tutor {

	private String tutor_name;
	private Integer ID;
	private double monetary_balance;
	private HashMap<String,String> time_schedules = new HashMap<>();
	private Integer tutoring_cost;
	private double tutor_percentage;
	
	public Tutor(String tutor_name, Integer iD, double monetary_balance, HashMap<String, String> time_schedules,
			Integer tutoring_cost, double tutor_percentage, HashMap<Course, ArrayList<Student>> students) {
		super();
		this.tutor_name = tutor_name;
		ID = iD;
		this.monetary_balance = monetary_balance;
		this.time_schedules = time_schedules;
		this.tutoring_cost = tutoring_cost;
		this.tutor_percentage = tutor_percentage;
		this.students =  new HashMap<Course, ArrayList<Student>>();
	}
	private HashMap<Course, ArrayList<Student>> students = new HashMap<Course, ArrayList<Student>>();
	
	public abstract double tutorIncome();
	
	public abstract String setType();
	
	public String getTutor_name() {
		return tutor_name;
	}
	public void setTutor_name(String tutor_name) {
		this.tutor_name = tutor_name;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public double getMonetary_balance() {
		return monetary_balance;
	}
	public void setMonetary_balance(double monetary_balance) {
		this.monetary_balance = monetary_balance;
	}
	public HashMap<String, String> getTime_schedules() {
		return time_schedules;
	}
	public void setTime_schedules(HashMap<String, String> time_schedules) {
		this.time_schedules = time_schedules;
	}
	public Integer getTutoring_cost() {
		return tutoring_cost;
	}
	public void setTutoring_cost(Integer tutoring_cost) {
		this.tutoring_cost = tutoring_cost;
	}
	public double getTutor_percentage() {
		return tutor_percentage;
	}
	public void setTutor_percentage(double tutor_percentage) {
		this.tutor_percentage = tutor_percentage;
	}
	
	
	public HashMap<Course, ArrayList<Student>> getStudents() {
		return students;
	}
	public void setStudents(HashMap<Course, ArrayList<Student>> students) {
		this.students = students;
	}

	
	
	
	
}
