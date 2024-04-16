package com.FarmCollector.farm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FarmCollector.farm.entity.Harvest;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {

    Optional<Harvest> findByCropId(Long cropId);

    Optional<Harvest> findByFarmId(Long farmId);
}