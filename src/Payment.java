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

	public double calcPayment(ArrayList<FoodItem> items) {

		double total = 0;

		// adding items to cart
		for (FoodItem i : items) {
			total += i.getPrice();

		}

		// calculating total
		double tax = total * .06;
		total = total + tax;

		return total;
	}

	public abstract void getPayment();

	@Override
	public String toString() {
		return "Please pay: $" + amount;
	}

}
