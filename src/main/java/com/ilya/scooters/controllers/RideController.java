package com.ilya.scooters.controllers;

import com.ilya.scooters.entities.Ride;
import com.ilya.scooters.entities.Scooter;
import com.ilya.scooters.entities.User;
import com.ilya.scooters.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RideController {

    @Autowired
    RideService rideService;


    @GetMapping("/rides")
    public ResponseEntity<List<Ride>> getAllRides(){
        return new ResponseEntity<>(rideService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rides/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable("id") Long id){
        return new ResponseEntity<>(rideService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/rides")
    public ResponseEntity<Ride> putRide(@RequestBody Ride ride){
        rideService.put(ride);
        return new ResponseEntity<>(ride, HttpStatus.CREATED);
    }

    @PatchMapping("/rides")
    public ResponseEntity<String> updateRide(@RequestBody Ride ride){
        rideService.update(ride);
        return ResponseEntity.ok("Success");
    }



}
