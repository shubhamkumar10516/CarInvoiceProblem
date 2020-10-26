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
}
