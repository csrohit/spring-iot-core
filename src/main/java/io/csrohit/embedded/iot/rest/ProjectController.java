package io.csrohit.embedded.iot.rest;

import io.csrohit.embedded.iot.model.Actuator;
import io.csrohit.embedded.iot.model.Project;
import io.csrohit.embedded.iot.model.User;
import io.csrohit.embedded.iot.service.ActuatorService;
import io.csrohit.embedded.iot.service.ProjectService;
import io.csrohit.embedded.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private ProjectService service;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Project project){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(project));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok().body(service.findAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") long id){
        try {
            return ResponseEntity.ok().body(service.findById(id).get());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
