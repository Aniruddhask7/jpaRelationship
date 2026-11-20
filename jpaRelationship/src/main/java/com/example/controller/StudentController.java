package com.example.controller;
import com.example.entity.Student;
import com.example.services.StudentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    public final StudentServices studServ;

    public StudentController(StudentServices studServ){
        this.studServ =studServ;
    }

    @PostMapping("/{dept_id}")
    public ResponseEntity<String>createStudent(@RequestBody Student student , @PathVariable long dept_id){
        studServ.createStudent(student , dept_id);
        return ResponseEntity.ok("done");
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String>createStudent(@RequestBody Student student ,@RequestParam String deptName ){
        studServ.createStudent(student , deptName);
        return ResponseEntity.ok("done");
    }

}
