package org.launchcode.DropCatch.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class PinballMachines {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Ya gotta have this, at least....")
    private String machineName;

    private String manufacturerName;

    private String machineLocation;

    @NotNull(message= "You gotta save a score")
    @Range(min= 0)
    private Integer highScore;

    // Constructors
    public PinballMachines(int id, String machineName, String manufacturerName,
                         String machineLocation, Integer highScore) {
        this.id = id;
        this.machineName = machineName;
        this.manufacturerName = manufacturerName;
        this.machineLocation = machineLocation;
        this.highScore = highScore;
    }
    // For abstract entity
    public PinballMachines() {};



        //Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getMachineName() { return machineName; }

    public void setMachineName(String machineName) { this.machineName = machineName; }

    public String getManufacturerName() { return manufacturerName; }

    public void setManufacturerName(String manufacturerName) { this.manufacturerName = manufacturerName; }

    public String getMachineLocation() { return machineLocation; }

    public void setMachineLocation(String machineLocation) { this.machineLocation = machineLocation; }

    public Integer getHighScore() { return highScore; }

    public void setHighScore(Integer highScore) { this.highScore = highScore; }

    // toString override method
    @Override
    public String toString() {
        return "PinballMachines{" +
                "id=" + id +
                ", pinballMachine='" + machineName + '\'' +
                ", yearReleased=" +
//                yearReleased +
                '}';
    }
}
