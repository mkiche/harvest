package com.FarmCollector.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FarmCollector.farm.entity.Harvest;
import com.FarmCollector.farm.errors.HarvestNotFoundException;
import com.FarmCollector.farm.repository.HarvestRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class HarvestController {

    @Autowired
    HarvestRepository harvestRepository;

    @GetMapping("/harvest/farm/{farmId}")
    Harvest getByFarmId(@PathVariable Long farmId) {
        return harvestRepository.findByFarmId(farmId).get();
    }

    @GetMapping("/harvest/crop/{cropId}")
    Harvest getByCropId(@PathVariable Long cropId) {
        return harvestRepository.findByCropId(cropId).get();
    }

    @PostMapping("/harvest")
    Harvest createNew(@Valid @RequestBody Harvest harvest) {

        return harvestRepository.save(harvest);
    }

    @PatchMapping("/harvest/{id}/{harvestedProduct}")
    Harvest updateHarvest(@PathVariable Long id, @PathVariable int harvestedProduct ) {

        return harvestRepository.findById(id)
                .map(harvest -> {
                    harvest.setHarvestedProduct(harvestedProduct);
                    return harvestRepository.save(harvest);
                })
                .orElseThrow(() -> new HarvestNotFoundException(id));

    }

}