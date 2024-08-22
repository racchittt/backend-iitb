package com.example.demo.instance;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;


@Configuration
public class InstanceConfig {

    @Bean
    CommandLineRunner InstanceLineRunner(InstanceRepository repository, CourseRepository courseRepository){
        return args -> {
            Course courseAC = courseRepository.findByCourseId(1L)
                .orElseGet(() -> {
                    Course newCourse = new Course("Algorithms and Complexity", 1L, "Study of algorithms and their complexities.");
                    return courseRepository.save(newCourse);
            });
            Course courseDS = courseRepository.findByCourseId(2L)
                .orElseGet(() -> {
                    Course newCourse = new Course("Data Structures", 2L, "Study of data structures.");
                    return courseRepository.save(newCourse);
            });

            Course courseOS = courseRepository.findByCourseId(3L)
                .orElseGet(() -> {
                    Course newCourse = new Course("Operating Systems", 3L, "Study of operating systems.");
                    return courseRepository.save(newCourse);
            });
            Instance AC = new Instance(2024, 1, courseAC);
            Instance DS = new Instance(2024, 1, courseDS);
            Instance OS = new Instance(2022, 1, courseOS);

            repository.saveAll(List.of(AC,DS,OS));
        };
    }
}
