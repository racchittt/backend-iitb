package com.example.demo.instance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface InstanceRepository extends JpaRepository<Instance, Long>{
    @Query(value = "SELECT * FROM INSTANCE WHERE year = ?1 AND sem = ?2", nativeQuery = true)
    List<Instance> findByYearAndSem(Integer year, Integer sem);

    @Query(value = "SELECT * FROM INSTANCE WHERE year = ?1 AND sem = ?2 AND course_id = ?3", nativeQuery = true)
    List<Instance> findByYearAndSemAndCourseId(Integer year, Integer sem, Long courseId);

    @Query(value = "DELETE FROM INSTANCE WHERE year = ?1 AND sem = ?2 AND course_id = ?3", nativeQuery = true)
    Instance deleteInstance(Integer year, Integer sem, Long courseId);
}
