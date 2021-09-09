package com.ilya.scooters.controllers;

import com.ilya.scooters.entities.User;
import com.ilya.scooters.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllRides(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getRideById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<User> putRide(@RequestBody User user){
        userService.put(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PatchMapping("/users")
    public ResponseEntity<String> updateRide(@RequestBody User user){
        userService.update(user);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/rides/{id}/user")
    public ResponseEntity<User> getUserByRide(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserByRideId(id), HttpStatus.OK);
    }

}
