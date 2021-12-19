package io.csrohit.embedded.iot.repository;

import io.csrohit.embedded.iot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String user);

    @NonNull
    Optional<User> findByUsernameEquals(String username);

    Optional<User> findByFirstnameIgnoreCase(String firstname);
}
