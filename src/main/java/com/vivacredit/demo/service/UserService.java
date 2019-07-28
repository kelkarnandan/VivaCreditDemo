package com.vivacredit.demo.service;

import java.util.List;

import com.vivacredit.demo.entity.User;

public interface UserService {

    User findOne(String username);

    User save(User user);

    User findById(String id);

    void delete(String id);

    List<User> findAll();

}
