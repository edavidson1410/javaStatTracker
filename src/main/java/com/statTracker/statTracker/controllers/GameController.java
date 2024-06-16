package com.statTracker.statTracker.controllers;

import com.statTracker.statTracker.models.Game;
import com.statTracker.statTracker.models.Player;
import com.statTracker.statTracker.services.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {

    private final GameRepository repository;

    @Autowired
    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/")
    public List<Game> allGames() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Game findGameById(@PathVariable Long game_id) {
        return repository.findById(game_id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/")
    public Game newGame(@RequestBody Game newGame) {
        return repository.save(newGame);
    }
}
