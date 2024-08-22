package com.example.demo.instance;

import com.example.demo.course.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Instance {
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
    private Integer year;
    private Integer sem;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;

    public Instance(){}

    public Instance(Long id, Integer year, Integer sem, Course course) {
        this.id = id;
        this.year = year;
        this.sem = sem;
        this.course = course;
    }
    public Instance(Integer year, Integer sem, Course course) {
        this.year = year;
        this.sem = sem;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSem() {
        return sem;
    }

    public void setSem(Integer sem) {
        this.sem = sem;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    
    
}
    