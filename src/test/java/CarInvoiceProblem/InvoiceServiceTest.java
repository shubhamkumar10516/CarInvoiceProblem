package CarInvoiceProblem;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class InvoiceServiceTest {
	InvoiceService invoiceService = null;
	RideRepository rideRepository = null;
	Ride[] rides = null;

	// initialization of invoiceService object
	@Before
	public void loadData() {
		invoiceService = new InvoiceService();
		rideRepository = new RideRepository();
		invoiceService.setRideRepository(rideRepository);
		rides = new Ride[] { new Ride(CabRide.NORMAL, 2.0, 5), new Ride(CabRide.PREMIUM, 0.1, 1) };
	}

	@Test
	public void givenDistanceCalculateTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.getFare(distance, time);
		assertEquals(25, fare, 0);
	}

	@Test
	public void givenLessDistanceAndTimeReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.getFare(distance, time);
		assertEquals(5, fare, 0);
	}

	@Test
	public void givenMultipleRidesReturnTotalFare() {
		InvoiceSummary expectedSummary = new InvoiceSummary(45, 2);
		InvoiceSummary summary = invoiceService.getFare(rides);
		assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserIdAndRideReturnInvoiceSummary() {
		String userId = "a@b.com";
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedSummary = new InvoiceSummary(45, 2);
		assertEquals(expectedSummary, summary);
	}
}
