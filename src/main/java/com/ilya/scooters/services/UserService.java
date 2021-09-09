package com.ilya.scooters.services;

import com.ilya.scooters.entities.User;
import com.ilya.scooters.repos.UserRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepos userRepos;

    public UserService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    public List<User> getAll(){
        return userRepos.findAll();
    }

    public User getById(Long id){
        return userRepos.findById(id).orElseThrow(() -> new RuntimeException("No object with given id") );
    }

    public User put(User user){
        return userRepos.save(user);
    }

    public User update(User user){
        userRepos.findById(user.getId()).orElseThrow(() -> new RuntimeException("No object with given id") );
        return userRepos.save(user);
    }

    public User getUserByRideId(Long id){
        return userRepos.findByRidesId(id);
    }

}
