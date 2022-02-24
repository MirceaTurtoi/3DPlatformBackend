package com.platfrom3d.urls;

import com.platfrom3d.buildings.Building;

import javax.persistence.*;

@Entity(name ="Url")
@Table(name = "urls",
        uniqueConstraints = {@UniqueConstraint(name = "url_unique", columnNames = "url")}
)
public class Url {

    @Id
    @SequenceGenerator(name = "url_sequence", sequenceName = "url_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_sequence")
    @Column(name = "url_id", updatable = false)
    private Long urlId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Url() {
    }

    public Url(String name, String url) {
        this.name = name;
        this.url = url;
    }

//    STACK OVERFLOW IF PUBLIC
    private Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Long getUrlId() {
        return urlId;
    }

    public void setUrlId(Long urlId) {
        this.urlId = urlId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "urlId=" + urlId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
