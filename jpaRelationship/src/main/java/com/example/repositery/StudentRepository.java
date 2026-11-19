package com.example.repositery;

import com.example.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }
}
