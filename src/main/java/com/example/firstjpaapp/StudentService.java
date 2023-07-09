package com.example.firstjpaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public String deleteStudent(int rollNo) {
        studentRepository.deleteById(rollNo);

        return "Student Removed Successfully";
    }

    public List<Student> findAll() {
        List<Student> al = studentRepository.findAll();

        return al;

    }


    public Student updateTheAge(int rollNo, int age) {
        Optional<Student> student1 = studentRepository.findById(rollNo);

        if(student1.isPresent()){
            student1.get().setAge(age);
            studentRepository.save(student1.get());

            return student1.get();
        }

        return null;



    }

    public Student findStudentWithGivenName(String name) {
        List<Student> list = findAll();

        for(int i=0; i<list.size(); i++){
            if(list.get(i).getName() == name){
                return list.get(i);
            }
        }

        return null;
    }
}
