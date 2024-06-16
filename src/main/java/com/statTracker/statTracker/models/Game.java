package com.statTracker.statTracker.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private Long game_id;

    private Date date;

    private String location;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team home_team;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team away_team;

    private int home_score;

    private int away_score;

    public Game() {}

    public Game(Date date, String location, Team home_team, Team away_team, int home_score, int away_score) {
        this.date = date;
        this.location = location;
        this.home_team = home_team;
        this.away_team = away_team;
        this.home_score = home_score;
        this.away_score = away_score;
    }

    public Long getGame_id() {
        return game_id;
    }

    public int getAway_score() {
        return away_score;
    }

    public void setAway_score(int away_score) {
        this.away_score = away_score;
    }

    public int getHome_score() {
        return home_score;
    }

    public void setHome_score(int home_score) {
        this.home_score = home_score;
    }

    public Team getAway_team() {
        return away_team;
    }

    public void setAway_team(Team away_team) {
        this.away_team = away_team;
    }

    public Team getHome_team() {
        return home_team;
    }

    public void setHome_team(Team home_team) {
        this.home_team = home_team;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return home_score == game.home_score && away_score == game.away_score && Objects.equals(game_id, game.game_id) && Objects.equals(date, game.date) && Objects.equals(location, game.location) && Objects.equals(home_team, game.home_team) && Objects.equals(away_team, game.away_team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, date, location, home_team, away_team, home_score, away_score);
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id=" + game_id +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", home_team=" + home_team +
                ", away_team=" + away_team +
                ", home_score=" + home_score +
                ", away_score=" + away_score +
                '}';
    }
}
