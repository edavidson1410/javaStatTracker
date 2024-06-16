package com.statTracker.statTracker.controllers;

import com.statTracker.statTracker.models.Player;
import com.statTracker.statTracker.services.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository repository;

    @Autowired
    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/")
    public List<Player> allPlayers() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Player getPlayerById(@PathVariable Long player_id) {
        return repository.findById(player_id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/")
    public Player newPlayer(@RequestBody Player newPlayer) {
        return repository.save(newPlayer);
    }
}
