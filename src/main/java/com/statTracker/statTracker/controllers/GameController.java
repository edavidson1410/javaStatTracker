package com.statTracker.statTracker.controllers;

import com.statTracker.statTracker.models.Game;
import com.statTracker.statTracker.models.Player;
import com.statTracker.statTracker.services.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class GameController {

    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/games")
    List<Game> allGames() {
        return repository.findAll();
    }

    @PostMapping("/games")
    Game newGame(@RequestBody Game newGame) {
        return repository.save(newGame);
    }
}
