package PortManagementSystem;

public class Ships {
	private Node head;
	
	public Ships() {
		this.head = null;
	}
	public boolean isEmpty() {
		return(head == null);
	}
	public void addShip(Ship S) {
		Node n = new Node(S);
		Node current = this.head;
		
		if(isEmpty()) {
			n.next = null;
			this.head = n;
		} else {
		
		while(current.next != null){
			current = current.next;
		}
		n.next = null;
		current.next = n;
	  }
	}
	public void deleteShipById(int shipId) {
	    if (head == null) {
	        return; // Empty list, do nothing
	    }

	    if (head.getShipInfo().getId() == shipId) {
	        head = head.next;
	        return;
	    }

	    Node current = head;
	    while (current.next != null && current.next.getShipInfo().getId() != shipId) {
	        current = current.next;
	    }

	    if (current.next != null) {
	        current.next = current.next.next;
	    }
	}
	
	public int totalNumberOfShips() {
		Node current = head;
		int count = 0;
	    if (head == null) {
	        return 0; // Empty list return 0
	    } else {
	    	while(current != null) {
	    		current = current.next;
	    		count++;
	    	}
	    }
	    return count;
	}
	public Ship searchShip(int id) {
	    Node current = head;
	    while (current != null) {
	        if (current.getShipInfo().getId() == id) {
	            return current.getShipInfo(); // Ship found
	        }
	        current = current.next;
	    }
	    return null; // Ship not found
	}
	public Ship getShipWithHighestCargoWeight() {
	    if (head == null) {
	        return null; // Empty list, return null
	    }

	    Node current = head;
	    Ship shipWithHighestWeight = current.getShipInfo();
	    double highestWeight = shipWithHighestWeight.getCargoDetails().getWeight();

	    while (current != null) {
	        double currentWeight = current.getShipInfo().getCargoDetails().getWeight();
	        if (currentWeight > highestWeight) {
	            highestWeight = currentWeight;
	            shipWithHighestWeight = current.getShipInfo();
	        }
	        current = current.next;
	    }

	    return shipWithHighestWeight;
	}
	public void Display() {
		 Node current = head;
		 
		 if(isEmpty()) {
			 System.out.println("No ships at the port");
		 } else {
			 while (current != null) {
		        current.getShipInfo().displayShipDetails();
		        System.out.println("-------------------------------\n");
		        current = current.next;
		    }
		 } 
	}
	public void DisplayByType(String type) {
		 Node current = head;
		 
		 if(isEmpty()) {
			 System.out.println("No ships of such type at the port");
		 } else {
			 while (current != null ) {
				 if(current.getShipInfo().getCargoDetails().getCargoType().equals(type)) {
		        current.getShipInfo().displayShipDetails();
		        System.out.println("-------------------------------\n");
				 }
		        current = current.next;
		    }
		 } 
	}
	public void DisplayByDestination(String destination) {
		 Node current = head;
		 
		 if(isEmpty()) {
			 System.out.println("No ships have this destination");
		 } else {
			 while (current != null ) {
				 if(current.getShipInfo().getCargoDetails().getDestination().equals(destination)) {
		        current.getShipInfo().displayShipDetails();
		        System.out.println("-------------------------------\n");
				 }
		        current = current.next;
		    }
		 } 
	}
	public void DisplayReadyShips() {
		Node current = head;
		 
		 if(isEmpty()) {
			 System.out.println("No ships are ready");
		 } else {
			 while (current != null ) {
				 if(current.getShipInfo().isRequireFueling() == false && current.getShipInfo().isRequireMaintenance() == false ) {
		        current.getShipInfo().displayShipDetails();
		        System.out.println("-------------------------------\n");
				 }
		        current = current.next;
		    }
		 } 
			
		}
	}
	
	


