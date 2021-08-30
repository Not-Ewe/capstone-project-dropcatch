package org.launchcode.DropCatch.models;

public class PinballMachines {

    private int id;
    private String pinballMachine;
    private int yearReleased;

    // Constructors
    public PinballMachines(int id, String pinballMachine, int yearReleased) {
        this.id = id;
        this.pinballMachine = pinballMachine;
        this.yearReleased = yearReleased;
    }

    public PinballMachines() {};

    //Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getPinballMachine() { return pinballMachine; }

    public void setPinballMachine(String pinballMachine) { this.pinballMachine = pinballMachine; }

    public int getYearReleased() { return yearReleased; }

    public void setYearReleased(int yearReleased) { this.yearReleased = yearReleased; }

    // toString override method
    @Override
    public String toString() {
        return "PinballMachines{" +
                "id=" + id +
                ", pinballMachine='" + pinballMachine + '\'' +
                ", yearReleased=" + yearReleased +
                '}';
    }
}
