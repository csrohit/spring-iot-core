package io.csrohit.embedded.iot.rest;

import io.csrohit.embedded.iot.model.Sensor;
import io.csrohit.embedded.iot.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Sensor sensor) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(sensorService.save(sensor));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok().body(sensorService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("test")
    public ResponseEntity<?> findCaption(@RequestParam(value = "filter", required = false)String filter){
        try{
            return ResponseEntity.ok().body(sensorService.findAllFilter(filter));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

//    @GetMapping
//    public ResponseEntity<?> findAll(
//            @RequestParam(name = "page") short page,
//            @RequestParam(name = "size") short size,
//            @RequestParam(name = "search", required = false, defaultValue = "") String search
//            ) {
//        try {
//            Pageable pageable = PageRequest.of(page, size);
//            return ResponseEntity.ok().body(sensorService.findALl(pageable));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

}
