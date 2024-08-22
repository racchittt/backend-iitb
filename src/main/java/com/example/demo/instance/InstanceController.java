package com.example.demo.instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/instances")
public class InstanceController {
    private final InstanceService instanceService;

    @Autowired
    public InstanceController(InstanceService instanceService) {
        this.instanceService = instanceService;
    }

    @PostMapping
    public void addInstance(@RequestBody Instance instance) {
        instanceService.addNewInstance(instance);
    }

    @GetMapping("/{year}/{sem}")
    public List<Instance> getInstance(
            @PathVariable Integer year,
            @PathVariable Integer sem,
            @RequestParam(required = false) Long courseId) {
        return instanceService.findInstance(year, sem, courseId);

    }
        @DeleteMapping(path = "{year}/{sem}/{courseId}")
        public void deleteInstance(
            @PathVariable Integer year, 
            @PathVariable Integer sem, 
            @PathVariable Long courseId){
                instanceService.deleteInstance(year,sem,courseId);
        }

}
