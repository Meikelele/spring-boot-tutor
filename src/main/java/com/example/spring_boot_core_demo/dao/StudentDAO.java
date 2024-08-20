package com.example.spring_boot_core_demo.dao;

import com.example.spring_boot_core_demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String string);

    void update(Student theStudent);

}
