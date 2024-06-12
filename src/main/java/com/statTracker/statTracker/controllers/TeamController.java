package com.statTracker.statTracker.controllers;


import com.statTracker.statTracker.models.Team;
import com.statTracker.statTracker.services.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//test

@RestController
public class TeamController {

    private final TeamRepository repository;

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/teams")
    List<Team> allTeams() {
        return repository.findAll();
    }

    @PostMapping("/teams")
    Team newTeam(@RequestBody Team newTeam) {
        return repository.save(newTeam);
    }

}
