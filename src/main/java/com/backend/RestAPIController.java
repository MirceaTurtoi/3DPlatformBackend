package com.backend;

import com.backend.buildings.Building;
import com.backend.urls.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "/api/v1")
public class RestAPIController {

    private final ServiceLayer ServiceLayer;

    @Autowired
    public RestAPIController(ServiceLayer ServiceLayer) {
        this.ServiceLayer = ServiceLayer;
    }

    @GetMapping(path = "/buildings/all")
    public List<Building> getBuildingsData(){
        return ServiceLayer.getBuildings();
    }

    @GetMapping(path = "/buildings")
    public List<Building> getBuildingsData(
            @RequestParam(value = "cameraX", defaultValue = "0") Integer cameraX,
            @RequestParam(value = "cameraY", defaultValue = "0") Integer cameraY,
            @RequestParam(value = "renderRadius", defaultValue = "0") Integer renderRadius){
        return ServiceLayer.getBuildingsInRadius(cameraX, cameraY, renderRadius);
    }

    @GetMapping(path = "/urls/all")
    public List<Url> getUrlsData(){
        return ServiceLayer.getUrls();
    }

    @PostMapping(path = "/building/{buildingId}/url")
    public void registerNewUrl(@PathVariable("buildingId") Long buildingId,
                                         @RequestBody Url url) {
        ServiceLayer.addNewUrl(buildingId, url);
    }

    @PostMapping(path = "/building")
    public void registerNewBuilding(@RequestBody() Building building){
        ServiceLayer.addNewBuilding(building);
    }

//    @DeleteMapping(path = "{studentId}")
//    public void deleteStudent(@PathVariable("studentId") Long studentId){
//        APIService.deleteStudent(studentId);
//    }
//
//    @PutMapping(path = "{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Long studentId,
//            @RequestParam(required = false) String firstName,
//            @RequestParam(required = false) String lastName){
//        APIService.updateStudent(studentId, firstName, lastName);
//    }

}
