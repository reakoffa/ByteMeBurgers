import java.math.BigDecimal;
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
		Scanner scan = new Scanner(System.in);

		 try {
		validateCreditCardNumber(scan, "Please enter credit card number: ");
		validateDate(scan, "Please enter expiration date in the format (MM/DD)");
		validateCVV(scan, "Please enter the CVV number found on the back of the card: ");
		 } catch (NumberFormatException e) {
		 System.out.println("Oops! Something went wrong...");
		 }

	}

	public static void validateCreditCardNumber(Scanner scan, String prompt) {

		// Luhn's Algorithm for validating for a credit card number

		int sum;
		do {
			System.out.println(prompt);
			String str = scan.nextLine();
			int[] ints = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {
				ints[i] = Integer.parseInt(str.substring(i, i + 1));
			}
			for (int i = ints.length - 2; i >= 0; i = i - 2) {
				int j = ints[i];
				j = j * 2;
				if (j > 9) {
					j = j % 10 + 1;
				}
				ints[i] = j;
			}
			sum = 0;
			for (int i = 0; i < ints.length; i++) {
				sum += ints[i];
			}

			if (sum % 10 == 0) {
				break;
			} else {

				System.out.println(str + " is an invalid credit card number.");
			}
		} while (sum % 10 != 0);

	}

	public static void validateDate(Scanner scan, String prompt) {

		// Regex for validating for expiration date
		boolean isValid = false;
		String date;
		while (isValid == false) {
			System.out.println(prompt);
			date = scan.nextLine();
			if (date.matches("[0-9]{2}/[0-9]{2}")) {
				// System.out.println("Please enter your CVV: ");
				isValid = true;
			} else {
				System.out.println(date + " is not a valid expiration date.");
			}
		}
	}

	public static void validateCVV(Scanner scan, String prompt) {

		// Regex for validating for CVV
		boolean isValid = false;
		String cvv;
		while (isValid == false) {
			System.out.println(prompt);
			cvv = scan.nextLine();
			if (cvv.matches("[0-9]{3,4}")) {
				isValid = true;
			} else {
				System.out.println(cvv + " is not a valid CVV number.");
			}
		}

	}
}
