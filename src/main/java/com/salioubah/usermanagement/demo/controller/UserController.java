package com.salioubah.usermanagement.demo.controller;

import com.salioubah.usermanagement.demo.constants.Constants;
import com.salioubah.usermanagement.demo.exception.AddUserException;
import com.salioubah.usermanagement.demo.model.User;
import com.salioubah.usermanagement.demo.service.UserService;
import com.salioubah.usermanagement.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class UserController to define and expose different endpoints
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    Logger logger = Logger.getLogger(UserController.class.getName());

    /**
     * Use to get users with pagination
     * @param page, it use to set the page number, with default value = 0
     * @param size, it use to set the size of pages, with default value = 0
     * @return Map<String,Object> to handle response
     */
    @GetMapping("")
    public Map<String, Object> getUsersByPage(@RequestParam(name="page", defaultValue = "0") int page, @RequestParam(name="size", defaultValue = "5") int size){
        long time = System.currentTimeMillis();
        logger.log(Level.INFO,"Starting GetUsersByPage GET('/users')");

        Map<String,Object> result = userService.getUsersByPage(page,size);
        time = System.currentTimeMillis() - time ;
        logger.log(Level.INFO,"Ending GetUsersByPage GET('/users') in "+ time+ " ms");
        return result;
    }

    /**
     * Use to get Users by lastname
     * @param lastname, path variable to find users
     * @return User that match with lastname
     */
    @GetMapping("/search/{lastname}")
    public User getUserByLastName(@PathVariable String lastname){
        long time = System.currentTimeMillis();
        logger.log(Level.INFO,"Starting GetUsersByLastName GET('/users/search/{lastname}')");
        lastname = lastname.toUpperCase();
        User result = userService.getUserByLastName(lastname);
        time = System.currentTimeMillis() - time;
        logger.log(Level.INFO,"Ending GetUsersByLastName in GET('/users/search/{lastname}') "+ time + " ms");
        return result;
    }

    /**
     * Use to insert User
     * @param user, user to insert inside database
     * @return a ResponseEntity or throw an error
     */
    @PostMapping("")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
        long time = System.currentTimeMillis();
        logger.log(Level.INFO,"Starting addUser POST('/users')");
        if(!user.getAddress().getCountry().equalsIgnoreCase(Constants.COUNTRY_ALLOWED)){
            time = System.currentTimeMillis() - time;
            logger.log(Level.INFO,"Ending addUser in POST('/users') "+ time + " ms");
            throw new AddUserException("Country Not Allowed");
        }
        if(!CommonUtils.isMajor(user.getBirthdate())){
            time = System.currentTimeMillis() - time;
            logger.log(Level.INFO,"Ending addUser in POST('/users') "+ time + " ms");
            throw new AddUserException("Age lower than 18");
        }

        // set LastName to UpperCase
        user.setLastname(user.getLastname().toUpperCase());

        User userSaved = userService.addUser(user);
        Map<String,Object> result = new HashMap<>();
        result.put("userId", userSaved.getId());
        result.put("status", HttpStatus.CREATED);
        result.put("result", "SUCCESS");

        time = System.currentTimeMillis() - time;
        logger.log(Level.INFO,"Ending addUser in POST('/users') "+ time + " ms");
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

}
