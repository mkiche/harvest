package com.FarmCollector.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FarmCollector.farm.entity.Crop;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
}

