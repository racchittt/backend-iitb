package com.example.demo.course;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    @GetMapping
	public List<Course> getCourses(){
		return List.of(
			new Course(
				1L,
				"Introduction to Computer Architecture",
				"CS 102",
				"This course provides a basic introduction to the architecture and algorithms of computer systems"
			)
		);
	}
}
