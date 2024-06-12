package com.statTracker.statTracker.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Team {

    private @Id @GeneratedValue Long id;
    private String name;
    private String location;

    Team() {}

    public Team(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation() {
        this.location = location;
    }
}
