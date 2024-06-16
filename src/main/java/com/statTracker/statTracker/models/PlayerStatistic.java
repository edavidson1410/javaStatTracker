package com.statTracker.statTracker.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PlayerStatistic {

    @Id
    @GeneratedValue
    private Long player_game_id;

    private int minutes;

    private int tries;

    private int conversions_attempted;

    private int conversions_made;

    private int dropGoals_attempted;

    private int dropGoals_made;

    @ManyToOne(cascade = CascadeType.MERGE) @JoinColumn(name = "player_id")
    private Player player;

    public PlayerStatistic() { }

    public PlayerStatistic(int minutes, int tries, int conversions_attempted, int conversions_made, int dropGoals_attempted, int dropGoals_made, Player player) {
        this.minutes = minutes;
        this.tries = tries;
        this.conversions_attempted = conversions_attempted;
        this.conversions_made = conversions_made;
        this.dropGoals_attempted = dropGoals_attempted;
        this.dropGoals_made = dropGoals_made;
        this.player = player;
    }

    public Long getPlayer_game_id() {
        return player_game_id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public int getConversions_attempted() {
        return conversions_attempted;
    }

    public void setConversions_attempted(int conversions_attempted) {
        this.conversions_attempted = conversions_attempted;
    }

    public int getConversions_made() {
        return conversions_made;
    }

    public void setConversions_made(int conversions_made) {
        this.conversions_made = conversions_made;
    }

    public int getDropGoals_attempted() {
        return dropGoals_attempted;
    }

    public void setDropGoals_attempted(int dropGoals_attempted) {
        this.dropGoals_attempted = dropGoals_attempted;
    }

    public int getDropGoals_made() {
        return dropGoals_made;
    }

    public void setDropGoals_made(int dropGoals_made) {
        this.dropGoals_made = dropGoals_made;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStatistic that = (PlayerStatistic) o;
        return minutes == that.minutes && tries == that.tries && conversions_attempted == that.conversions_attempted && conversions_made == that.conversions_made && dropGoals_attempted == that.dropGoals_attempted && dropGoals_made == that.dropGoals_made && Objects.equals(player_game_id, that.player_game_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player_game_id, minutes, tries, conversions_attempted, conversions_made, dropGoals_attempted, dropGoals_made);
    }

    @Override
    public String toString() {
        return "PlayerGameStat{" +
                "player_game_id=" + player_game_id +
                ", minutes=" + minutes +
                ", tries=" + tries +
                ", conversions_attempted=" + conversions_attempted +
                ", conversions_made=" + conversions_made +
                ", dropGoals_attempted=" + dropGoals_attempted +
                ", dropGoals_made=" + dropGoals_made +
                '}';
    }
}
