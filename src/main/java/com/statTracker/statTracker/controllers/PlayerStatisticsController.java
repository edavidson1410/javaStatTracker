package com.statTracker.statTracker.controllers;

import com.statTracker.statTracker.models.PlayerStatistic;
import com.statTracker.statTracker.services.PlayerStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playerstats")
public class PlayerStatisticsController {

    private final PlayerStatisticRepository repository;

    @Autowired
    public PlayerStatisticsController(PlayerStatisticRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/")
    List<PlayerStatistic> allPlayerStatistics() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    PlayerStatistic getPlayerStatById(@PathVariable Long playerStatistic_Id) {
        return repository.findById(playerStatistic_Id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/")
    PlayerStatistic newPlayerStatistics(@RequestBody PlayerStatistic newPlayerStatistics) {
        return repository.save(newPlayerStatistics);
    }
}
