package com.crudApp.CRUD.controllers;

import com.crudApp.CRUD.models.Course;
import com.crudApp.CRUD.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable(value = "id") Long id){
        return courseRepository.findById(id).get();
    }

    @PostMapping("/create")
    public ResponseEntity<Course> create(@RequestBody Course course) {
        Course c= courseRepository.save(course);
        return ResponseEntity.ok(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course newCourse, @PathVariable(value = "id") Long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(newCourse.getName());
                    course.setCourseCode(newCourse.getCourseCode());
                    courseRepository.save(course);
                    return ResponseEntity.ok(course);
                })
                .orElseGet(()->{
                    newCourse.setId(id);
                    courseRepository.save(newCourse);
                    return ResponseEntity.ok(newCourse);
                });

    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable(value="id") Long id){
        courseRepository.deleteById(id);
    }
}
