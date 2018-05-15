import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInterface {

	public static void main(String[] args) {
		// object instences created here
		ArrayList<Employee> empList = new ArrayList<>();
		ArrayList<FoodItem> cart = new ArrayList<>();
		ArrayList<FoodItem> menu = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);

		// all variables initialized here
		String ans;
		int num;
		int item;
		double total = 0;
		String newEmp;
		String idNum;
		boolean idPass;
		int passTry = 4;
		String foodName;
		String cat;
		String description;
		double price;
		double tax;

		//this allows user to view menu, or if an employee, they can view admin or manager functions here
		System.out.println("Welcome to Byte Me Burgers!");
		System.out.println();
		ans = Validator.getString(scnr, "Hit enter to view our menu ");
		System.out.println();
		if (ans.equalsIgnoreCase("admin")) {
			ans = Validator.getString(scnr, "Please enter password to access admin privileges: ");
			System.out.println();
			if (ans.equalsIgnoreCase("beefaroni")) {
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
						EmployeeMethods.printEmployeeList();
						do {
							System.out.println();
							ans = Validator.getString(scnr, "Which manager would you like to remove? ");
							EmployeeMethods.deleteEmployeeFromFile(ans);
							System.out.println();
							System.out.println("Updated manager list:");
							EmployeeMethods.printEmployeeList();							
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

			//manager function to allow manager to add/delete items
		} else if (ans.equalsIgnoreCase("manager")) {
			empList = EmployeeMethods.readFromFileToArrayList();
			do {
				ans = Validator.getString(scnr, "Please verify ID number: ");
				idPass = EmployeeMethods.validateUserID2(ans, empList);
				if (idPass == true) {
					do {
						ans = Validator.getString(scnr, "How would you like to adjust the menu? add/delete/exit: ");
						if (ans.equalsIgnoreCase("add")) {
							System.out.println("Current menu:");
							System.out.println("=============");
							do {
								EmployeeMethods.printFoodItems();
						
								System.out.println();
								foodName = Validator.getString(scnr, "What is the name of the new menu item? (Include item number and tab after): ");
								cat = Validator.getString(scnr, "New item category (include tab after): ");
								description = Validator.getString(scnr, "Brief description of item (include tab after): ");
								price = Validator.getDouble(scnr, "Price of new item (no comma): ", 0, Double.MAX_VALUE);
								FoodItem f = new FoodItem(foodName, cat, description, price);
								EmployeeMethods.addItemToMenu(f);
								System.out.println();
								System.out.println("Updated menu:");
								EmployeeMethods.printFoodItems();
								System.out.println();
								ans = Validator.getString(scnr, "Would you like to add another item? y/n: ");
							} while (ans.equalsIgnoreCase("y"));
							System.out.println("Exiting program.");

						} else if (ans.equalsIgnoreCase("delete")) {
							System.out.println("Current menu:");
							System.out.println("=============");
							EmployeeMethods.printFoodItems();
							do {
								System.out.println();
								ans = Validator.getString(scnr, "Which item would you like to delete? ");
								EmployeeMethods.deleteItemFromMenu(ans);
								System.out.println("Updated menu:");
								EmployeeMethods.printFoodItems();
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
						//giving user 3 tries to enter the correct password (security protocol)
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
				
			menu = FileMethods.readFromFile2();
				FileMethods.displayMenu(menu);
				item = Validator.getInt(scnr, "Enter number of item would you like to order: ", 1, menu.size());
				num = Validator.getInt(scnr, "How many orders?: ", 1,
						Integer.MAX_VALUE);
				ans = Validator.getString(scnr, "You selected " + num + " " + menu.get(item - 1).getName() + "(s). Add item(s) to cart? y/n ");
				if (ans.equalsIgnoreCase("y")) {
					System.out.println(num + " " + menu.get((item - 1)).getName() + "(s) added to cart");
					cart.add(menu.get((item - 1)));
					cart.get((cart.size() - 1)).setPrice((cart.get((cart.size() - 1)).getPrice() * num));
				}
				ans = Validator.getString(scnr, "Would you like to order anything else? y/n: ");
			} while (ans.equalsIgnoreCase("y"));
			System.out.println("Thank you for your order! Here is your bill:");
			System.out.println();
			for (int i = 0; i < cart.size(); i++) {
				System.out.println(cart.get(i).getName() + "    " + cart.get(i).getPrice());
				total += cart.get(i).getPrice();
			}
			//calculates total
			System.out.println("Subtotal: " + Payment.calcPayment(total));
			tax = total * 0.06;
			System.out.println("Tax: " + Payment.calcPayment(tax));
			total += tax;
			System.out.println("Grand total: " + Payment.calcPayment(total));
			System.out.println();
			do {
				System.out.println("Please select method of payment:");
				System.out.println("1. Cash");
				System.out.println("2. Card");
				System.out.println("3. Check");
				ans = Validator.getString(scnr, " ");
				if (ans.equalsIgnoreCase("1")) {
					CashPayment.getPayment(total);
				} else if (ans.equalsIgnoreCase("2")) {
					Payment p = new CreditCardPayment();
					p.getPayment();
				} else if (ans.equalsIgnoreCase("3")) {
					Payment p = new CheckPayment();
					p.getPayment();
				} else {
					System.out.println("Invalid entry. Please enter valid entry.");
				}
			} while (((ans.equalsIgnoreCase("1")) || (ans.equalsIgnoreCase("2")) || (ans.equalsIgnoreCase("3"))) == false);
			System.out.println();
			System.out.println(
					"Thank you for your payment! Your order has been sent to the kitchen. Your name will be called shortly. Have a great day!");
		}

	}

}
