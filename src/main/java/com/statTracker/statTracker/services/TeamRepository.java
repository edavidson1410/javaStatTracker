package com.statTracker.statTracker.services;

import com.statTracker.statTracker.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
