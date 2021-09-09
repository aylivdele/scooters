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

    @Autowired
    RideRepos rideRepos;

    @Autowired
    ScooterRepos scooterRepos;

    @Autowired
    UserRepos userRepos;


    public String addSomeObjects(){
        User ilya = new User("Ilya");
        User sasha = new User("Sasha");
        userRepos.save(ilya);
        userRepos.save(sasha);

        Scooter scooter1 = new Scooter("SuperScooter3000", 100);
        Scooter scooter2 = new Scooter("Lightning", 95);

        scooterRepos.save(scooter1);
        scooterRepos.save(scooter2);

        Ride ride1 = new Ride(999999,123457.12, 654322.45, 123456.12, 654321.43, 6666,1234, scooter1, sasha);
        Ride ride2 = new Ride(123,111111.11, 222222.22, 555555.55, 666666.66, 6666,777, scooter2, ilya);

        rideRepos.save(ride1);
        rideRepos.save(ride2);

        return "";
    }

}
