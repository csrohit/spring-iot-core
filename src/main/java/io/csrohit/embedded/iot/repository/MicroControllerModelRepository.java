package io.csrohit.embedded.iot.repository;

import io.csrohit.embedded.iot.model.MicroControllerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroControllerModelRepository extends JpaRepository<MicroControllerModel, Long> {
}