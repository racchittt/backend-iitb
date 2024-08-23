package com.example.demo.instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiResponse;
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
    public ResponseEntity<ApiResponse<String>> addInstance(@RequestBody InstanceDTO instanceDTO) {//DTO = data transfer object
        Course course = courseService.getCourseById(instanceDTO.getCourseId());
        Instance instance = new Instance(instanceDTO.getYear(),instanceDTO.getSem(),course);
        instanceService.addNewInstance(instance);
        ApiResponse<String> response = new ApiResponse<>(null, "Instance added successfully", HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{year}/{sem}")
    public ResponseEntity<ApiResponse<List<Instance>>> getInstance(
            @PathVariable Integer year,
            @PathVariable Integer sem) {
            List<Instance> instances = instanceService.findInstance(year, sem);
            ApiResponse<List<Instance>> response = new ApiResponse<List<Instance>>(instances, "Instances fetched", HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{year}/{sem}/{courseId}")
    public ResponseEntity<ApiResponse<List<Instance>>> getInstanceWithCourse(
            @PathVariable Integer year,
            @PathVariable Integer sem,
            @PathVariable Long courseId) {
        List<Instance> instances =  instanceService.findInstanceByCourse(year, sem, courseId);
        ApiResponse<List<Instance>> response = new ApiResponse<List<Instance>>(instances, "Instances fetched", HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "{year}/{sem}/{courseId}")
    public ResponseEntity<ApiResponse<String>> deleteInstance(
            @PathVariable Integer year,
            @PathVariable Integer sem,
            @PathVariable Long courseId) {
            try {
                instanceService.deleteInstance(year, sem, courseId);
                ApiResponse<String> response = new ApiResponse<String>(null, "Instances deleted successfully", HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (IllegalStateException e) {
                ApiResponse<String> response = new ApiResponse<>(null, e.getMessage(), HttpStatus.BAD_REQUEST.value());
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
    }

}
