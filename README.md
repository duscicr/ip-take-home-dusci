# IP Address Management System
 
Create a simple IP Address Management System using your prefered language/framework on top of any data store. It will include the ability to add IP Addresses by CIDR block and then either acquire or release IP addresses individually. Each IP address will have a status associated with it that is either “available” or “acquired”. 
 
The System must support four operations:
  * **Create IP addresses** - take in a CIDR block (e.g. 10.0.0.1/24) and add all IP addresses within that block to the data store with status “available”
  * **List IP addresses** - return all IP addresses in the system with their current status
  * **Acquire an IP** - set the status of a specified IP to “acquired”
  * **Release an IP** - set the status of a specified IP to “available”

## Bonus

The System will check if a suppied CIDR block is in conflict with an already registered CIDR block.
