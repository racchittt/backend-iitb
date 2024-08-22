package com.example.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Long id){
        return courseService.getCourseById(id);
    }
    
    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseService.addNewCourse(course);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
    }
}

