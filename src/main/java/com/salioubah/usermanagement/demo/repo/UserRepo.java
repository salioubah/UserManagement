package com.salioubah.usermanagement.demo.repo;

import com.salioubah.usermanagement.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface that extends MongoRepository to get access to all mongo CRUD methods
 */
@Repository
public interface UserRepo extends MongoRepository<User,String> {

    /**
     * Find a user by lastname
     * @param lastname, String to find
     * @return User that match the lastname
     */
    User findByLastname(String lastname);
}
