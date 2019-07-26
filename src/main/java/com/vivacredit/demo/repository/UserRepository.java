package com.vivacredit.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vivacredit.demo.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findFirstByName(String name);

}
