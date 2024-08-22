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

	public Course getCourseById(Long id){
		return courseRepository.findById(id).orElseThrow(() -> new IllegalStateException("Course with ID " + id + " not found"));
	}

	public void addNewCourse(Course course){
		courseRepository.save(course);
	}

	public void deleteCourse(Long courseId){
		boolean ex = courseRepository.existsById(courseId);
		if ( !ex ){
			throw new IllegalStateException("Course with id " + courseId + " non existent");
		}
		courseRepository.deleteById(courseId);
	}
}


