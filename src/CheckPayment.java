import java.util.Scanner;

public class CheckPayment extends Payment {

	private String checkNumber;

	public CheckPayment() {

	}

	public CheckPayment(double amount) {
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
		Scanner scan = new Scanner(System.in);
		boolean isValid = false;
		System.out.println("Please enter the 9-digit check Number: ");
		checkNumber = scan.nextLine();

		while (isValid == false) {
			if (checkNumber.matches("\\d{9}")) {
				// this.checkNumber = checkNumber;
				isValid = true;
			} else {
				System.out.println(checkNumber + " is not a valid check number.");
				checkNumber = Validator.getString(scan, "Please enter a valid check number: ");
			}
		}

	}

}
