package com.example.firstjpaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        String s = studentService.addStudent(student);
        return s;
    }

    @GetMapping("/get_by_id")
    public ResponseEntity getStudent(@RequestParam("rollNo") int rollNo){
        Student student = studentService.getStudent(rollNo);

        if(student == null){
            return new ResponseEntity("Invalid Roll No", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(student,HttpStatus.FOUND);
    }
}
