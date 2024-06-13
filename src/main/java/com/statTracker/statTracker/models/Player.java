package com.statTracker.statTracker.models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id @GeneratedValue
    private Long player_id;

    private String name;

    private String hometown;

    private Date birthdate;

    @ManyToOne @JoinColumn(name = "team_id")
    private Team team;

    Player() {}

    public Player(String name, String hometown, Date birthdate, Team team) {
        this.name = name;
        this.hometown = hometown;
        this.birthdate = birthdate;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPlayerId() {
        return player_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(player_id, player.player_id) && Objects.equals(name, player.name) && Objects.equals(hometown, player.hometown) && Objects.equals(birthdate, player.birthdate) && Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player_id, name, hometown, birthdate, team);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + player_id +
                ", name='" + name + '\'' +
                ", hometown='" + hometown + '\'' +
                ", birthdate=" + birthdate +
                ", team='" + team + '\'' +
                '}';
    }
}
