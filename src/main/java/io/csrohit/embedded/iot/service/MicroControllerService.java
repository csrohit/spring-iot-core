package io.csrohit.embedded.iot.service;

import io.csrohit.embedded.iot.model.MicroController;
import io.csrohit.embedded.iot.repository.MicroControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicroControllerService {

    @Autowired
    private MicroControllerRepository microControllerRepository;


    public List<MicroController> findAll(){
        return microControllerRepository.findAll();
    }


    public MicroController save(MicroController microController){
        return microControllerRepository.save(microController);
    }

    public Optional<MicroController> findById(long id){
        return microControllerRepository.findById(id);
    }

}
