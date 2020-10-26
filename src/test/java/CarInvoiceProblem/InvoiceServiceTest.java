package CarInvoiceProblem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class InvoiceServiceTest {
	InvoiceService invoiceService = null;

	//initialization of invoiceService object
	@Before
	public void loadData() {
		invoiceService = new InvoiceService();
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
}
