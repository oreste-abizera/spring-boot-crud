package com.crudApp.CRUD.controllers;

import com.crudApp.CRUD.models.Marks;
import com.crudApp.CRUD.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksController {
    @Autowired
    private MarksRepository marksRepository;

    @GetMapping
    public List<Marks> getMarks(){
        return marksRepository.findAll();
    }

    @GetMapping("/{id}")
    public Marks getMark(@PathVariable(value = "id") Long id){
        return marksRepository.findById(id).get();
    }

    @PostMapping("/create")
    public ResponseEntity<Marks> create(@RequestBody Marks mark) {
        Marks m= marksRepository.save(mark);
        return ResponseEntity.ok(m);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marks> updateMark(@RequestBody Marks newMark, @PathVariable(value = "id") Long id) {
        return marksRepository.findById(id)
                .map(mark -> {
                    mark.setScore(newMark.getScore());
                    mark.setMaximum(newMark.getMaximum());
                    mark.setCourse(newMark.getCourse());
                    mark.setStudent(newMark.getStudent());
                    marksRepository.save(mark);
                    return ResponseEntity.ok(mark);
                })
                .orElseGet(()->{
                    newMark.setId(id);
                    marksRepository.save(newMark);
                    return ResponseEntity.ok(newMark);
                });

    }

    @DeleteMapping("/{id}")
    public void deleteMark(@PathVariable(value="id") Long id){
        marksRepository.deleteById(id);
    }
}
