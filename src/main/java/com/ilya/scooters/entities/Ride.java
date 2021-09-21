package com.ilya.scooters.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ilya.scooters.objects.Route;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.LocalDateTime;

@TypeDefs(
        @TypeDef(name = "json-attr", typeClass = JsonBinaryType.class)
)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private long duration;

    private double distance;

    private double cost;

    private LocalDateTime startTime;

    private LocalDateTime finishTime;

    @ManyToOne
    @JoinColumn
    private Scooter scooter;

    @ManyToOne
    @JoinColumn
    private User user;

    @Type(type = "json-attr")
    private Route route;

    public Ride() {
    }

    public Ride(Scooter scooter, User user) {
        this.scooter = scooter;
        this.user = user;
    }

    public Ride(long duration, double distance, double cost, Scooter scooter, User user, Route route, LocalDateTime startTime, LocalDateTime finishTime) {
        this.duration = duration;
        this.distance = distance;
        this.cost = cost;
        this.scooter = scooter;
        this.user = user;
        this.route = route;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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
