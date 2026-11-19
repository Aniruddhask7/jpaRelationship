package com.example.services;

import com.example.entity.Department;
import com.example.repositery.DepartmentRepository;
import com.example.repositery.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServices {

    public DepartmentRepository departmentRepo;

    public DepartmentServices(DepartmentRepository departmentRepo){
        this.departmentRepo = departmentRepo;
    }


    @Transactional
    public void createDepartment(Department department){
        departmentRepo.save(department);
    }

}
