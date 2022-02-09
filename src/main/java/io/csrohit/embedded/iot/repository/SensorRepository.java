package io.csrohit.embedded.iot.repository;

import io.csrohit.embedded.iot.model.Sensor;
import io.csrohit.embedded.iot.projection.IdCaptionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Query("Select s.caption, s.id,s.controller from Sensor s where s.id = ?1")
    public Object findSomething(long id, String caption);

}
