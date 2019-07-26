package com.vivacredit.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivacredit.demo.entity.User;
import com.vivacredit.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> allUser() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(User::getId).thenComparing(User::getName))
                .collect(Collectors.toList());
    }

    public void save(User user) {

        repository.save(user);
    }

}
