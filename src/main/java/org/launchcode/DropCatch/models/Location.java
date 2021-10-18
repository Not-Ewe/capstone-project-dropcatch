package org.launchcode.DropCatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private int id;

    private String locationName;

    private String locationAddress;

    public Location(int id, String locationName, String locationAddress) {
        this.id = id;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
    }

    public Location() {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }
}
