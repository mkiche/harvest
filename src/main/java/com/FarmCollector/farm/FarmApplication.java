package com.FarmCollector.farm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.FarmCollector.farm.entity.Crop;
import com.FarmCollector.farm.entity.Farm;
import com.FarmCollector.farm.entity.Season;
import com.FarmCollector.farm.repository.CropRepository;
import com.FarmCollector.farm.repository.FarmRepository;
import com.FarmCollector.farm.repository.SeasonRepository;

@SpringBootApplication
public class FarmApplication implements CommandLineRunner{

	@Autowired
	SeasonRepository seasonRepository;

	@Autowired
	FarmRepository farmRepository;

	@Autowired
	CropRepository cropRepository;

	public static void main(String[] args) {
		SpringApplication.run(FarmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cropRepository.save(new Crop(1L,"corn"));
		cropRepository.save(new Crop(2L,"potatoes"));
		seasonRepository.save(new Season(1L, "winter"));
		farmRepository.save(new Farm(1L, "farm 1"));
		farmRepository.save(new Farm(2L, "farm 2"));
	}


}
