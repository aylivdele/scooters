package com.ilya.scooters.services;

import com.ilya.scooters.entities.Scooter;
import com.ilya.scooters.repos.ScooterRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScooterService {


    private final ScooterRepos scooterRepos;

    public ScooterService(ScooterRepos scooterRepos) {
        this.scooterRepos = scooterRepos;
    }

    public List<Scooter> getAll(){
        return scooterRepos.findAll();
    }

    public Scooter getById(Long id){
        return scooterRepos.findById(id).orElseThrow(() -> new RuntimeException("No object with given id") );
    }

    public Scooter put(Scooter scooter){
        return scooterRepos.save(scooter);
    }

    public Scooter update(Scooter scooter){
        scooterRepos.findById(scooter.getId()).orElseThrow(() -> new RuntimeException("No object with given id") );
        return scooterRepos.save(scooter);
    }
}
