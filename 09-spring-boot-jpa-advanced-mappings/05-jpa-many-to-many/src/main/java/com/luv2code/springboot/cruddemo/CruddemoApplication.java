package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.Dao.AppDAO;
import com.luv2code.springboot.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {

//			createCourseAndStudents(appDAO);

//			findCourseAndStudents(appDAO);

//			findStudentsAndCourses(appDAO);

//			addMoreCoursesForStudents(appDAO);

//			deleteCourse(appDAO);

			deleteStudent(appDAO);

		};

	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Deleting the student id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done!!");
	}

	private void addMoreCoursesForStudents(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent  = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("Rubik's cube - how to make one million score");
		Course tempCourse2 = new Course("English Course - new 1000");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		appDAO.update((tempStudent));

		System.out.println("Done!");
	}

	private void findStudentsAndCourses(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());

		System.out.println("Done!!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theid=10;
		Course tempcourse = appDAO.findCourseAndStudentByCourseId(theid);

		System.out.println("Loaded course: " + tempcourse);
		System.out.println("Students: " + tempcourse.getStudents());

		System.out.println("Done!! ");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman =  How To Score One Million");

		// create the students
		Student tempStudent1 = new Student("John" , "Doe" , "John@luv2code.com");
		Student tempStudent2 = new Student("Mary" , "Public" , "Mary@luv2code.com");

		// add a studends to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and asscociated students
		System.out.println("saving the course : " + tempCourse);
		System.out.println("asscociated student " + tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Done!!");

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		System.out.println("Delete course id: " + theId);
		appDAO.deleteCourseByID(theId);
		System.out.println("Done");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done!!");

	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Pacman - How to Score one Million Points");

		// add some revies
		tempCourse.addREview(new Review(" Great Course... loved it"));
		tempCourse.addREview(new Review(" Cool course, job well done"));
		tempCourse.addREview(new Review(" what a dumb course, you are an idiot"));

		// save the course ... leverage the cascade
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!!");

	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting the Course " + theId );

		appDAO.deleteCourseByID(theId);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		//find the course
		System.out.println("Finding course: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the simle things");

		appDAO.update(tempCourse);
		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		//find the instructor
		System.out.println("Find the instructor: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update the instructor
		System.out.println("Updating instructor id:" + theId);
		tempInstructor.setLastName("Tester");

		appDAO.update(tempInstructor);
		System.out.println("Done!");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;
		// find the instructor

		System.out.println("Finding instructot id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor" + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		// find the instructor
		System.out.println("Find instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructot id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the asscoiated courses: " + tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("susan", "public", "susan@luv2code.com");

		// create instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "gamer!!!");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The ultimate Guide");
		Course tempCourse2  = new Course("The pinball MasterClass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor

		// Note: this will Alos save the courses because of CascadeType.Persist

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailsById(theId);

		System.out.println("Done!");
	}


	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId=2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the asscociated intructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the asscociated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("chad", "Darby", "darby@luv2code.com");

		// create instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "luv 2 code!!!");

//		// create the instructor
//		Instructor tempInstructor = new Instructor("madhu", "patel", "madhy@luv2code.com");
//
//		// create instructor details
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "luv 2  fuitar!!!");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// Note: this will also save the details object because of cascadetype.all
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
