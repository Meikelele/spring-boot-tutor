package com.example.spring_boot_core_demo;

import com.example.spring_boot_core_demo.dao.StudentDAO;
import com.example.spring_boot_core_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootCoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);
//			createStudent(studentDAO);

			updateStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		//	create the student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Yennefer", "Venderberg", "yenneferd@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		// retrieve student base on the id: priamry key
		System.out.println("Retrieving student basen on the id: " + theId);
		Student mystudent = studentDAO.findById(theId);

		// displayy student
		System.out.println("Found the student: " + mystudent);


	}

	private void createStudent(StudentDAO studentDAO) {
		//	create the student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Tissani", "Merigold", "tissani.merigold@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//list of students
		List<Student> theStudents = studentDAO.findByLastName("Merigold");

		// displaying the students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id
		int id = 1;
		System.out.println("Retrieving student based on the id: " + id);

		Student myStudent = studentDAO.findById(id);
		System.out.println(myStudent);

		System.out.println("Updating student...");

		// change first name to scooby
		System.out.println("\t changing name to 'Franceska'... ");

		myStudent.setFirstName("Franceska");
		studentDAO.update(myStudent);

		System.out.println("End updating student...");

		// display updated student
		System.out.println(myStudent);
	}


}
