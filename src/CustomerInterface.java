import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInterface {

	public static void main(String[] args) {
		// object instences created here
		ArrayList<Employee> empList = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);

		// all variables initialized here
		String ans;
		int num;
		String item;
		double total = 0;
		String newEmp;
		String idNum;
		boolean idPass;
		int passTry = 4;

		System.out.println("Welcome to Byte Me Burgers!");
		System.out.println();
		ans = Validator.getString(scnr, "Hit enter to view our menu ");
		System.out.println();
		if (ans.equalsIgnoreCase("admin")) {
			ans = Validator.getString(scnr, "Please enter password to access admin privileges: ");
			System.out.println();
			if (ans.equalsIgnoreCase("aaa")) {
				System.out.println("Welcome to the management database!");
				do {
					ans = Validator.getString(scnr,
							"How would you like to modify management permissions? add/delete/exit: ");
					if (ans.equalsIgnoreCase("add")) {
						do {
							newEmp = Validator.getString(scnr, "Enter name of new manager: ");
							idNum = Validator.getString(scnr, "Enter ID number for new manager: ");
							Employee e1 = new Employee(idNum, newEmp);
							EmployeeMethods.writeToFile(e1);
							System.out.println();
							EmployeeMethods.printEmployeeList();
							ans = Validator.getString(scnr, newEmp
									+ " has been given management permissions. Would you like to add another manager? y/n ");
						} while (ans.equalsIgnoreCase("y"));
						System.out.println("Exiting program.");
					} else if (ans.equalsIgnoreCase("delete")) {
						empList = EmployeeMethods.readFromFileToArrayList();
						for (int i = 0; i < empList.size(); i++) {
							System.out.println(empList.get(i));
						}
						do {
							System.out.println();
							ans = Validator.getString(scnr, "Which manager would you like to remove?: ");
							EmployeeMethods.deleteEmployeeFromFile(ans);
							System.out.println();
							System.out.println("Updated manager list:");
							for (int i = 0; i < empList.size(); i++) {
								System.out.println(empList.get(i));
							}
							System.out.println();
							ans = Validator.getString(scnr, "Would you like to delete another manager? y/n ");
						} while (ans.equalsIgnoreCase("y"));
						System.out.println("Exiting program.");
					} else if (ans.equalsIgnoreCase("exit")) {
						System.out.println("Exiting program.");
					} else {
						System.out.println("Please select valid answer, or 'exit' to terminate program.");
						System.out.println();
						ans = "1";
					}
				} while (ans.equalsIgnoreCase("1"));

			} else
				System.out.println("Password invalid. Exiting program.");

		} else if (ans.equalsIgnoreCase("manager")) {
			empList = EmployeeMethods.readFromFileToArrayListForManagers();
			do {
				ans = Validator.getString(scnr, "Please verify ID number: ");
				idPass = false; // method to verify, needs boolean return
				if (idPass == true) {
					do {
						ans = Validator.getString(scnr, "How would you like to adjust the menu? add/delete/exit: ");
						if (ans.equalsIgnoreCase("add")) {
							System.out.println("Current menu:");
							System.out.println("=============");
							do {
								// list menu via method
								System.out.println();
								FoodItem f = new FoodItem();
								// f = method to create food item, plus user inputs
								EmployeeMethods.addItemToMenu(f);
								System.out.println();
								System.out.println("Updated menu:");
								// list menu
								System.out.println();
								ans = Validator.getString(scnr, "Would you like to add another item? y/n: ");
							} while (ans.equalsIgnoreCase("y"));
							System.out.println("Exiting program.");

						} else if (ans.equalsIgnoreCase("delete")) {
							System.out.println("Current menu:");
							System.out.println("=============");
							// list menu via method
							do {
								System.out.println();
								ans = Validator.getString(scnr, "Which item would you like to delete? ");
								EmployeeMethods.deleteItemFromMenu(ans);
								System.out.println("Updated menu:");
								ans = Validator.getString(scnr, "Would you like to delete another item? y/n: ");
							} while (ans.equalsIgnoreCase("y"));
							System.out.println("Exiting program.");

						} else if (ans.equalsIgnoreCase("exit")) {
							System.out.println("Exiting program.");
						} else {
							System.out.println("Input not recognized. Please try again.");
							System.out.println();
							ans = "2";
						}
					} while (ans.equalsIgnoreCase("2"));
					passTry = 0;
				} else {
					passTry = passTry - 1;
					if (passTry > 1) {
						System.out.println("Password invalid. " + passTry + " tries remaining. Please try again.");
						System.out.println();
					} else if (passTry == 1) {
						System.out.println("Password invalid. " + passTry + " try remaining. Please try again.");
						System.out.println();
					} else {
						System.out.println(
								"Password not recognized. Call customer support for lost password at (313) 555-1212");
						System.out.println("Terminating program.");
					}
				}
			} while (passTry > 0);

		} else {

			do {
				// Mikes method to view menu
				item = Validator.getString(scnr, "What item would you like to order? ");
				 num = Validator.getInt(scnr, "How many orders of our " + item + " would you like? ", 1, Integer.MAX_VALUE);
				 ans = Validator.getString(scnr, "You selected " + num + " " + item + "(s). Add item(s) to cart? y/n ");
				if (ans.equalsIgnoreCase("y")) {
					System.out.println(num + " " + item + "(s) added to cart");
					// enter Mikes code to add item/quantity/price to array list
				}
				ans = Validator.getString(scnr, "Would you like to order anything else? ");
			} while (ans.equalsIgnoreCase("y"));

			System.out.println("Thank you for your order! Here is your receipt:");
			System.out.println();
			// for (int i = 0; i < cart.length; i++) {
			// System.out.println(cart[i]);
			// }
			// for (int i = 0; i < cart.length; i++) {
			// total += cart[i];
			// }
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
					System.out.println("Ownership no longer accepts checks. Sorry for the inconvienience.");
				} else {
					System.out.println("Not a valid selection. Please try again.");
				}
			} while ((ans.equalsIgnoreCase("1")) || (ans.equalsIgnoreCase("2")) == false);
			System.out.println();
			System.out.println(
					"Thank you! Your order has been sent to the kitchen. Your name will be called shortly. Have a great day!");
		}

	}

}
