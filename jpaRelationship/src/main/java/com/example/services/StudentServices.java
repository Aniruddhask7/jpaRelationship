package com.example.services;

import com.example.entity.Department;
import com.example.entity.Student;
import com.example.repositery.DepartmentRepository;
import com.example.repositery.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    public StudentRepository studentRepository;
    public DepartmentRepository departmentRepository;
    public StudentServices(StudentRepository studentRepository , DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }


    @Transactional
    public void createStudent(Student student , long dept_id){
//        studentRepository.save(student);  we directly nott create the student services firstly we add the
//        departmentid thi that field then we creates student service

        Department department = departmentRepository.getDepartmentById(dept_id);


        student.setDepartment(department);

        studentRepository.save(student);
    }



    @Transactional
    public void createStudent(Student student , String deptName){
        Department department = new Department();

        department.setName(deptName);

        departmentRepository.save(department);
        student.setDepartment(department);

        studentRepository.save(student);

    }

}
