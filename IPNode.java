
public class IPNode {
	
	public enum Status { ACQ, AVAIL }
	
	public String statusToString(Status s) {
		
		switch(s) {
		case ACQ:   return "aquired";
		case AVAIL: return "available";
		default:    return "???";
		}
	}
	
	private String address;
	private Status s;
	public IPNode left, right;
	
	public IPNode() {
		this.address = null;
		this.s = null;
		left = null;
		right = null;
	}
	
	public IPNode(String address, Status s) {
		
		this.address = address;
		this.s = s;
		left = null;
		right = null;
	}
	
	public void setStatus(Status s) {
		
		this.s = s;
	}
	
	public String toString() {
		
		return address + " | " + statusToString(s);
	}
	
	public String getAddress() {
		
		return this.address;
	}
}
