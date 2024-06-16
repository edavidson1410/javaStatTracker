package com.statTracker.statTracker.controllers;


import com.statTracker.statTracker.models.Team;
import com.statTracker.statTracker.services.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//test

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamRepository repository;

    @Autowired
    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/")
    List<Team> allTeams() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    Team findTeamById(@PathVariable Long team_id) {
        return repository.findById(team_id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/")
    Team newTeam(@RequestBody Team newTeam) {
        return repository.save(newTeam);
    }

}
