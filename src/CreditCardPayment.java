import java.math.BigDecimal;

public class CreditCardPayment extends Payment {

	private String cardNumber;
	private String expiration;
	private String cvv;

	public CreditCardPayment() {
		super();

	}

	public CreditCardPayment(String cardNumber, String expiration, String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.expiration = expiration;
		this.cvv = cvv;
	}

	public CreditCardPayment(BigDecimal amount) {
		super(amount);

	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public void getPayment() {
		System.out.println("Please enter your credit card #: ");
		
		
	}

	

	

}
