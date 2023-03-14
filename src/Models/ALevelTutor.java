package Models;
import java.util.ArrayList;
import java.util.HashMap;

import Models.Tutor;
import core.RoleType;
public class ALevelTutor extends Tutor {
	
	private Tutor tutor;
	
	public ALevelTutor(String tutor_name, Integer iD, double monetary_balance, HashMap<String, String> time_schedules,
			Integer tutoring_cost, double tutor_percentage, HashMap<Course, ArrayList<Student>> students) {
		super(tutor_name, iD, monetary_balance, time_schedules, tutoring_cost, tutor_percentage, students);
		
		
	}

	@Override
	public double tutorIncome() {
		double income =  (this.getTutoring_cost() * (100.0 - this.getTutor_percentage())/100.0 * (this.getTime_schedules().keySet().size()));

		return income;
	}

	@Override
	public String setType() {
		
		String str = "ALevel";
		return str;
		
		
	}

	
	

	
	
}
