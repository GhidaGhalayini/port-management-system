package PortManagementSystem;

import java.util.Stack;

public class Ship {
    private int id;
    private int capacity;
    private int currentNbOfCargo;
    private String arrivalTime;
    private Cargo cargoDetails;
    private Stack<Cargo> shipStorage;
    private String requireFueling;
    private String requireMaintenance;

    public Ship(int id, int capacity, String arrivalTime, String requireFueling, String requireMaintenance, Cargo cargoDetails) {
        this.id = id;
        this.capacity = capacity;
        this.arrivalTime = arrivalTime;
        this.cargoDetails = cargoDetails ;
        shipStorage = new Stack<>();
        this.requireFueling = requireFueling;
        this.requireMaintenance = requireMaintenance;
    }
    public Ship(int id, int capacity, String arrivalTime, String requireFueling, String requireMaintenance) {
        this.id = id;
        this.capacity = capacity;
        this.arrivalTime = arrivalTime;
        shipStorage = new Stack<>();
        this.requireFueling = requireFueling;
        this.requireMaintenance = requireMaintenance;
    }
    
    
	public int getId() {
		return id;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public int getCurrentNbOfCargo() {
		return currentNbOfCargo;
	}
	
	public String getArrivalTime() {
		return arrivalTime;
	}
	
	public Cargo getCargoDetails() {
		return cargoDetails;
	}

    public boolean isRequireFueling() {
    	if (requireFueling.equals("YES")) {
        return true;
    	}else {
    		return false;
    	}
    }

    public boolean isRequireMaintenance() {
    	if (requireMaintenance.equals("YES")) {
            return true;
        	}else {
        		return false;
        	}
    }

	public void Loadship(Stack<Cargo> Warehouse) {
	    if (!Warehouse.isEmpty()) {
	        Cargo cargo = Warehouse.pop();
	        if (currentNbOfCargo < capacity) {
	            shipStorage.push(cargo);
	            currentNbOfCargo++;
	        } else {
	            System.out.println("Ship's cargo capacity is full. Cannot load more cargo.");
	        }
	    } 
	}
	public void Unloadship(Stack<Cargo> Warehouse){
		if(currentNbOfCargo > 0) {
			Cargo cargo = shipStorage.pop();
			currentNbOfCargo--;
			Warehouse.push(cargo);
		}
	}

    public void displayShipDetails() {
        System.out.println("Ship ID: " + id + "\nCapacity: " + capacity + "\nArrival Time: " + arrivalTime + "\nCargo Details: " + cargoDetails.toString());
    }

}

