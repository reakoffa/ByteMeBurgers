import java.math.BigDecimal;

public class CheckPayment extends Payment {

	private String checkNumber;

	public CheckPayment() {

	}

	public CheckPayment(BigDecimal amount) {
		super(amount);

	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Override
	public void getPayment() {
		// TODO Auto-generated method stub
		
	}

}
