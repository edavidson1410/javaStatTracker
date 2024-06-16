package com.statTracker.statTracker.services;

import com.statTracker.statTracker.models.PlayerStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatisticRepository extends JpaRepository<PlayerStatistic, Long> {
}
