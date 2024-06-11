package PortManagementSystem;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Port {
    Stack<Cargo> warehouse;
    Stack<Ship> portRecord;
    private Ships ships;
    Queue<Ship> fuelingStation;
    Queue<Ship> maintenance;

    public Port() {
        ships = new Ships();
        warehouse = new Stack<>();
        fuelingStation = new LinkedList<>();
        maintenance = new LinkedList<>();
        portRecord = new Stack<>();
    }
    
    public Ships getShips() {
		return ships;
	}

    public void loadCargoToWarehouse(Cargo cargo) {
        warehouse.push(cargo);
        System.out.println("Cargo loaded into Warehouse: " + cargo.toString());
    }

    
    public void fuelShip(int id) {
        Ship ship = ships.searchShip(id);
        if (ship != null && ship.isRequireFueling()) {
            ships.deleteShipById(id);
            fuelingStation.add(ship);
            System.out.println("Ship with ID " + id + " is now in the fueling station.");
        } else {
            System.out.println("Ship is not eligible for fueling.");
        }
    }

    public void displayFuelingStation() {
        System.out.println("Ships in Fueling Station:");
        for (Ship ship : fuelingStation) {
            if (ship.isRequireFueling()==true) {
                System.out.println("Ship ID: " + ship.getId());
            }
        }
    }

    
	public void EmptyFuelingQueue() {
		Ship s = fuelingStation.remove();
		ships.addShip(s);
	}
	
	public void repairship(int id) {
		Ship s = ships.searchShip(id);
		
		if(s.isRequireMaintenance()== true) {
			ships.deleteShipById(id); 
			maintenance.add(s);
		}
	}
	public void EmptyMaintenanceQueue() {
		Ship s = maintenance.remove();
		ships.addShip(s);
	}
	public void DeleteShip(int id) {
		Ship s = ships.searchShip(id);
		ships.deleteShipById(id);
	}
	public void DisplayRecord() {
		Stack<Ship> temp = new Stack<>();
		
		while(!portRecord.empty()) {
			Ship s = portRecord.pop();
			temp.push(s);
			System.out.println();
			s.displayShipDetails();
			System.out.println("-----------------------");
		}
		while(!temp.empty()) {
			Ship s = temp.pop();
			portRecord.push(s);
		}
	}

}

