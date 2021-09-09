package com.ilya.scooters.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Scooter {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    String model;

    double charge;


    @OneToMany(targetEntity = Ride.class, mappedBy = "scooter")
    List<Ride> rides;

    public Scooter() {
    }

    public Scooter(String model, double charge) {
        this.model = model;
        this.charge = charge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
