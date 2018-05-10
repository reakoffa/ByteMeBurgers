import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInterface {

	public static void main(String[] args) {
		// object instences created here
		// ArrayList<FoodItems> cart = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);

		// all variables initialized here
		String ans;
		int num;
		String item;
		double total;

		System.out.println("Welcome to Byte Me Burgers!");
		System.out.println();
		ans = Validator.getString(scnr, "Hit enter to view our menu ");
		System.out.println();
		if (ans.equalsIgnoreCase("admin")) {
			// enter Bens methods for manipulating emp text file
		} else if (ans.equalsIgnoreCase("manager")) {
			// enter Bens code for modifying menu
		} else {
			do {

				// Mikes method to view menu
				item = Validator.getString(scnr, "What item would you like to order? ");
				num = Validator.getInt(scnr, "How many orders of our " + item + " would you like? ", 1, 10);
				ans = Validator.getString(scnr, "You selected " + num + " " + item + "(s). Add item(s) to cart? y/n ");
				if (ans.equalsIgnoreCase("y")) {
					System.out.println(num + " " + item + "(s) added to cart");
					// enter Mikes code to add item/quantity/price to array list
				}
				ans = Validator.getString(scnr, "Would you like to order anything else? ");
			} while (ans.equalsIgnoreCase("y"));

			System.out.println("Thank you for your order! Here is your receipt:");
			System.out.println();
			for (int i = 0; i < cart.length; i++) {
				System.out.println(cart[i]);
			}
			for (int i = 0; i < cart.length; i++) {
				total += cart[i];
			}
			System.out.println();
			System.out.println("Your total is $" + total);
			System.out.println();
			do {
				System.out.println("Please select method of payment:");
				System.out.println("1. Cash");
				System.out.println("2. Card");
				System.out.println("3. Check");
				ans = Validator.getString(scnr, null);
				if (ans.equalsIgnoreCase("1")) {
					// enter Alli's code for cash payment
				} else if (ans.equalsIgnoreCase("2")) {
					// enter Alli's code for card payment/verification
				} else if (ans.equalsIgnoreCase("3")) {
					// enter stuff for check option
				} else {
					System.out.println("Not a valid selection. Please try again.");
				}
			} while ((ans.equalsIgnoreCase("1")) || (ans.equalsIgnoreCase("2")) == false);
			System.out.println();
			System.out.println("Thank you! Your order has been sent to the kitchen. Your name will be called shortly. Have a great day!");
		}

	}

}
