package PortManagementSystem;

public class Node {
    private Ship shipInfo;
    public Node next;

    public Node() {
        this.shipInfo = null;
        this.next = null;
    }

    public Node(Ship shipInfo) {
        this.shipInfo = shipInfo;
        this.next = null;
    }

    public Ship getShipInfo() {
        return shipInfo;
    }
}
