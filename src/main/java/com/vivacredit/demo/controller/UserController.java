package com.vivacredit.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivacredit.demo.entity.User;
import com.vivacredit.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

    @GetMapping(value = "/")
    @Produces("application/json")
    @Secured({ "ROLE_ADMIN" })
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public User getUserById(@PathVariable("id") String id) {
        LOG.info("getting user.");
        return userService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Secured({ "ROLE_USER" })
    public void updateUserById(@PathVariable("id") String id, @Valid @RequestBody User user) {
        LOG.info("Updating user.");
        user.setId(id);
        userService.save(user);
    }

    @PostMapping(value = "/create")
    @Produces("application/json")
    public User addNewUser(@RequestBody User user) {
        LOG.info("Saving user.");
        return userService.save(user);
    }

    @DeleteMapping(value = "/{id}")
    @Secured({ "ROLE_ADMIN" })
    public void deleteUser(@PathVariable String id) {
        LOG.info("Deleting user.");
        User user = userService.findById(id);
        if (user != null) {
            userService.delete(user.getId());
        }
    }
}
