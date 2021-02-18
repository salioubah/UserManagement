package com.salioubah.usermanagement.demo;

import com.salioubah.usermanagement.demo.model.Address;
import com.salioubah.usermanagement.demo.model.User;
import com.salioubah.usermanagement.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to start application and implement CommandLineRunner to save somme data
 */
@SpringBootApplication
public class UserManagementApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;
    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        /**
         * List of users to save in the database embedded
         */
        List<User> listUsers = new ArrayList<>();

        listUsers.add(new User("Lucien","DUPONT", "test1@gmail.com", LocalDate.of(2000,2,12), new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("Marlene","SCHIAPPA", "test2@gmail.com", LocalDate.of(2000,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("Monica","BELUCCI", "test3@gmail.com", LocalDate.of(2000,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("Greta","THUNBERG", "test4@gmail.com", LocalDate.of(2001,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("Arsene","LUPIN", "test5@gmail.com", LocalDate.of(2000,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("Novak","DJOKOVIC", "test6@gmail.com", LocalDate.of(2002,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("John","DOE", "test7@gmail.com", LocalDate.of(2000,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("Emmanuel","MACRON", "test8@gmail.com", LocalDate.of(2000,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("Lucien","MORETTI", "test9@gmail.com", LocalDate.of(2000,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));
        listUsers.add(new User("Nathalie","IANETTA", "test10@gmail.com", LocalDate.of(2000,2,12),new Address("22 rue de la paix","paris","france",75000),"ma bio décalée"));

        userRepo.deleteAll();
        userRepo.insert(listUsers);
    }
}
