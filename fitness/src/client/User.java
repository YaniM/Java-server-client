package client;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private double firstWeight;
    private double currentWeight;
    private String username;
    private Machine machines;

    public User(double firstWeight, double currentWeight, String username, Machine machines) {
        this.firstWeight = firstWeight;
        this.currentWeight = currentWeight;
        this.username = username;
        this.machines = machines;
    }

    public User() {
    }

    public double getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(double firstWeight) {
        this.firstWeight = firstWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Machine getMachines() {
        return machines;
    }

    public void setMachines(Machine machines) {
        this.machines = machines;
    }
}
