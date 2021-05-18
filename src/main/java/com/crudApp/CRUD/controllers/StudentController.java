package com.crudApp.CRUD.controllers;

import com.crudApp.CRUD.models.Student;
import com.crudApp.CRUD.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(value = "id") Long id){
        return studentRepository.findById(id).get();
    }

//    @PostMapping
}
