package com.salioubah.usermanagement.demo.service;

import com.salioubah.usermanagement.demo.model.Address;
import com.salioubah.usermanagement.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // WE ALREADY HAVE DATA IN THE EMBEDDED MONGODB DUE TO "CommandLineRunner" INSIDE UserManagementApplication Java class
    }

    @Test
    public void addUser() {
        User myUser = new User("Toto","TATA", "test@gmail.com", LocalDate.of(2000,2,12), new Address("22 rue de la paix","paris","france",75000),"ma bio décalée");
        User userSaved = userService.addUser(myUser);
        assertEquals(userSaved.getLastname(), "TATA", "Should return the same Last Name");
    }

    @Test
    public void getUserByPage() {
        Map<String,Object> result = userService.getUsersByPage(1,4);
        assertEquals(result.get("Current_page"), 1, "Should return the current page");
        assertEquals(result.get("Total_of_elements"), Long.valueOf(11), "Should return the total of elements");
        assertEquals(result.get("Total_of_pages"), 3, "Should return the total of pages");
    }

}