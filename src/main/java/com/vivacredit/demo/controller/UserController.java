package com.vivacredit.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivacredit.demo.entity.Role;
import com.vivacredit.demo.entity.User;
import com.vivacredit.demo.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        LOG.info("Saving user.");
        if (user.getRoles() == null) {
            user.setRoles(defaultRole());
        }
        userService.save(user);
    }

    @GetMapping(value = "/")
    @Produces("application/json")
    @Secured({ ROLE_ADMIN })
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @Produces("application/json")
    @Secured({ ROLE_ADMIN, ROLE_USER })
    public User getUserById(@PathVariable("id") String id) {
        LOG.info("getting user.");
        return userService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Secured({ ROLE_ADMIN, ROLE_USER })
    public void updateUserById(@PathVariable("id") String id, @Valid @RequestBody User user) {
        LOG.info("Updating user.");
        user.setId(id);
        userService.save(user);
    }

    @DeleteMapping(value = "/{id}")
    @Secured({ ROLE_ADMIN })
    public void deleteUser(@PathVariable String id) {
        LOG.info("Deleting user.");
        User user = userService.findById(id);
        if (user != null) {
            userService.delete(user.getId());
        }
    }

    private Set<Role> defaultRole() {
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(2);
        role.setName("USER");
        role.setDescription("User Role");

        roles.add(role);

        return roles;
    }
}
