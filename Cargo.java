package PortManagementSystem;

import java.util.Stack;

public class Cargo {
    private String cargoType;
    private double weight;
    private String destination;
    private String origin;
   
    
    public Cargo() {
    	this.cargoType = null;
		this.weight = 0.0;
		this.destination = null;
		this.origin = null;
	}

	public Cargo(String cargoType, double weight, String destination, String origin) {
		this.cargoType = cargoType;
		this.weight = weight;
		this.destination = destination;
		this.origin = origin;
	}

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "\nCargo Type: " + cargoType + "\nWeight: " + weight + "\nDestination: " + destination + "\nOrigin: " + origin;
    }
}

