import java.util.Scanner;

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

	public CreditCardPayment(double amount) {
		super(amount);

	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Scanner scan, String cardNumber) {

		// Regex validating for credit card number

		boolean isValid = false;
		while (isValid == false) {

			if (cardNumber.matches("\\d{13,16}")) {
				this.cardNumber = cardNumber;
				isValid = true;
			} else {
				System.out.println(cardNumber + " is not a valid credit card number.");
				cardNumber = Validator.getString(scan, "Please enter a valid credit card number: ");

			}
		}
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(Scanner scan, String expiration) {

		// Regex validating for expiration date

		boolean isValid = false;

		while (isValid == false) {
			if (expiration.matches("\\d{2}/\\d{2}")) {
				this.expiration = expiration;
				isValid = true;
			} else {
				System.out.println(expiration + " is not a valid expiration date.");
				expiration = Validator.getString(scan, "Please enter a valid expiration date: ");

			}
		}
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(Scanner scan, String cvv) {

		// Regex validating for CVV number

		boolean isValid = false;

		while (isValid == false) {
			if (cvv.matches("\\d{3,4}")) {
				this.cvv = cvv;
				isValid = true;
			} else {
				System.out.println(cvv + " is not a valid CVV number.");
				cvv = Validator.getString(scan, "Please enter a valid CVV: ");
			}
		}

	}

	@Override
	public void getPayment() {
		Scanner scan = new Scanner(System.in);

		CreditCardPayment test = new CreditCardPayment();

		String cc = Validator.getString(scan, "Please enter your credit card number (numbers only - no dashes): ");
		test.setCardNumber(scan, cc);

		String expiration = Validator.getString(scan, "Please enter expiration date (MM/YY): ");
		test.setExpiration(scan, expiration);

		String cvv = Validator.getString(scan, "Please enter the CVV number found on the back of the card: ");
		test.setCvv(scan, cvv);
	}

}