package CarInvoiceProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
	Map<String, ArrayList> rides;

	public RideRepository() {
		this.rides = new HashMap<String, ArrayList>();
	}

	public void addRides(String userId, Ride[] rides) {
		ArrayList<Ride> rideList = new ArrayList<>();
		if (!this.rides.containsKey(userId)) {
			convertArrayToList(rides, rideList);
			this.rides.put(userId, rideList);
			return;
		}
		rideList = this.rides.get(userId);
		convertArrayToList(rides, rideList);
		this.rides.put(userId, rideList);
	}

	public List<Ride> getRides(String userId) {
		return this.rides.get(userId);
	}
	
	public void convertArrayToList(Ride[] rides, ArrayList<Ride> rideList) {
		for (Ride ride : rides)
			rideList.add(ride);
	}
}
