package com.example.demo.course;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.instance.InstanceRepository;

@Service //adding a bean
public class CourseService {
	private final CourseRepository courseRepository;
	private final InstanceRepository instanceRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository, InstanceRepository instanceRepository) {
		this.courseRepository = courseRepository;
		this.instanceRepository = instanceRepository;
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

	public void deleteCourse(Long Id){
		boolean ex = courseRepository.existsById(Id);
		if ( !ex ){
			throw new IllegalStateException("Course with id " + Id + " non existent");
		}
		instanceRepository.deleteInstanceByCourse(Id);
		courseRepository.deleteById(Id);
	}
}


