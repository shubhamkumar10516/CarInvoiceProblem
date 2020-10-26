package CarInvoiceProblem;

public enum CabRide {
	NORMAL(10.0, 1.0, 5.0), PREMIUM(15.0, 2.0, 20);

	private final double costPerKm;
	private final double costPerMin;
	private final double minFarePerRide;

	CabRide(double cPk, double cPM, double mF) {
		costPerKm = cPk;
		costPerMin = cPM;
		minFarePerRide = mF;
	}

	public double calculateCostOfCabRide(Ride ride) {
		double totalFare = ride.getDistance()*costPerKm + ride.getTime()*costPerMin;
		return Math.max(totalFare, minFarePerRide);
	}
}
