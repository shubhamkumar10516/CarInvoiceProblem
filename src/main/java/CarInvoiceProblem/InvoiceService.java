package CarInvoiceProblem;

public class InvoiceService {
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	
	// calculate total fare for given distance and time
		public double getFare(double distance, int time) {
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
			return totalFare;
		}
}
