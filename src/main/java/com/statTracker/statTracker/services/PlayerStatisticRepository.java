package com.statTracker.statTracker.services;

import com.statTracker.statTracker.models.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatisticRepository extends JpaRepository<PlayerStatistics, Long> {
}
