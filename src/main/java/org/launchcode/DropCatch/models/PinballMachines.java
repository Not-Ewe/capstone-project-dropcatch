package org.launchcode.DropCatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class PinballMachines {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Ya gotta have this, at least....")
    private String machineName;

    private String manufacturerName;

    private String machineLocation;


        // Constructors
    public PinballMachines(int id, String machineName, String manufacturerName,
                         String machineLocation) {
        this.id = id;
        this.machineName = machineName;
        this.manufacturerName = manufacturerName;
        this.machineLocation = machineLocation;
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

    public void setMachineLocation(String machineLocation) {
        if (machineLocation.isBlank() || machineLocation == "") {
            this.machineLocation = "unknown";
        } else {
            this.machineLocation = machineLocation;
        }
    }

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
