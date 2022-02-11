package io.csrohit.embedded.iot.rest;

import io.csrohit.embedded.iot.model.Subject;
import io.csrohit.embedded.iot.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping
    public List<Subject> findAll(@RequestParam(name = "filter", required = false)String filter, @RequestParam(name = "fields", required = false)String fields){
        if(filter == null || filter.isEmpty()){
            return service.findAll();
        }else{
            return service.findAll(filter);
        }
    }
    @GetMapping("paged")
    public Page<Subject> findAllPaged(@RequestParam(name = "filter", required = false)String filter, @RequestParam(name = "fields", required = false)String fields){
        Pageable pageable = PageRequest.of(0, 10);
        if(filter == null || filter.isEmpty()){
            return service.findAll(pageable);
        }else{
            return service.findAll(filter, pageable);
        }
    }

    @PostMapping
    public Subject save(@RequestBody Subject subject){
        return service.save(subject);
    }
}
