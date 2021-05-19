package com.crudApp.CRUD.controllers;

import com.crudApp.CRUD.models.Student;
import com.crudApp.CRUD.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student s= studentRepository.save(student);
        return ResponseEntity.ok(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student newStudent, @PathVariable(value = "id") Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    studentRepository.save(student);
                    return ResponseEntity.ok(student);
                })
                .orElseGet(()->{
                    newStudent.setId(id);
                    studentRepository.save(newStudent);
                    return ResponseEntity.ok(newStudent);
                });

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value="id") Long id){
        studentRepository.deleteById(id);
    }
}
