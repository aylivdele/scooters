package com.ilya.scooters.services;

import com.ilya.scooters.components.Utils;
import com.ilya.scooters.entities.Ride;
import com.ilya.scooters.objects.Route;
import com.ilya.scooters.objects.RoutePoint;
import com.ilya.scooters.repos.RideRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    @Autowired
    RideRepos rideRepos;

    public List<Ride> getAll(){
        return rideRepos.findAll();
    }

    public Ride getById(Long id){
        return rideRepos.findById(id).orElseThrow(() -> new RuntimeException("No object with given id") );
    }

    public Ride put(Ride ride){
        return rideRepos.save(ride);
    }

    public Ride update(Ride ride){
        rideRepos.findById(ride.getId()).orElseThrow(() -> new RuntimeException("No object with given id") );
        return rideRepos.save(ride);
    }


    public void updateRouteAddPoint(long id, RoutePoint point) {
        Ride ride = rideRepos.findById(id).orElseThrow(() -> new RuntimeException("No object with given id") );
        Route route = ride.getRoute();
        route.getRoutePoints().add(point);
        ride.setDistance(Utils.countDistance(ride));
        ride.setDuration(Utils.countDuration(ride));
        ride.setCost(Utils.countCost(ride));
        rideRepos.save(ride);
    }


}