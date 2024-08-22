package com.example.demo.instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstanceService {

    @Autowired
    private InstanceRepository instanceRepository;

    public List<Instance> findInstance(Integer year, Integer sem) {
        return instanceRepository.findByYearAndSem(year, sem);
    }

    public List<Instance> findInstanceByCourse(Integer year, Integer sem, Long courseId) {
        return instanceRepository.findByYearAndSemAndCourseId(year, sem, courseId);
    }

    public void addNewInstance(Instance instance) {
        instanceRepository.save(instance);
    }

    public void deleteInstance(Integer year, Integer sem, Long courseId) {
        instanceRepository.deleteInstance(year, sem, courseId);
    }
}
