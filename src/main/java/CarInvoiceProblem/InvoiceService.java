package CarInvoiceProblem;

import java.util.List;

public class InvoiceService {
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	RideRepository rideRepository;

	// initializing rideRepository instance
	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	// calculate total fare for given distance and time
	public double getFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	// calculating fare for multiple rides
	public InvoiceSummary getFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += ride.rideType.calculateCostOfCabRide(ride);
		return new InvoiceSummary(totalFare, rides.length);
	}

	// generating invoice for user id
	public InvoiceSummary getInvoiceSummary(String userId) {
		List<Ride> rideList = rideRepository.getRides(userId);
		return new InvoiceSummary(getFare(rideList), rideList.size());
	}

	private double getFare(List<Ride> rideList) {
		double totalFare = 0;
		for (Ride ride : rideList)
			totalFare += ride.rideType.calculateCostOfCabRide(ride);
		return totalFare;
	}

	// adding rides
	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}
}
