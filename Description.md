# Port Management System

The Port Management System is a comprehensive software 
solution designed to efficiently manage various activities 
within a port. It encompasses cargo handling, ship fueling, 
maintenance, and record-keeping functionalities. 
The Port Management System incorporates several data structures, 
including linked lists, stacks, and queues. Ships within the system 
are represented by a linked list, where each node represents a ship. 
When a new ship is added to the system, it is appended to the list 
of ships. Depending on its requirements, the ship may be enqueued 
in the fueling station if it needs fuel or in the maintenance station if 
it requires repairs. 
Regardless of the addition or deletion of ships, every ship that 
enters the port is also pushed to the stack of port records. This 
stack maintains a historical record of all ships that have visited the 
port. 
Additionally, each ship within the system is associated with a stack 
of cargo. This cargo stack can be loaded from the warehouse onto 
the ship or unloaded from the ship back into the warehouse, 
depending on the ship's activities and requirements. 
