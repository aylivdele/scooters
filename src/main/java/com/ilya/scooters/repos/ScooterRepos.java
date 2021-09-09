package com.ilya.scooters.repos;

import com.ilya.scooters.entities.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepos extends JpaRepository<Scooter, Long> {
}
