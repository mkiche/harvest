package com.FarmCollector.farm.errors;



public class HarvestNotFoundException extends RuntimeException {


    public HarvestNotFoundException(Long id) {
        super("Could not find harvest " + id);
    }
}