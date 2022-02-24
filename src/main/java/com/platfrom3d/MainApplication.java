package com.platfrom3d;

import com.platfrom3d.buildings.BuildingRepository;
import com.platfrom3d.buildings.Building;
import com.platfrom3d.urls.Url;
import com.platfrom3d.urls.UrlRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	//Adds values to tables in database
	@Bean
	CommandLineRunner commandLineRunner(BuildingRepository buildingRepository, UrlRepository urlRepository){
		return arg -> {
			Building casa = new Building(
					"Name test",
					"File path test",
					10,
					10
			);
			Building hotel = new Building(
					"Another name test",
					"Another file path test",
					10,
					15
			);

			Url urlCasa = new Url(
					"UrlName",
					"UrlData"
			);

			Url urlCasa2 = new Url(
					"UrlName2",
					"UrlData2"
			);

			urlCasa.setBuilding(casa);
			urlCasa2.setBuilding(casa);
			buildingRepository.saveAll(List.of(casa,hotel));
			urlRepository.saveAll(List.of(urlCasa, urlCasa2));
		};
	}

}
