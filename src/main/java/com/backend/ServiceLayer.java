package com.backend;

import com.backend.buildings.BuildingRepository;
import com.backend.urls.UrlRepository;
import com.backend.buildings.Building;
import com.backend.urls.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {

    private final BuildingRepository buildingRepository;
    private final UrlRepository urlRepository;

    @Autowired
    public ServiceLayer(BuildingRepository buildingRepository, UrlRepository urlRepository) {
        this.buildingRepository = buildingRepository;
        this.urlRepository = urlRepository;
    }

    public List<Building> getBuildingsInRadius(Integer cameraX, Integer cameraY, Integer renderRadius){
        return buildingRepository.findBuildingsWithinRadius(cameraX, cameraY, renderRadius);
    }

    public List<Building> getBuildings(){
        return buildingRepository.findAll();
    }

    public List<Url> getUrls(){
        return urlRepository.findAll();
    }

    public void addNewBuilding(Building building){
//        Optional<Building> buildingOptional = buildingRepository.findBuildingByPath(building.getFilePath());
//        if (buildingOptional.isPresent()){
//            throw new ApiRequestException("path already exists for given building");
//        } else {
            buildingRepository.save(building);
            System.out.println("Added new building");
//        }
    }

    public void addNewUrl(Long buildingId, Url url){
        if (existsBuilding(buildingId)) {
            Building building = buildingRepository.getById(buildingId);
            url.setBuilding(building);
            urlRepository.save(url);
        }
    }

    public boolean existsBuilding(Long studentId){
        boolean exists = buildingRepository.existsById(studentId);
        if (!exists) {
            System.out.println("Student with id " + studentId + " does not exists!");
        }
        return exists;
    }

//    public void deleteStudent(Long studentId){
//        if (existsBuilding(studentId)){
//            buildingRepository.deleteById(studentId);
//        }
//
//    }
//
//    @Transactional
//    public void updateStudent(Long studentId, String firstName, String lastName){
//        if (existsBuilding(studentId)){
//            Building student = buildingRepository.findById(studentId).get();
//            if (!student.getName().equals(firstName)) {
//                student.setName(firstName);
//            }
//            if (!student.getFilePath().equals(lastName)) {
//                student.setFilePath(lastName);
//            }
//        }
//    }

}
