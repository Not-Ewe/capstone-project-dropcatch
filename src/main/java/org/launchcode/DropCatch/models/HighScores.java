package org.launchcode.DropCatch.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class HighScores {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message= "You gotta save a score")
    @Range(min= 0)
    private Integer highScore;

    private int machineId;

    private int userId;

    // Player Score Constructor
    public HighScores(int id, Integer highScore, int machineId, int userId) {
        this.id = id;
        this.highScore = highScore;
        this.machineId = machineId;
        this.userId = userId;
    }

    public HighScores() {
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    public void setMachineId(int machineId) {
        this.machineId= machineId;
    }

    public int setUserId(int userId) {
        this.userId = userId;
        return userId;
    }
}
