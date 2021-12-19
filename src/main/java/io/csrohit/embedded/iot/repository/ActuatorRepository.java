package io.csrohit.embedded.iot.repository;

import io.csrohit.embedded.iot.model.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActuatorRepository extends JpaRepository<Actuator, Long> {
}
