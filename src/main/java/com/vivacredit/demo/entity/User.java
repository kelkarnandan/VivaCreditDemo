package com.vivacredit.demo.entity;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Indexed(unique = true)
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    private String email;
    @Field("phonenumber")
    private String phoneNumber;

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "ROLE", joinColumns = {
    // @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param name The firstName to set
     */
    public void setFirstName(String name) {
        firstName = name;
    }

    /**
     * @return The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber The phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return The roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles The roles to set
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
