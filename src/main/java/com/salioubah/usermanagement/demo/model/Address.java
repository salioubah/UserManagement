package com.salioubah.usermanagement.demo.model;

/**
 * Class that represent a format of address
 */
public class Address {

    private String street;
    private String city;
    private String country;
    private int code;

    /**
     * Constructor with all parameters
     * @param street of Address
     * @param city of Address
     * @param country of Address
     * @param code of Address
     */
    public Address(String street, String city, String country, int code) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.code = code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * A formatted Address to return
     * @return String Address
     */
    @Override
    public String toString() {
        return "{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", code=" + code +
                '}';
    }
}
