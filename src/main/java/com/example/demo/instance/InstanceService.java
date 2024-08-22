package com.example.demo.instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstanceService {

    @Autowired
    private InstanceRepository instanceRepository;

    public List<Instance> findInstance(Integer year, Integer sem, Long courseId) {
        if (courseId != null) {
            return instanceRepository.findByYearAndSemAndCourseId(year, sem, courseId);
        } else {
            return instanceRepository.findByYearAndSem(year, sem);
        }
    }

    public void addNewInstance(Instance instance){
        instanceRepository.save(instance);
    }

    public void deleteInstance(Integer year, Integer sem, Long courseId){
        instanceRepository.deleteInstance(year, sem, courseId);
    }
}

