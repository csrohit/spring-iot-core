package io.csrohit.embedded.iot.service;

import io.csrohit.embedded.iot.model.Actuator;
import io.csrohit.embedded.iot.model.MicroController;
import io.csrohit.embedded.iot.repository.ActuatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActuatorService {


    @Autowired
    private ActuatorRepository repository;


    public List<Actuator> findAll(){
        return repository.findAll();
    }


    public Actuator save(Actuator actuator){
        return repository.save(actuator);
    }

    public Optional<Actuator> findById(long id){
        return repository.findById(id);
    }
}
