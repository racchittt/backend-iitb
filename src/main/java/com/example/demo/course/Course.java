package com.example.demo.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(
        name = "iitb_sequence",
        sequenceName = "iitb_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "iitb_sequence"
    )
    private Long id;
    private String title;
    @Column(unique = true)
    private Long courseId;
    private String description;

    public Course() {}

    public Course(Long id, String title, Long courseId, String description){
        this.id = id;
        this.title = title;
        this.courseId = courseId;
        this.description = description;
    }

    public Course(String title, Long courseId, String description){
        this.title = title;
        this.courseId = courseId;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


