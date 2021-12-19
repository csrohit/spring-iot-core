package io.csrohit.embedded.iot.rest;

import io.csrohit.embedded.iot.model.MicroControllerModel;
import io.csrohit.embedded.iot.service.MicroControllerModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ucm")
public class MicroControllerModelController {

    @Autowired
    private MicroControllerModelService microControllerModelService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody MicroControllerModel model){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(microControllerModelService.save(model));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok().body(microControllerModelService.findAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") long id){
        try {
            return ResponseEntity.ok().body(microControllerModelService.findById(id).get());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
