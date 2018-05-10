import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInterface {

	public static void main(String[] args) {
		// object instences created here
		//ArrayList<FoodItems> cart = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);
		
		// all variables initialized here
		String ans;
		int num;
		String item;
		
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
					//enter Mikes code to add item/quantity/price to array list
				}
			} while (ans.equalsIgnoreCase("y") == false);
			System.out.println("Working");
		}

	}

}
