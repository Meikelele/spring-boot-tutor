package com.example.spring_boot_core_demo;

import com.example.spring_boot_core_demo.dao.StudentDAO;
import com.example.spring_boot_core_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//	create the student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Triss", "Merigold", "triss.merigold@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
