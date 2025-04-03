package com.ksnovaes.borajogar.repositories;

import com.ksnovaes.borajogar.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
}
