package io.csrohit.embedded.iot.repository;

import io.csrohit.embedded.iot.model.MicroController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroControllerRepository extends JpaRepository<MicroController, Long> {
}
