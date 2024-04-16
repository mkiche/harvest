package com.FarmCollector.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FarmCollector.farm.entity.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}

