package io.csrohit.embedded.iot.rest;

import io.csrohit.embedded.iot.model.MicroController;
import io.csrohit.embedded.iot.model.MicroControllerModel;
import io.csrohit.embedded.iot.service.MicroControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/uc")
public class MicroControllerController {
    @Autowired
    private MicroControllerService controllerService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody MicroController controller){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(controllerService.save(controller));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok().body(controllerService.findAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") long id){
        try {
            return ResponseEntity.ok().body(controllerService.findById(id).get());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
