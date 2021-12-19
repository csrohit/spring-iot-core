package io.csrohit.embedded.iot.service;

import io.csrohit.embedded.iot.model.Sensor;
import io.csrohit.embedded.iot.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> findAll(){
        return this.sensorRepository.findAll();
    }

    public Page<Sensor> findALl(Pageable pageable){
        return sensorRepository.findAll(pageable);
    }

    public Sensor save(Sensor sensor){
        return sensorRepository.save(sensor);
    }

    public Optional<Sensor> findById(Long id){
        return this.sensorRepository.findById(id);
    }


}
