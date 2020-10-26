package CarInvoiceProblem;


public class InvoiceSummary {
	double totalFare;
	int noOfRides;
	double averageField;

	public InvoiceSummary(double totalFare, int noOfRides) {
		this.totalFare = totalFare;
		this.noOfRides = noOfRides;
		this.averageField = totalFare / noOfRides;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageField);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + noOfRides;
		temp = Double.doubleToLongBits(totalFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageField) != Double.doubleToLongBits(other.averageField))
			return false;
		if (noOfRides != other.noOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}
}
