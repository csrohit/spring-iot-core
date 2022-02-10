package io.csrohit.embedded.iot.service;

import io.csrohit.embedded.iot.model.Sensor;
import io.csrohit.embedded.iot.repository.SensorRepository;
import io.csrohit.embedded.iot.specification.SearchCriteria;
import io.csrohit.embedded.iot.specification.SensorSpecification;

import io.csrohit.embedded.iot.specification.SpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    public Object findCaption(long id, String fields){

    return sensorRepository.findAll();

    }

	public List<Sensor> findAllFilter(String filter) {
        if(filter != null && !filter.isEmpty()){
            String filters = filter.split(";")[0];
            int operatorIndex = filters.indexOf(">");
            String key = filters.substring(0, operatorIndex);
            String value = filters.substring(operatorIndex+1, filters.length());
            String operator = filters.substring(operatorIndex, operatorIndex+1);
            SearchCriteria criteria = new SearchCriteria(key, operator, value);
            SensorSpecification specification = new SensorSpecification(criteria);

            SpecificationBuilder<Sensor> builder = new SpecificationBuilder<>();
            builder.with("name", "==", "rohit");
            builder.with("age", ">", "30");
            builder.with("gender", "", "rohit");


            return sensorRepository.findAll(specification);
        }else{
            return sensorRepository.findAll();
        }

	}

}
