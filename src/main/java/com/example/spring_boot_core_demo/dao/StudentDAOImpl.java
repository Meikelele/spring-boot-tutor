package com.example.spring_boot_core_demo.dao;

import com.example.spring_boot_core_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // communication with database
public class StudentDAOImpl implements StudentDAO {

    // entity menager is between data base and entity JPA
    // persist - CREATE / SAVE
    //
    // merge - UPDATE
    // remove - DELETE
    //
    private final EntityManager entityManager;


    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional // atomic, whenw e update, delete or adding new objects
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        //if not found returns null
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theStudent = entityManager.createQuery(
                "FROM Student where lastName=:theData", Student.class);

        theStudent.setParameter("theData", theLastName);

        // return results

        return theStudent.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }


}
