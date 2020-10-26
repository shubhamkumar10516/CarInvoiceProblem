package CarInvoiceProblem;

public class Ride {
	private double distance;
	private int time;
	CabRide rideType;
    
	public Ride(CabRide rideType, double distance, int time) {
		this.rideType = rideType;
		this.distance = distance;
    	this.time = time;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}

