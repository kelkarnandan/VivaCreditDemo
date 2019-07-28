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
    private String name;
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
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
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
