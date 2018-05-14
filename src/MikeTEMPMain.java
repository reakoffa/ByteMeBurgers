import java.util.ArrayList;

public class MikeTEMPMain {

	public static void main(String[] args) {
		ArrayList<FoodItem> f = new ArrayList<>();
		f = FileMethods.readFromFile2();
		FileMethods.displayMenu(f);
		

		// HashMap<String, Double> cart = new HashMap<>();
		// Scanner scnr = new Scanner(System.in);
		// double price;
		// String item;
		// int num;
		// String ans;
		//
		// do {
		// item = Validator.getString(scnr, "Enter name");
		// price = Validator.getDouble(scnr, "Price");
		// num = Validator.getInt(scnr, "Quantity");
		// price = price * num;
		// cart.put(item, price);
		// ans = Validator.getString(scnr, "Any more? y/n");
		// } while (ans.equalsIgnoreCase("y"));
		// for (int i = 0; i > cart.size(); i++) {
		// System.out.println(cart.);
		// }

	}

}
