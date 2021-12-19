package io.csrohit.embedded.iot.repository;

import io.csrohit.embedded.iot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
