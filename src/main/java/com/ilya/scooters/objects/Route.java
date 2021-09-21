package com.ilya.scooters.objects;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private List<RoutePoint> routePoints;

    public Route() {
        this.routePoints = new ArrayList<>();
    }

    public Route(List<RoutePoint> routePoints) {
        this.routePoints = routePoints;
    }

    public List<RoutePoint> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(List<RoutePoint> routePoints) {
        this.routePoints = routePoints;
    }
}
