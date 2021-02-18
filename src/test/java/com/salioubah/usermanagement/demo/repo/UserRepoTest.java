package com.salioubah.usermanagement.demo.repo;

import com.salioubah.usermanagement.demo.model.Address;
import com.salioubah.usermanagement.demo.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    public void setUp() {
        // WE ALREADY HAVE DATA IN THE EMBEDDED MONGODB DUE TO "CommandLineRunner" INSIDE UserManagementApplication Java class
    }

    @Test
    public void whenFindByLastName_thenReturnUser() {
        User result = userRepo.findByLastname("DUPONT");
        assertEquals(result.getLastname(), "DUPONT", "Should return the same Last Name");
    }

}