package com.example.demo.course;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {
    @Bean
    CommandLineRunner CourseLineRunner(CourseRepository repository) {
        return args -> {
            Course CA = new Course(
                    "Introduction to Computer Architecture",
                    "CS 102",
                    "This course provides a basic introduction to the architecture and algorithms of computer systems");
            Course DSA = new Course(
                    "Data Structures and Algorithms",
                    "CS 201",
                    "This course covers fundamental data structures and algorithms with a focus on efficiency and performance");
            repository.saveAll(List.of(CA,DSA));

        };
    }
}
