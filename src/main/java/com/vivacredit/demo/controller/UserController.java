package com.vivacredit.demo.controller;

import com.vivacredit.demo.auth.ApplicationUser;
import com.vivacredit.demo.entity.User;
import com.vivacredit.demo.repository.ApplicationUserRepository;
import com.vivacredit.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //Skipping Service layer

    @Autowired
    private UserRepository repository;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    @GetMapping(value = "/")
    @Produces("application/json")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") String id) {
        LOG.info("getting user.");
        return repository.findById(id).orElse(null);
    }

    @PutMapping(value = "/{id}")
    public void updateUserById(@PathVariable("id") String id, @Valid @RequestBody User user) {
        LOG.info("Updating user.");
        user.setId(id);
        repository.save(user);
    }

    @PostMapping(value = "/create")
    @Produces("application/json")
    public User addNewUsers(@RequestBody User user) {
        LOG.info("Saving user.");
        return repository.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBoss(@PathVariable String id) {
        LOG.info("Deleting user.");
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            repository.delete(optionalUser.get());
        }
    }
}
