package PortManagementSystem;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
        Port port = new Port();
        Ships shipList = new Ships();
        int choice;
        
        Ship ship1 = new Ship(1, 150, "4:00PM ", "NO", "NO", new Cargo());
        ship1.getCargoDetails().setCargoType("Electronics");
        ship1.getCargoDetails().setWeight(100.0);
        ship1.getCargoDetails().setDestination("PortA");
        ship1.getCargoDetails().setOrigin("PortB");

        Ship ship2 = new Ship(2, 300, "5:30AM " ,"NO", "YES", new Cargo());
        ship2.getCargoDetails().setCargoType("Grain");
        ship2.getCargoDetails().setWeight(200.0);
        ship2.getCargoDetails().setDestination("PortC");
        ship2.getCargoDetails().setOrigin("PortD");
 
        Ship ship3 = new Ship(3, 700, "11:15PM ", "YES", "YES", new Cargo());
        ship3.getCargoDetails().setCargoType("Oil");
        ship3.getCargoDetails().setWeight(300.0);
        ship3.getCargoDetails().setDestination("PortE");
        ship3.getCargoDetails().setOrigin("PortF");

        shipList.addShip(ship1);
        port.portRecord.add(ship1);
       
        
        shipList.addShip(ship2);
        port.portRecord.add(ship2);
        
        port.maintenance.add(ship2);
        
        shipList.addShip(ship3);
        port.portRecord.add(ship3);
        
        port.fuelingStation.add(ship3);
        port.maintenance.add(ship3);


        do {
        	System.out.println();
            System.out.println("Please select an option of your choice:");
            System.out.println("1. Add Ship");
            System.out.println("2. Remove Ship");
            System.out.println("3. Load cargo to a ship");
            System.out.println("4. Unload cargo from a ship");
            System.out.println("5. Display Ships");
            System.out.println("6. Total Number of Ships at the Port");
            System.out.println("7. Ship with Highest Cargo Weight");
            System.out.println("8. Exit Program");
            choice = scan.nextInt();

            switch (choice) {
            case 1:
            	//Adding Ship
            	System.out.println();
                System.out.println("Enter Ship details:");
                System.out.println("-----------------------");
                
                System.out.print("Enter Ship Id: ");
                int id=scan.nextInt();
                
                System.out.print("Enter Ship Capacity: ");
                int capacity=scan.nextInt();
                
                System.out.print("Enter Ship Arrival Time: ");
                String arrivalTime=scan.next();
                
                System.out.print("Does it need fueling? (YES/NO): ");
                String fueling=scan.next();
                
                System.out.print("Does it need repairing? (YES/NO): ");
                String rep=scan.next();     
                
               Ship newShip = new Ship(id, capacity, arrivalTime,fueling,rep, new Cargo());
               
               System.out.println("\nEnter Cargo Details: ");
               System.out.println("-----------------------");
               
               System.out.print("Enter Cargo type: ");
               String type=scan.next();
               
               System.out.print("Enter Cargo weight: ");
               double weight=scan.nextDouble();
               
               System.out.print("Enter destination: ");
               String des=scan.next();
               
               System.out.print("Enter origin: ");
               String org=scan.next();
               
               newShip.getCargoDetails().setCargoType(type);
               newShip.getCargoDetails().setWeight(weight);
               newShip.getCargoDetails().setDestination(des);
               newShip.getCargoDetails().setOrigin(org);
               
               shipList.addShip(newShip);
               port.portRecord.add(newShip);
               
               
               if(fueling.equals("YES")) {
            	   port.fuelingStation.add(newShip);
            	   port.fuelShip(newShip.getId());
               }
               
               if(rep.equals("YES")) {
            	   port.maintenance.add(newShip);
            	   port.repairship(newShip.getId());
               }
               
               System.out.println();
               System.out.println("----------------------------");
               System.out.println("| Ship added successfully! |");
               System.out.println("----------------------------");
               System.out.println();
               
               break;
               
            case 2:
            	//removing
            	System.out.println("Enter Ship ID to remove:");
            	int shipIdToRemove = scan.nextInt();
            	shipList.deleteShipById(shipIdToRemove);
             	port.DeleteShip(shipIdToRemove);
             	System.out.println("Ship removed");
            	
            	break;
            	
            case 3:
            	//load
            	 System.out.print("\nEnter Ship ID to load: ");
            	    int shipId = scan.nextInt();
            	    scan.nextLine(); // Consume newline

            	    Ship ship = shipList.searchShip(shipId);
            	    if (ship != null) {
            	        ship.Loadship(port.warehouse);
            	        System.out.println("Cargo loaded into Ship ID " + shipId + " successfully.");
            	    } else {
            	        System.out.println("Ship with ID " + shipId + " not found.");
            	    }

            	    break;
            	    
            case 4:
            	//unload
            	   System.out.print("\nEnter Ship ID to unload: ");
            	    shipId = scan.nextInt();
            	    scan.nextLine(); // Consume newline

            	    ship = shipList.searchShip(shipId);
            	    if (ship != null) {
            	        ship.Unloadship(port.warehouse);
            	        System.out.println("Cargo unloaded from Ship ID " + shipId + " successfully.");
            	    } else {
            	        System.out.println("Ship with ID " + shipId + " not found.");
            	    }

            	break;
            	
            case 5:
            	//display
            	System.out.println();
            	System.out.println("Enter your Display choice: ");
            	System.out.println("  a. Display Port Record");
            	System.out.println("  b. Display Current Ships at the port ");
            	System.out.println("  c. Display by Type");
            	System.out.println("  d. Display by Destination");
            	System.out.println("  e. Display Ready Ships");
            	System.out.println("  f. Display Fueling Ships");
            	char displayChoice = scan.next().charAt(0);
            	switch (displayChoice) {
            	case 'a':
            		System.out.println("\nPort Record: ");
           	     	port.DisplayRecord();
            		
            		break;
            	case 'b' :
            		 System.out.println("\nCurrent Ships at the port: ");
            	     shipList.Display();
            		break;
            		
            	case 'c' :
            		System.out.print("\nEnter the type of ships you want to display: ");
            		String t= scan.next();
            		System.out.println("\nShips of type \""+t+"\" :");
                    shipList.DisplayByType(t);
           		 	break;
           		
            	case 'd' :
            		System.out.println("\nEnter the destination of ships you want to display: ");
            		String d= scan.next();
            		System.out.println("Ships with destination \""+d+"\" :");
                    shipList.DisplayByDestination(d);
           		 	break;
           		 	
            	case 'e' :
          
            		System.out.println("\nShips that don't need fueling or maintenance: ");
                    shipList.DisplayReadyShips();
           		 	break;
           		 	
            	case 'f' :
            		System.out.println();
                    port.displayFuelingStation();
           		 	break;
           		 	
            	default:
            		System.out.println("Invalid choice. ");
                    break;
            	
            	}
            	break;
               
            case 6:
            	//total number
            	System.out.println("\nTotal number of ships: " + shipList.totalNumberOfShips());
            	break;
               
            case 7:
            	//ship with highest weight
            	Ship shipWithHighestWeight = shipList.getShipWithHighestCargoWeight();
                if (shipWithHighestWeight != null) {
                    System.out.println("\nShip with highest cargo weight:");
                    System.out.println("-----------------------");
                    shipWithHighestWeight.displayShipDetails();
                } else {
                    System.out.println("\nNo ships at the port");
                }
                
            	break;
            case 8:
            	//exit
                System.out.println("\nExiting Program...");
                break;
            default:
                System.out.println("\nInvalid choice. Please enter a valid option.");
                break;
            }
        }while(choice!=8);
      
    }
    

}


