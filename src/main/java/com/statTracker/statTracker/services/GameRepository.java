package com.statTracker.statTracker.services;

import com.statTracker.statTracker.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
