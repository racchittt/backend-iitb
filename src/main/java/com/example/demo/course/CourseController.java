package com.example.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiResponse;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getCourses(){
        List<Course> courses = courseService.getCourses();
        ApiResponse<List<Course>> response = new ApiResponse<List<Course>>(courses, "Courses fetched successfully", HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("id") Long id){
        Course course = courseService.getCourseById(id);
        ApiResponse<Course> response = new ApiResponse<Course>(course, "Course fetched ", HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse<String>> addCourse(@RequestBody Course course){
        courseService.addNewCourse(course);
        ApiResponse<String> response = new ApiResponse<String>(null, "Course added successfully", HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable("id") Long id){
        try{
            courseService.deleteCourse(id);
            ApiResponse<String> response = new ApiResponse<>(null,"Course deleted successfully", HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (IllegalStateException e){
            ApiResponse<String> response = new ApiResponse<>(null, e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}

