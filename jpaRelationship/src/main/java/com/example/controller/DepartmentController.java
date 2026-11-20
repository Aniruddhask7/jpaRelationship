package com.example.controller;

import com.example.entity.Department;
import com.example.repositery.DepartmentRepository;
import com.example.services.DepartmentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    public DepartmentServices departmentServ;
    public DepartmentController(DepartmentServices departmentServ){
        this.departmentServ = departmentServ;
    }

    @PostMapping
    public ResponseEntity<String>createDepartment(@RequestBody Department department){
        departmentServ.createDepartment(department);
       return ResponseEntity.ok("Done");
    }

}
