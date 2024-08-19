package com.example.demo.course;
import java.util.List;
public class CourseService {
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
