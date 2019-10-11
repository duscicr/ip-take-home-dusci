
//A few basic tests to show functionality

public class testing {

	public static void main(String[] args) {
		
		IPManagement ipTest = new IPManagement();
		
		ipTest.createIP("255.255.255.127/30");
		
		//Testing conflict
		ipTest.createIP("255.255.255.127/31");
		System.out.println();
		
		ipTest.acquireIP("255.255.255.127");
		
		ipTest.listIP();
		
		System.out.println();
		
		ipTest.releaseIP("255.255.255.127");
		
		ipTest.listIP();

	}

}
