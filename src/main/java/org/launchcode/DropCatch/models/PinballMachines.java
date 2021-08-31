package org.launchcode.DropCatch.models;

public class PinballMachines {

    private int id;
    private String pinballMachine;
    private String manufacturer;
    private int yearReleased;
    private int highScore;

    // Constructors
    public PinballMachines(int id, String pinballMachine, String manufacturer, int yearReleased,
                           int highScore) {
        this.id = id;
        this.pinballMachine = pinballMachine;
        this.manufacturer = manufacturer;
        this.yearReleased = yearReleased;
        this.highScore = highScore;
    }
    // For abstract entity
    public PinballMachines() {};

    //Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getPinballMachine() { return pinballMachine; }

    public void setPinballMachine(String pinballMachine) { this.pinballMachine = pinballMachine; }

    public String getManufacturer() { return manufacturer; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getYearReleased() { return yearReleased; }

    public void setYearReleased(int yearReleased) { this.yearReleased = yearReleased; }

    public int getHighScore() { return highScore; }

    public void setHighScore(int highScore) { this.highScore = highScore; }

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
