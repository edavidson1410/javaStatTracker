package com.statTracker.statTracker.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Team {

    @Id @GeneratedValue
    private Long team_id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "player_id", fetch = FetchType.EAGER)
    private List<Player> players = new ArrayList<>();

    public Team() {}

    public Team(String name, String location) {
        this.name = name;
        this.location = location;
        this.players = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(team_id, team.team_id) && Objects.equals(name, team.name) && Objects.equals(location, team.location) && Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team_id, name, location, players);
    }

    @Override
    public String toString() {
        return "Team{" +
                "team_id=" + team_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", players=" + players +
                '}';
    }
}
