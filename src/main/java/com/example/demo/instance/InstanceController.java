package com.example.demo.instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.course.Course;
import com.example.demo.course.CourseService;

import java.util.List;

@RestController
@RequestMapping("api/instances")
public class InstanceController {
    private final InstanceService instanceService;
    private final CourseService courseService;

    @Autowired
    public InstanceController(InstanceService instanceService, CourseService courseService) {
        this.instanceService = instanceService;
        this.courseService = courseService;
    }

    @PostMapping
    public void addInstance(@RequestBody InstanceDTO instanceDTO) {//DTO = data transfer object
        Course course = courseService.getCourseById(instanceDTO.getCourseId());
        Instance instance = new Instance(instanceDTO.getYear(),instanceDTO.getSem(),course);
        instanceService.addNewInstance(instance);
    }

    @GetMapping("/{year}/{sem}")
    public List<Instance> getInstance(
            @PathVariable Integer year,
            @PathVariable Integer sem) {
        return instanceService.findInstance(year, sem);

    }
    @GetMapping("/{year}/{sem}/{courseId}")
    public List<Instance> getInstanceWithCourse(
            @PathVariable Integer year,
            @PathVariable Integer sem,
            @PathVariable Long courseId) {
    //             try {
    //     Course course = courseService.getCourseById(courseId);
    //     List<Instance> instances = instanceService.findInstanceByCourse(year, sem, courseId);
    //     return ResponseEntity.ok(instances);
    // } catch (ResourceNotFoundException e) {
    //     return ResponseEntity.notFound().build();
    // }
            Course course = courseService.getCourseById(courseId);
        return instanceService.findInstanceByCourse(year, sem, courseId);

    }

    @DeleteMapping(path = "{year}/{sem}/{courseId}")
    public void deleteInstance(
            @PathVariable Integer year,
            @PathVariable Integer sem,
            @PathVariable Long courseId) {
        instanceService.deleteInstance(year, sem, courseId);
    }

}
