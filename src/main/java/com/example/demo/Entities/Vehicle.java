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

/**
 *
 * @author estudiante.fit
 */
@Entity
@Table(name="vehicles")
public class Vehicle {
    
    @Id
    private String plate;
    
    @Column(name="owner_id")
    private int owner_id;
    @Column(name="model")
    private String model;
    @Column(name="color")
    private String color;
    @Column(name="type")
    private String type;
    @Column(name="seats")
    private int seats;
    
    public Vehicle(String plate, int owner_id, String model, String color, String type, int seats) {
        this.plate = plate;
        this.owner_id = owner_id;
        this.model = model;
        this.color = color;
        this.type = type;
        this.seats = seats;
    }
    
    public Vehicle() {}

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
