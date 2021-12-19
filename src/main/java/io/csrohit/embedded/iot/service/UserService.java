package io.csrohit.embedded.iot.service;

import io.csrohit.embedded.iot.model.User;
import io.csrohit.embedded.iot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() ->new UsernameNotFoundException("User "+ username + " does not exist"));
        return user.get();
    }

    /**
     * Saves user to the database
     * @param user user object
     * @return saved user
     */
    public User save(User user){
        return userRepository.save(user);
    }

    /**
     *
     * @return list of users
     */
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
