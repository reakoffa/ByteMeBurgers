import java.math.BigDecimal;

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
	public int getPayment(int amount) {
		return 0;
	}

}
