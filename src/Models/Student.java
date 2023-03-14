package Models;

import java.util.ArrayList;




public class Student {
	private String name;
	private String TCKN;
	private Integer age;
	
	private ArrayList<Course> passed_courses;
	private ArrayList<Course> registered_courses;
	private Integer balance;
	private String gender;
	
	
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTCKN() {
		return TCKN;
	}
	public void setTCKN(String tCKN) {
		TCKN = tCKN;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public ArrayList<Course> getPassed_courses() {
		return passed_courses;
	}
	public void setPassed_courses(ArrayList<Course> passed_courses) {
		this.passed_courses = passed_courses;
	}
	public ArrayList<Course> getRegistered_courses() {
		return registered_courses;
	}
	public void setRegistered_courses(ArrayList<Course> registered_courses) {
		this.registered_courses = registered_courses;
	}
	public Integer getMonetary_balance() {
		return balance;
	}
	public void setMonetary_balance(Integer balance) {
		this.balance = balance;
	}
	
	
}
