package com.statTracker.statTracker.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    private Long team_id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Player> players = new ArrayList<>();

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

    public Long getTeam_id() {
        return team_id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
