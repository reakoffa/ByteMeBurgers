import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Payment {

	private BigDecimal amount;

	public Payment() {

	}

	public Payment(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal calcPayment(ArrayList<BigDecimal> items) {//change "bigdecimal" to fooditems
		// calculations go here for calculating subtotal, tax, and grand total
		BigDecimal sum = new BigDecimal(0.0);
		for (BigDecimal i : items) {
			sum = sum.add(i);
			
		}

		return sum;
	}

	public abstract void getPayment();
	
	@Override
	public String toString() {
		return "Please pay: $" + amount;
	}

	// do calcs here
	// 3 child classes to use calcs
	// abstract getpmt method - b/c each child class will perform different
	// operation

}
