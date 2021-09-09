package com.ilya.scooters.repos;

import com.ilya.scooters.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User, Long> {
    public User findByRidesId(Long id);
}
