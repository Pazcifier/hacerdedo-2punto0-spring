/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author estudiante.fit
 */

@Entity
@Table(name="users")
public class User {
    @Id
    private int id;
    
    @Column(name="name")
    private String name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="phone")
    private String phone;
    @Column(name="password")
    private String password;
    @Column(name="type")
    private String type = "Passenger";
    @Column(name="rating")
    private double rating = 0.0;
    
    public User(int id, String name, String last_name, String phone, String password) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.phone = phone;
        this.password = password;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    
}
