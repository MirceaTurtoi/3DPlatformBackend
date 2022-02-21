package com.backend.buildings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    @Query("SELECT b FROM Building b WHERE " +
            "(((b.xCoordinate - :cameraX)*(b.xCoordinate - :cameraX)) + " +
            "((b.yCoordinate - :cameraY)*(b.yCoordinate - :cameraY))) <= " +
            ":renderRadius*:renderRadius")
    List<Building> findBuildingsWithinRadius(
            @Param("cameraX") Integer cameraX,
            @Param("cameraY") Integer cameraY,
            @Param("renderRadius") Integer renderRadius);
}
