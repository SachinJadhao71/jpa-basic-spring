package com.example.firstjpaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    delete student by roll number
    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int rollNo){
        String s = studentService.deleteStudent(rollNo);

        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);

    }
//    update the age of student based on roll number -> roll no and age as input
    @PutMapping("/updateAge")
    public ResponseEntity updateTheAge(@RequestParam("id") int rollNo, @RequestParam("age") int age){
        Student student1 = studentService.updateTheAge(rollNo,age);
        if(student1 != null)
            return new ResponseEntity<>(student1,HttpStatus.OK);

        return new ResponseEntity<>("student is not exists",HttpStatus.NOT_FOUND);
    }

//    find all the student who have age greater than 25
    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        List<Student> al =studentService.findAll();

        return new ResponseEntity<>(al,HttpStatus.ACCEPTED);
    }
//    delete all the student
//    find all the student with given name

    @GetMapping("/findByName")
    public ResponseEntity findStudentWithGivenName(@RequestParam("name") String name){
        Student s1 = studentService.findStudentWithGivenName(name);

        if(s1 != null){
            return new ResponseEntity<>(s1,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("student not found",HttpStatus.NOT_FOUND);
    }
}
