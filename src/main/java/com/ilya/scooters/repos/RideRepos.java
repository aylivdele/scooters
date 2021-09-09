package com.ilya.scooters.repos;

import com.ilya.scooters.entities.Ride;
import com.ilya.scooters.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepos extends JpaRepository<Ride, Long> {
}
