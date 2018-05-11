import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashPayment extends Payment {

	private BigDecimal amountTendered;

	public CashPayment() {
		super();

	}

	public CashPayment(BigDecimal amount) {
		super(amount);

	}

	public BigDecimal getAmountTendered() {
		return amountTendered;
	}

	public void setAmountTendered(BigDecimal amountTendered) {
		this.amountTendered = amountTendered;
	}

	@Override
	public void getPayment() {
		// TODO Auto-generated method stub
		
	}
	
	// overloaded overridden method from above may not need this...
	public static BigDecimal getPayment(double cash, double total) {
		double change;
		change = cash - total;
		BigDecimal b = BigDecimal.valueOf(change);
		b =  b.setScale(2, RoundingMode.CEILING);
		return b;
	}

}
