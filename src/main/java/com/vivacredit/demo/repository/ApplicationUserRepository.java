package com.vivacredit.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.vivacredit.demo.auth.ApplicationUser;

/**
 * ApplicationRepository
 *
 * @author nandan.kelkar
 */
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, ObjectId> {

    ApplicationUser findByUsername(String username);
}
