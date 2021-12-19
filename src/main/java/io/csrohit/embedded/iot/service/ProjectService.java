package io.csrohit.embedded.iot.service;

import io.csrohit.embedded.iot.model.Actuator;
import io.csrohit.embedded.iot.model.Project;
import io.csrohit.embedded.iot.repository.ActuatorRepository;
import io.csrohit.embedded.iot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;


    public List<Project> findAll(){
        return repository.findAll();
    }


    public Project save(Project project){
        return repository.save(project);
    }

    public Optional<Project> findById(long id){
        return repository.findById(id);
    }
}
