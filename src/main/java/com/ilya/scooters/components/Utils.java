package com.ilya.scooters.components;

import com.ilya.scooters.entities.Ride;
import com.ilya.scooters.objects.RoutePoint;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class Utils {

    private Utils() {
    }

    public static double countDistance(Ride ride) {
        List<RoutePoint> points = ride.getRoute().getRoutePoints();
        double distance = 0;
        for (int j = 1; j < points.size(); j++) {
            distance += countDistance(points.get(j - 1), points.get(j));
        }
        return distance;
    }

    private static double countDistance(RoutePoint point1, RoutePoint point2) {
        var radius = 6378.137; // Radius of earth in KM
        var dLat = point2.getLatitude() * Math.PI / 180 - point1.getLatitude() * Math.PI / 180;
        var dLon = point2.getLongitude() * Math.PI / 180 - point1.getLongitude() * Math.PI / 180;
        var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(point1.getLatitude() * Math.PI / 180) * Math.cos(point2.getLatitude() * Math.PI / 180) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        var d = radius * c;
        return d * 1000; //meters
    }

    public static double countCost(Ride ride){
        return ride.getDuration() * ride.getScooter().getModel().getCost();
    }

    public static long countDuration(Ride ride){
        LocalDateTime startTime = ride.getStartTime();
        LocalDateTime finishTime = ride.getFinishTime();
        if (finishTime == null) {
            List<RoutePoint> points = ride.getRoute().getRoutePoints();
                if (points.size() > 1)
                    finishTime = points.get(points.size() - 1).getTime();
                else return 0L;

        }
        return ChronoUnit.MINUTES.between(startTime,finishTime);
    }
}
