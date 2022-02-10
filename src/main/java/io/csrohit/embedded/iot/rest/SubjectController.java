package io.csrohit.embedded.iot.rest;

import io.csrohit.embedded.iot.model.Subject;
import io.csrohit.embedded.iot.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping
    public List<Subject> findAll(@RequestParam(name = "filter", required = false)String filter){
        if(filter == null || filter.isEmpty()){
            return service.findAll();
        }else{
            return service.findAll(filter);
        }
    }

    @PostMapping
    public Subject save(@RequestBody Subject subject){
        return service.save(subject);
    }
}
