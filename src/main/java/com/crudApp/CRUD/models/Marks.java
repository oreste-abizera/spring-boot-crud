package com.crudApp.CRUD.models;

import org.springframework.data.annotation.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
@Entity
public class Marks {
    @Id
    @GeneratedValue
    private Long id;
    private Integer student;
    private Integer course;
    private Integer score;
    private Integer maximum;

    @javax.persistence.Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getStudent() {
        return student;
    }
    public void setStudent(Integer student) {
        this.student = student;
    }
    public Integer getCourse() {
        return course;
    }
    public void setCourse(Integer course) {
        this.course = course;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public Integer getMaximum() {
        return maximum;
    }
    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }
}
