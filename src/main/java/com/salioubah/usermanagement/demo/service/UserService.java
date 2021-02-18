package com.salioubah.usermanagement.demo.service;

import com.salioubah.usermanagement.demo.model.User;
import com.salioubah.usermanagement.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that implements UserRepo to write body of methods
 */
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    /**
     * Add user in database
     * @param user, user to insert
     * @return the user inserted
     */
    public User addUser(User user) {
        return userRepo.insert(user);
    }

    /**
     * Get user by lastname
     * @param lastname, field to find
     * @return a matched user
     */
    public User getUserByLastName(String lastname){
        return userRepo.findByLastname(lastname);
    }

    /**
     * Get users with pagination
     * @param page, number of page
     * @param size, size of page
     * @return a List of users with pagination
     */
    public Map<String, Object> getUsersByPage(int page, int size) {
        Map<String,Object> result = new HashMap<>();
        Pageable pageable = PageRequest.of(page,size);
        Page<User> userPage = userRepo.findAll(pageable);
        result.put("data", userPage.getContent());
        result.put("Total_of_pages", userPage.getTotalPages());
        result.put("Total_of_elements", userPage.getTotalElements());
        result.put("Current_page", userPage.getNumber());
        return result;
    }
}
