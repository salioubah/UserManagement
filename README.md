# Spring Boot "REST API" User Management
***
This is a sample User Management with Spring Boot

### About Javadoc

You can launch the index.html file inside javadoc folder.

## How to Run
***
* Clone this repository
* Make sure you are using JDK 1.8 and Maven 3.x
* You can run the project by the main Class : 
```
      com.salioubah.usermanagement.demo.UserManagementApplication
```

Once the application runs you should see something like this :

```
2021-02-18 08:47:34.466  INFO 21528 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-02-18 08:47:34.471  INFO 21528 --- [  restartedMain] c.s.u.demo.UserManagementApplication     : Started UserManagementApplication in 5.555 seconds (JVM running for 6.122)
```

## About the DataBase

To test the application, I use a mongodb EmbeddedMongo to store data

### Create a User resource
***
```
POST localhost:8080/users
Accept: application/json
Content-Type: application/json

{
    "firstname": "Lucien",
    "lastname": "DUPONT",
    "email": "test1@gmail.com",
    "birthdate": "2000-02-12",
    "address": {
        "street": "22 rue de la paix",
        "city": "paris",
        "country": "france",
        "code": 75000
    },
    "bio": "ma bio décalée"
}

RESPONSE: HTTP 200 (OK)
```

### Retrieve a paginated list of users
***
```
@RequestParam(name="page", defaultValue = "0")
@RequestParam(name="size", defaultValue = "5")
GET localhost:8080/users

Response: HTTP 200
Content: paginated list of Users
{
    "Current_page": 0,
    "Total_of_elements": 10,
    "Total_of_pages": 3,
    "data": [
        {
            "id": "602e28dd35c3e65c72a35888",
            "firstname": "Marlene",
            "lastname": "SCHIAPPA",
            "email": "test2@gmail.com",
            "birthdate": "2000-02-12",
            "address": {
                "street": "22 rue de la paix",
                "city": "paris",
                "country": "france",
                "code": 75000
            },
            "bio": "ma bio décalée"
        }
        ...
    ]
}
```

### Retrieve a list of users by lastname
****
```
@PathVariable lastname
GET localhost:8080/users/serach{lastname}

Response: HTTP 200
Content: paginated list of Users
{
    "id": "602e28dd35c3e65c72a35887",
    "firstname": "Lucien",
    "lastname": "DUPONT",
    "email": "test1@gmail.com",
    "birthdate": "2000-02-12",
    "address": {
        "street": "22 rue de la paix",
        "city": "paris",
        "country": "france",
        "code": 75000
    },
    "bio": "ma bio décalée"
}
```

## ABOUT MODELS
***

#### User
```
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

```

#### Address
```
private String street;
private String city;
private String country;
private int code;
```



