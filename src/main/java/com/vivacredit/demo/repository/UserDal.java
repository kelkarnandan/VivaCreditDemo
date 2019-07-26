package com.vivacredit.demo.repository;

import java.util.List;

import com.vivacredit.demo.entity.User;

public interface UserDal {

    List<User> getAllUsers();

    User getUserById(String userId);

    User addNewUser(User user);

    Object getAllUserSettings(String userId);

    String getUserSetting(String userId, String key);

    String addUserSetting(String userId, String key, String value);
}
