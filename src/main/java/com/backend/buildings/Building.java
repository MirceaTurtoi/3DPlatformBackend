package com.backend.buildings;

import com.backend.urls.Url;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Building")
@Table(
        name = "buildings",
        uniqueConstraints = {@UniqueConstraint(name = "building_path_unique", columnNames = "file_path")}
)
public class Building {

    @Id
    @SequenceGenerator(name = "building_sequence", sequenceName = "building_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_sequence")
    @Column(name = "building_id", updatable = false)
    private Long buildingId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "file_path", nullable = false)
    private String filePath;
    @Column(name = "x_coordinate", nullable = false)
    private Integer xCoordinate;
    @Column(name = "y_coordinate", nullable = false)
    private Integer yCoordinate;

    @OneToMany(mappedBy = "building")
    private Set<Url> url;

    public Building() {
    }

    public Building(String name, String filePath, Integer xCoordinate, Integer yCoordinate) {
        this.name = name;
        this.filePath = filePath;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }


    public void setUrl(Set<Url> url) {
        this.url = url;
    }

    public Set<Url> getUrl() {
        return this.url;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingId=" + buildingId +
                ", name='" + name + '\'' +
                ", filePath='" + filePath + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", url=" + url +
                '}';
    }
}
