package com.example.firstjpaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student added Succefully";

    }

    public Student getStudent(int rollNo) {
        Optional<Student> student = studentRepository.findById(rollNo);

        if(student.isPresent()){
            return student.get();
        }

        return null;
    }
}
