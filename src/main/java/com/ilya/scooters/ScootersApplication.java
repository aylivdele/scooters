package com.ilya.scooters;

import com.ilya.scooters.entities.Ride;
import com.ilya.scooters.entities.Scooter;
import com.ilya.scooters.entities.User;
import com.ilya.scooters.repos.RideRepos;
import com.ilya.scooters.repos.ScooterRepos;
import com.ilya.scooters.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScootersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScootersApplication.class, args);
    }

}
