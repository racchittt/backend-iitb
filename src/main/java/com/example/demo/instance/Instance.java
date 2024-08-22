package com.example.demo.instance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long courseId;

    public Instance(){}

    public Instance(Long id, Integer year, Integer sem, Long courseId) {
        this.id = id;
        this.year = year;
        this.sem = sem;
        this.courseId = courseId;
    }
    public Instance(Integer year, Integer sem, Long courseId) {
        this.year = year;
        this.sem = sem;
        this.courseId = courseId;
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
    
    public Long getCourseId() {
        return courseId;
    }
    
    public void setCourseId(Long courseId) {    
        this.courseId = courseId;
    }
    
}
    