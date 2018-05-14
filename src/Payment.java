import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Payment {

	private double amount;

	public Payment() {

	}

	public Payment(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public static String calcPayment(double total) {
		DecimalFormat format = new DecimalFormat("###.00");
		String numberAsString = format.format(total);
		return numberAsString;
		
	}

	public abstract void getPayment();

	@Override
	public String toString() {
		return "Please pay: $" + amount;
	}

}
