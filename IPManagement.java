//added apahce commons-net-3.6.jar
import org.apache.commons.net.util.*;


public class IPManagement {
	
	IPTree tree = new IPTree();
	
	public void createIP(String address) {
		
		SubnetUtils utils = new SubnetUtils(address);
		//including the network and broadcast addresses
		utils.setInclusiveHostCount(true);
		String[] addresses = utils.getInfo().getAllAddresses();
		
		//My attempt to solving the bonus
		for(String s : addresses) {
			IPNode node = tree.search(tree.root, s);
			if(node != null) {
				System.out.println("CIDR Block in conflict");
				return;
			}
		}
		
		//Inserts in nlogn time
		for(String s : addresses) {

			tree.insert(s, IPNode.Status.AVAIL);
		}	
	}
	
	public void acquireIP(String address) {
		
		//Search for node, if the node exists will change status to acquired
		//Searches in logn time
		IPNode node = tree.search(tree.root, address);
		if(node != null) {
			node.setStatus(IPNode.Status.ACQ);
		} else {
			System.out.println("Address: " + address + " not in system");
		}
		
	}
	
	public void releaseIP(String address) {
		
		//Search for node, if the node exists will change status to available
		//Searches in logn time
		IPNode node = tree.search(tree.root, address);
		if(node != null) {
			node.setStatus(IPNode.Status.AVAIL);
		} else {
			System.out.println("Address: " + address + " not in system");
		}	
	}
	
	public void listIP() {
		
		//will print the contents of the tree using inOrder traversal 
		tree.inOrderPrint();
	}
}
