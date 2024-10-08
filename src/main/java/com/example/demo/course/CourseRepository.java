package com.example.demo.course;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
// public interface CourseRepository extends JpaRepository <T (type), Long (id)>{}
public interface CourseRepository extends JpaRepository <Course, Long>{
    @Query(value = "SELECT * FROM course WHERE id=?1", nativeQuery=true)
    Optional<Course> findByCourseId(Long Id);
}
