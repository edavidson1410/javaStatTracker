package com.statTracker.statTracker.controllers;

import com.statTracker.statTracker.models.Player;
import com.statTracker.statTracker.services.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/players")
    List<Player> allPlayers() {
        return repository.findAll();
    }

    @PostMapping("/players")
    Player newPlayer(@RequestBody Player newPlayer) {
        return repository.save(newPlayer);
    }
}
