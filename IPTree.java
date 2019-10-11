import java.util.Scanner;

public class IPTree {
	
	public IPNode root;
	
	IPTree() {
		
		root = null;
	}
	
	public void insert(String address, IPNode.Status s) {
		
		root = insertNode(root, address, s);
		
	}
	
	public IPNode search(IPNode root, String address) {
		
		if(root == null || root.getAddress().compareTo(address) == 0) {
			return root;
		}
		//Comparing a converted long version of the IP address
		if(ipToNum(root.getAddress()) > ipToNum(address)) {
			return search(root.left, address);
		}
		return search(root.right, address);
	}
	
	private IPNode insertNode(IPNode root, String address, IPNode.Status s) {
		
		if (root == null) {
			root = new IPNode(address, s);
			return root;
		}
		if (ipToNum(address) < ipToNum(root.getAddress())) {
			root.left = insertNode(root.left, address, s);
		}
		else if (ipToNum(address) > ipToNum(root.getAddress())) {
			root.right = insertNode(root.right, address, s);
		}
		
		return root;		
	}
	
	//Removing decimal points and converting to long to allow for a comparison 
	//for entering into a binary tree
	private Long ipToNum(String address) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(address).useDelimiter("\\.");
		return 
			(sc.nextLong() << 24) +
			(sc.nextLong() << 16) +
			(sc.nextLong() << 8) +
			(sc.nextLong());
	}
	
	public void inOrderPrint() {
		
		treePrint(root);
	}
	//Printing tree using inorder traversal
	private void treePrint(IPNode root) {
		
		if(root != null) {
			treePrint(root.left);
			System.out.println(root.toString());
			treePrint(root.right);			
		} 
	}
	
}
