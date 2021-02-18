package com.salioubah.usermanagement.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Class that represent a User
 */
@Document
public class User {

    @Id
    private String id;
    @NotNull@Size(min = 2, message = "First Name should have 2 characters")
    private String firstname;
    @NotNull@Size(min = 2, message = "Last Name should have 2 characters")
    private String lastname;
    @Email(message = "It should be an email")
    private String email;
    @NotNull(message = "Birth Date must be filled")
    private LocalDate birthdate;
    @NotNull(message = "Address must be filled")
    private Address address;

    private String bio;

    /**
     * Constructor of a User with all parameters
     * @param firstname of user
     * @param lastname of user
     * @param email of user
     * @param birthdate of user
     * @param address of user
     * @param bio of user
     */
    public User(String firstname, String lastname, String email, LocalDate birthdate, Address address, String bio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.address = address;
        this.bio = bio;
    }

    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * A formatted User to return
     * @return String user
     */
    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", address=" + address +
                ", bio='" + bio + '\'' +
                '}';
    }
}
