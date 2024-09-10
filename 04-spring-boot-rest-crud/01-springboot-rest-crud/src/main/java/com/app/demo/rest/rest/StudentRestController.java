package com.app.demo.rest.rest;

import com.app.demo.rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to laod the student data ... only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Triss", "Merigold"));
        theStudents.add(new Student("Lytta", "Neid"));
        theStudents.add(new Student("Yennefer", "Vengerberg"));

    }


    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    @RequestMapping("/students/{studentId}")
    public Student getOneStudent(@PathVariable int studentId) {

        // check the studentId again list size
        if ( (studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }


}
