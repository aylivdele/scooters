package com.ilya.scooters.controllers;


import com.ilya.scooters.entities.Scooter;
import com.ilya.scooters.services.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScooterController {

    @Autowired
    ScooterService scooterService;


    @GetMapping("/scooters")
    public ResponseEntity<List<Scooter>> getAllRides(){
        return new ResponseEntity<>(scooterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/scooters/{id}")
    public ResponseEntity<Scooter> getRideById(@PathVariable("id") Long id){
        return new ResponseEntity<>(scooterService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/scooters")
    public ResponseEntity<Scooter> putRide(@RequestBody Scooter scooter){
        scooterService.put(scooter);
        return new ResponseEntity<>(scooter, HttpStatus.CREATED);
    }

    @PatchMapping("/scooters")
    public ResponseEntity<String> updateRide(@RequestBody Scooter scooter){
        scooterService.update(scooter);
        return ResponseEntity.ok("Success");
    }

}
