package com.salioubah.usermanagement.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salioubah.usermanagement.demo.model.Address;
import com.salioubah.usermanagement.demo.model.User;
import com.salioubah.usermanagement.demo.repo.UserRepo;
import com.salioubah.usermanagement.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        // WE ALREADY HAVE DATA IN THE EMBEDDED MONGODB DUE TO "CommandLineRunner" INSIDE UserManagementApplication Java class
        this.mvc =
                MockMvcBuilders
                        .webAppContextSetup(ctx)
                        .defaultRequest(get("/*"))
                        .defaultRequest(post("/*"))
                        .build();

    }

    @Test
    public void getUsersByPage() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getUsersByLastName() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/users/search/{lastname}", "DUPONT")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("DUPONT"));
    }

    @Test
    public void addUser() throws Exception
    {
        User myUser = new User("Toto","TATA2", "test@gmail.com", LocalDate.of(2000,2,12), new Address("22 rue de la paix","paris","france",75000),"ma bio décalée");

        mvc.perform(MockMvcRequestBuilders.post("/users")
                .content(asJsonString(myUser))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}