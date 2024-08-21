package com.example.demo.course;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //adding a bean
public class CourseService {
	private final CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

    public List<Course> getCourses(){
		return courseRepository.findAll();
	}
}
