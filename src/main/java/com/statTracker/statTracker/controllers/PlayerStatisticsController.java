package com.statTracker.statTracker.controllers;

import com.statTracker.statTracker.models.PlayerStatistic;
import com.statTracker.statTracker.services.PlayerStatisticRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerStatisticsController {

    private final PlayerStatisticRepository repository;

    public PlayerStatisticsController(PlayerStatisticRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/playerstats")
    List<PlayerStatistic> allPlayers() {
        return repository.findAll();
    }

    @PostMapping("/playerstats")
    PlayerStatistic newPlayerStatistics(@RequestBody PlayerStatistic newPlayerStatistics) {
        return repository.save(newPlayerStatistics);
    }
}
