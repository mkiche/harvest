package com.FarmCollector.farm.controller;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.FarmCollector.farm.entity.Crop;
import com.FarmCollector.farm.entity.Farm;
import com.FarmCollector.farm.entity.Season;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.FarmCollector.farm.entity.Harvest;
import com.FarmCollector.farm.repository.HarvestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HarvestControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private HarvestRepository harvestRepository;

    @Test
    void testCreateNew() throws Exception {

        Harvest harvest = createHarvest();
        when(harvestRepository.save(harvest)).thenReturn(harvest);
        harvestRepository.save(harvest);

        mvc.perform(post("/harvest")
.content(new ObjectMapper().writeValueAsString(harvest))
.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
.andExpect(status().isCreated());
verify(harvestRepository, times(1)).save(harvest);

    }

    @Test
    void testGetByCropId() throws Exception {
    
        when(harvestRepository.findByCropId(1L)).thenReturn( Optional.of(createHarvest()));
 
        mvc.perform(MockMvcRequestBuilders
        .get("/harvest/farm/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(3)));

        verify(harvestRepository, times(1)).findByCropId(1L);
    }


    @Test
    void testGetByFarmId() throws Exception{
        when(harvestRepository.findByFarmId(1L)).thenReturn(Optional.of(createHarvest()));
        
 
        mvc.perform(MockMvcRequestBuilders
        .get("/harvest/farm/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(3)));

        verify(harvestRepository, times(1)).findByFarmId(1L);

    }

    @Test
    void testUpdateHarvest() {

    }


    private Harvest createHarvest(){
        List<Farm> farmList = new ArrayList<>();
        farmList.add(new Farm(1L, "farm1"));
        List<Crop> cropList = new ArrayList<>();
        cropList.add(new Crop(1L, "potatoe"));
        List<Season> seasonList = new ArrayList<>();
        seasonList.add(new Season(1L, "summer"));

        return new Harvest(1L,farmList,cropList,seasonList,2,10,9,2024);
    }


}
