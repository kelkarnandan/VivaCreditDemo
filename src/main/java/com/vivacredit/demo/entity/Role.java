package com.vivacredit.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Field("description")
    private String description;

    /**
     * @return The id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id The id to set
     */
    public void setId(long id) {
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
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}