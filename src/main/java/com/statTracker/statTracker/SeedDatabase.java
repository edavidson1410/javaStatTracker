package com.statTracker.statTracker;

import com.statTracker.statTracker.models.Game;
import com.statTracker.statTracker.models.Player;
import com.statTracker.statTracker.models.PlayerStatistic;
import com.statTracker.statTracker.models.Team;
import com.statTracker.statTracker.services.GameRepository;
import com.statTracker.statTracker.services.PlayerRepository;
import com.statTracker.statTracker.services.PlayerStatisticRepository;
import com.statTracker.statTracker.services.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class SeedDatabase {

    private static final Logger log = LoggerFactory.getLogger(SeedDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PlayerRepository playerRepository, TeamRepository teamRepository, GameRepository gameRepository, PlayerStatisticRepository playerStatisticRepository) {

        Team bombers = new Team("St. Louis Bombers", "St. Louis, MO");
        Team belmontShore = new Team("Belmont Shore RFC", "Long Beach, CA");
        teamRepository.save(bombers);
        teamRepository.save(belmontShore);

        Team dbBombers = teamRepository.findById(1L).orElse(null);
        Team dbBelmont = teamRepository.findById(2L).orElse(null);

        Player player1 = new Player("Eric Davidson", "Jackson, MO", new Date(1992, 7, 26), dbBombers);
        Player player2 = new Player("Aidan Milne", "Motueka, New Zealand", new Date(1995, 4, 24), dbBombers);
        playerRepository.save(player1);
        playerRepository.save(player2);

        Game championship = new Game(new Date(2024, 5, 15), "Austin, TX", dbBombers, dbBelmont, 28, 27);
        gameRepository.save(championship);

        PlayerStatistic davidson1 = new PlayerStatistic(80, 0, 3, 4, 0, 0, player1);
        playerStatisticRepository.save(davidson1);

        return args -> {
            log.info("Preloading " + bombers.toString());
            log.info("Preloading " + player1.toString());
            log.info("Preloading " + player2.toString());
        };
    }
}