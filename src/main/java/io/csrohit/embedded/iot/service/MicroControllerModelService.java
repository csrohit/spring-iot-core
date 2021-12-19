package io.csrohit.embedded.iot.service;

import io.csrohit.embedded.iot.model.MicroControllerModel;
import io.csrohit.embedded.iot.repository.MicroControllerModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MicroControllerModelService {

    @Autowired
    private MicroControllerModelRepository microControllerModelRepository;

    public List<MicroControllerModel> findAll(){
        return microControllerModelRepository.findAll();
    }


    public MicroControllerModel save(MicroControllerModel model){
        return microControllerModelRepository.save(model);
    }

    public Optional<MicroControllerModel> findById(long id){
        return microControllerModelRepository.findById(id);
    }


}
