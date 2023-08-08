package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {

		return runner -> {
			// createStudent(studentDAO);

			createmultipleStudents(studentDao);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDao);

			// updateStudent(studentDao);

			// deleteStudent(studentDao);

			// deleteAllStudents(studentDao);

		};
	}

	private void deleteAllStudents(StudentDao studentDao) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDao.deleteall();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		// retrieve student based on the id
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDao.findbyId(studentId);

		// change the first name  to "scooby"
		System.out.println("updating student.... : " + studentId);
		myStudent.setFirstname("Scooby");

		// update the student
		studentDao.update(myStudent);

		// display the update student
		System.out.println("Updated student: " + myStudent);
	}


	private void queryForStudentsByLastName(StudentDao studentDao) {

		// get a list of students
		List<Student> theStudents = studentDao.findByLastName("Doe");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {

		// get a list of students
		List<Student> theStudents = studentDao.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}



	private void readStudent(StudentDao studentDao){

		// create a student object
		System.out.println("Creating the new student object ...");
		Student tempstudent = new Student("john", "sush", "john@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDao.save(tempstudent);

		// display id of the saved student
		int theid = tempstudent.getId();
		System.out.println("Saved student. Generated id. " + theid);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theid);
		Student mystudent = studentDao.findbyId(theid);

		// display student
		System.out.println("Found the student: " + mystudent);
	}

	private void createmultipleStudents(StudentDao studentDao){
		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempstudent1 = new Student("john", "doe", "john@luv2code.com");
		Student tempstudent2 = new Student("mary", "public", "mary@luv2code.com");
		Student tempstudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		//save the student objects
		System.out.println("saving the changes");
		studentDao.save(tempstudent1);
		studentDao.save(tempstudent2);
		studentDao.save((tempstudent3));
	}
	private void createStudent(StudentDao studentDao){

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDao.save(tempStudent);

		//display the student object
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
