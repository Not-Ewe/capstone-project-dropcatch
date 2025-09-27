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

    private int machineId;

    private int userId;

    private String locationName;

    private String locationAddress;

        // Constructors
    public Location(int id, int machineId, int userId, String locationName,
                    String locationAddress) {
        this.id = id;
        this.machineId = machineId;
        this.userId = userId;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
    }

    public Location() {};


        // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        if (locationAddress.isBlank() || locationAddress == "") {
            this.locationAddress = "unknown";
        } else {
            this.locationAddress = locationAddress;
        }
    }
}
