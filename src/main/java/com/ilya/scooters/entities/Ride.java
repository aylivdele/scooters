package com.ilya.scooters.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    double distance;

    double startLongitude;
    double startLatitude;
    double finishLongitude;
    double finishLatitude;

    double cost;

    int duration;

    @ManyToOne
    @JoinColumn
    Scooter scooter;

    @ManyToOne
    @JoinColumn
    User user;

    public Ride() {
    }

    public Ride(double startLongitude, double startLatitude, Scooter scooter, User user) {
        this.startLongitude = startLongitude;
        this.startLatitude = startLatitude;
        this.scooter = scooter;
        this.user = user;
    }

    public Ride(double distance, double startLongitude, double startLatitude, double finishLongitude, double finishLatitude, double cost, int duration, Scooter scooter, User user) {
        this.distance = distance;
        this.startLongitude = startLongitude;
        this.startLatitude = startLatitude;
        this.finishLongitude = finishLongitude;
        this.finishLatitude = finishLatitude;
        this.cost = cost;
        this.duration = duration;
        this.scooter = scooter;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getFinishLongitude() {
        return finishLongitude;
    }

    public void setFinishLongitude(double finishLongitude) {
        this.finishLongitude = finishLongitude;
    }

    public double getFinishLatitude() {
        return finishLatitude;
    }

    public void setFinishLatitude(double finishLatitude) {
        this.finishLatitude = finishLatitude;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Scooter getScooter() {
        return scooter;
    }

    public void setScooter(Scooter scooter) {
        this.scooter = scooter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
