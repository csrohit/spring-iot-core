package io.csrohit.embedded.iot.rest;

import io.csrohit.embedded.iot.model.Actuator;
import io.csrohit.embedded.iot.service.ActuatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/actuator")
public class ActuatorController {
    @Autowired
    private ActuatorService service;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Actuator actuator){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(actuator));
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
