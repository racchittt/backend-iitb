package com.example.demo.instance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.util.*;

@Repository
public interface InstanceRepository extends JpaRepository<Instance, Long>{
    @Query(value = "SELECT * FROM INSTANCE WHERE year = ?1 AND sem = ?2", nativeQuery = true)
    List<Instance> findByYearAndSem(Integer year, Integer sem);

    @Query(value = "SELECT * FROM INSTANCE WHERE year = ?1 AND sem = ?2 AND course_id = ?3", nativeQuery = true)
    List<Instance> findByYearAndSemAndCourseId(Integer year, Integer sem, Long course);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM INSTANCE WHERE year = ?1 AND sem = ?2 AND course_id = ?3", nativeQuery = true)
    int deleteInstance(Integer year, Integer sem, Long course);
   
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM INSTANCE WHERE course_id = ?1", nativeQuery = true)
    int deleteInstanceByCourse(Long course);
}
