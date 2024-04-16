package com.FarmCollector.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FarmCollector.farm.entity.Farm;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
}

