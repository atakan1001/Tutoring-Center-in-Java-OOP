/************** Pledge of Honor ******************************************
I hereby certify that I have completed this programming project on my own
without any help from anyone else. The effort in the project thus belongs
completely to me. I did not search for a solution, or I did not consult any
program written by others or did not copy any program from other sources. I
read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Atakan Arslan, 80878>
*************************************************************************/

package data;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import Models.ALevelTutor;
import Models.BLevelTutor;
import Models.Course;
import Models.Equipment;
import Models.Student;
import Models.Tutor;
import Models.User;
import core.RoleType;

public class Data {
	public static List<Equipment> equipmentList = equipmentInıt();
	public static List<Tutor> tutorList = tutorInıt();
	public static List<Course> courseList = courseInıt();

	public static List<Student> studentList = studentInıt();

	public static List<User> userList = userInıt();
	

	
	
	
	public static ArrayList<Course> prereq;
	public static ArrayList<Tutor> tutors;
	public static ArrayList<Equipment> equipments;
	public static ArrayList<Student> studentListforCourse;

	
	public static List<User> userInıt(){
		
	
		User userTutor;
		User userStudent;
		User userAdministrator = new User();
		
		userList = new ArrayList<>();
		
		for(Student student : studentList) {
			userStudent = new User();
			userStudent.setUserName(student.getName());
			userStudent.setPassword("0000");
			userStudent.setRole(core.RoleType.STUDENT);
			userList.add(userStudent);
		}
		
		for(Tutor tutor : tutorList) {
			userTutor = new User();
			userTutor.setUserName(tutor.getTutor_name());
			userTutor.setPassword("1111");
			userTutor.setRole(core.RoleType.TUTOR);
			userList.add(userTutor);
		}
		
		
		userAdministrator.setUserName("Atakan");
		userAdministrator.setPassword("123");
		userAdministrator.setRole(RoleType.ADMINISTRATOR);
		
		userList.add(userAdministrator);

		
		return userList;
		
		
	}
	public static Course createCourse(String courseName, String level, ArrayList<Course> prereqs) {
		Course course = new Course();
		
		tutors = new ArrayList<Tutor>();
		equipments = new ArrayList<Equipment>();
		int eq1 = new Random().nextInt(5);
		equipments.add(equipmentList.get(eq1));
	
		while (true) {
			int eq2 = new Random().nextInt(5);
			if (eq2 != eq1) {
				equipments.add(equipmentList.get(eq2));
				break;
			}
		}
		
		course.setReq_equipments(equipments);
		course.setStudents(new ArrayList<Student>());
		course.setType(level);
		course.setPre_req(prereqs);
		course.setCourse_name(courseName);
		
		Integer []courseTime = new Integer[2];
			
		
		if (level.equals(core.CourseLevel.BEGINNER)) {
			int i = 1;
			while(i<=3) {
				courseTime[0]= new Random().nextInt(3) + 8;
				courseTime[1]= new Random().nextInt(8) + 13;
				
				int constant = (new Random().nextInt(12));
				
				int hour = courseTime[new Random().nextInt(2)];
				
				
				
				if(tutors.contains(tutorList.get(constant)) == false && tutorList.get(constant).getTime_schedules().containsValue(hour + ".00 - " + (hour+1) + ".00") == false) {
					tutorList.get(constant).getTime_schedules().put(courseName, hour + ".00 - " + (hour+1) + ".00" );

					tutors.add(tutorList.get(constant));
					i++;
				}
				
			}
			
			
			
			
		}
		
		else {
			int i=1;
			while(i<=3) {
				courseTime[0]= new Random().nextInt(3) + 8;
				courseTime[1]= new Random().nextInt(8) + 13;
				int constant = (new Random().nextInt(6) );
				int hour = courseTime[new Random().nextInt(2)];
				

				if(tutors.contains(tutorList.get(constant)) == false && tutorList.get(constant).getTime_schedules().containsValue(hour + ".00 - " + (hour+1) + ".00") == false) {
					tutorList.get(constant).getTime_schedules().put(courseName, hour + ".00 - " + (hour+1) + ".00" );

					tutors.add(tutorList.get(constant));
					i++;
				}
				
			}
			
		
			
		}
		
		course.setTutors(tutors);
		courseList.add(course);
		return course;
	}
		
	
	public static List<Course> courseInıt(){
		
		courseList = new ArrayList<>();
		
		
		tutors = new ArrayList<>();
		
		prereq = new ArrayList<>();
		Course MATH101 = createCourse("MATH101", core.CourseLevel.BEGINNER, prereq);
		//courseList.add(MATH101);
		
		
		
		prereq = new ArrayList<>();
		prereq.add(MATH101);
		Course MATH102 = createCourse("MATH102", core.CourseLevel.BEGINNER, prereq);
		//courseList.add(MATH102);

		prereq = new ArrayList<>();
		Course PHYS101 = createCourse("PHYS101", core.CourseLevel.BEGINNER, prereq);
		//courseList.add(PHYS101);

		prereq = new ArrayList<>();
		prereq.add(PHYS101);
		Course PHYS102 = createCourse("PHYS102", core.CourseLevel.BEGINNER, prereq);
		//courseList.add(PHYS102);

		prereq = new ArrayList<>();
		Course CHEM101 = createCourse("CHEM101", core.CourseLevel.BEGINNER, prereq);
		//courseList.add(CHEM101);

		prereq = new ArrayList<>();
		prereq.add(CHEM101);
		Course CHEM102 = createCourse("CHEM102", core.CourseLevel.BEGINNER, prereq);
		//courseList.add(CHEM102);

		
		prereq = new ArrayList<>();
		prereq.add(MATH102);
		Course MATH201 = createCourse("MATH201", core.CourseLevel.ADVANCED, prereq);
		//courseList.add(MATH201);

		prereq = new ArrayList<>();
		prereq.add(MATH201);
		Course ENGR421 = createCourse("ENGR421", core.CourseLevel.ADVANCED, prereq);
		//courseList.add(ENGR421);

		prereq = new ArrayList<>();
		prereq.add(CHEM102);
		Course CHEM210 = createCourse("CHEM210", core.CourseLevel.ADVANCED, prereq);
		//courseList.add(CHEM210);

		prereq = new ArrayList<>();
		prereq.add(MATH201);
		Course ELEC301 = createCourse("ELEC301", core.CourseLevel.ADVANCED, prereq);
		//courseList.add(ELEC301);

		prereq = new ArrayList<>();
		Course COMP207 = createCourse("COMP207", core.CourseLevel.ADVANCED, prereq);
		//courseList.add(COMP207);

		prereq = new ArrayList<>();
		prereq.add(PHYS102);
		Course MECH311 = createCourse("MECH311", core.CourseLevel.ADVANCED, prereq);
		//courseList.add(MECH311);

		
		return courseList;
		
		
	}
	
	public static List<Student> studentInıt(){
		studentList = new ArrayList<>();
		Student userStudent;
		
		for (int i = 1; i <= 24; i++ ) {
			ArrayList<Course> registeredCourses = new ArrayList<Course>();
			userStudent = new Student();
			int res = new Random().nextInt(2);
			if(res %2  == 0) 	{
				userStudent.setGender("Female");
			}		
			else {
				userStudent.setGender("Male");

			}
			userStudent.setName("Student" + i);
			userStudent.setAge(18 + (i%5));
			userStudent.setMonetary_balance(10000);
			userStudent.setTCKN("0000" + i);
			userStudent.setRegistered_courses(registeredCourses);
			
			
			ArrayList<Course> passedCourses = new ArrayList<Course>();
			studentList.add(userStudent);
			
			for(int j=1; j <= 2; j++ ) {
				Random r = new Random();
				int result = r.nextInt(12);
				if(passedCourses.contains(courseList.get(result)) == false ) passedCourses.add(courseList.get(result));
			}
			
			userStudent.setPassed_courses(passedCourses);
			
			
			for (Course course : courseList) {
				studentListforCourse = course.getStudents();
			
				if ( course.getStudents().size() < 9) {
					int rand = (new Random().nextInt(2)) + 1;
					if(rand == 1 && course.getStudents().contains(userStudent) == false) {
						studentListforCourse.add(userStudent);
						
					}		
				}
				
				
				
				course.setStudents(studentListforCourse);
			
			}
			
		}	
		
		
		return studentList;
	}
	
	public static List<Tutor> tutorInıt(){
		tutorList = new ArrayList<>();
		Tutor userTutor;
		
		for (int i = 1; i <= 6; i++ ) {
			HashMap<String,String> time_schedules = new HashMap<>();
			HashMap<Course, ArrayList<Student>> students = new HashMap<>();
			userTutor = new ALevelTutor("Tutor" + i, i, 0, time_schedules, 700 + i, new Random().nextInt(11), students);
			//userTutor.setID(i);
			//userTutor.setMonetary_balance(0);
			//userTutor.setTutor_name("Tutor" + i);
			//userTutor.setTutor_percentage(new Random().nextInt(11));
			//userTutor.setTutoring_cost(700 + i);
			tutorList.add(userTutor);
			
		}
		for (int i = 7; i <= 12; i++ ) {
			HashMap<String,String> time_schedules = new HashMap<>();
			HashMap<Course, ArrayList<Student>> students = new HashMap<>();
			userTutor = new BLevelTutor("Tutor" + i, i, 0, time_schedules, 1000 - i, new Random().nextInt(16), students);
			//userTutor = new BLevelTutor();
			//userTutor.setID(i);
			//userTutor.setMonetary_balance(0);
			//userTutor.setTutor_name("Tutor" + i);
			//userTutor.setTutor_percentage(new Random().nextInt(16));
			//userTutor.setTutoring_cost(1000 - i);
			tutorList.add(userTutor);
			
		}
		
		return tutorList;
		
	}
	
	

	
	
	
	public static List<Equipment> equipmentInıt(){
		
		equipmentList = new ArrayList<>();
		
		Equipment equipment = new Equipment();
		equipment.setName("Laptop");
		equipment.setPrice(1000);
		equipment.setPercentage(20);
		equipmentList.add(equipment);
		
		Equipment equipment1 = new Equipment();
		equipment1.setName("Pencil");
		equipment1.setPrice(100);
		equipment1.setPercentage(15);
		equipmentList.add(equipment1);
		
		Equipment equipment2 = new Equipment();
		equipment2.setName("Paper");
		equipment2.setPrice(10);
		equipment2.setPercentage(12);
		equipmentList.add(equipment2);
		
		Equipment equipment3 = new Equipment();
		equipment3.setName("Calculator");
		equipment3.setPrice(150);
		equipment3.setPercentage(25);
		equipmentList.add(equipment3);
		
		Equipment equipment4 = new Equipment();
		equipment4.setName("Book");
		equipment4.setPrice(300);
		equipment4.setPercentage(17);
		equipmentList.add(equipment4);
		

		return equipmentList;
		

	}
	
	
	
	
	
	public void userAdd(User user) {
		userList.add(user);
	}
	
	
	
	
}
