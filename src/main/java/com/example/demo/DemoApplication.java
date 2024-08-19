package com.example.demo;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.course.Course;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/") //Get Request at route "/"
	public List<Course> hello(){
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
