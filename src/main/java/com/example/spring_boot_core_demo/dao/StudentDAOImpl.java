package com.example.spring_boot_core_demo.dao;

import com.example.spring_boot_core_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


public class StudentDAOImpl implements StudentDAO {

    // define field for entity menager
    private EntityManager entityManager;


    // inject entity manager using constructor injection
//    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }







}
