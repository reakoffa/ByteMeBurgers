import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CashPayment extends Payment {

	private BigDecimal amountTendered;

	public CashPayment() {
		super();

	}

	public CashPayment(double amount) {
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

	}

	public static void getPayment(double total) {

		// accepting cash payment
		// calculating tax and change

		Scanner scan = new Scanner(System.in);

		boolean isValid = false;
		Double cash;
		double change;
		cash = Validator.getDouble(scan, "Please enter cash amount: ");
		//double tax = total * .06;
		//total = total + tax;
		change = cash - total;

		while (isValid == false) {

			String[] splitter = cash.toString().split("\\.");
			splitter[0].length(); // Before Decimal Count
			int decimalLength = splitter[1].length();

			if (cash < total) {
				System.out.println("You have not given enough cash.");
				cash = Validator.getDouble(scan, "Please enter correct amount of cash: ");
			} else if (decimalLength > 2) {
				System.out.println("The amount you entered is not valid.");
				cash = Validator.getDouble(scan, "Please enter cash amount in correct format (00.00): ");
			} else {
				isValid = true;

			}
		}

		DecimalFormat format = new DecimalFormat("###.00");
		String numberAsString = format.format(change);
		System.out.println("Your change is $" + numberAsString);

	}

}
