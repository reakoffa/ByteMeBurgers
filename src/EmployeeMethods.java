import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

public class EmployeeMethods {

	// Read from the managers text file to generate an ArrayList of managers (who
	// will have permission to add/delete menu items and to add/delete employees).
	public static ArrayList<Employee> readFromFileToArrayList() {
		ArrayList<Employee> employees = new ArrayList<>();
		Path readFile = Paths.get("CompanyInfo/Employees");

		File file = readFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();
			String[] temp = new String[2];

			while (line != null) {
				temp = line.split(",");
				Employee e = new Employee(temp[0], temp[1]);
				employees.add(e);

				line = reader.readLine();
			}
			reader.close();

		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
		return employees;
	}

	public static ArrayList<FoodItem> readFromFileToArrayListFoodItems() {
		ArrayList<FoodItem> shoppingCart = new ArrayList<>();
		Path readFile = Paths.get("CompanyInfo/Menu");

		File file = readFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();
			String[] temp = new String[4];

			while (line != null) {
				temp = line.split(",");
				FoodItem f = new FoodItem(temp[0], temp[1], temp[2], 0);
				shoppingCart.add(f);

				line = reader.readLine();
			}
			reader.close();

		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
		return shoppingCart;
	}

	// Search an ArrayList of employees to validate userID.
	// In Main method, first assign String userInput = Validator.getString(scnr,
	// "Please enter your User ID number: ");
	public static void validateUserID(String userInput, ArrayList<Employee> employees) {
		for (Employee e : employees) {
			if (e.getId().equalsIgnoreCase(userInput)) {
				System.out.println("Welcome, " + e.getName() + "!");
				System.out.println(
						"\nOPTIONS\n1 - View the current menu\n2 - Add an item to the menu\n3 - Remove an item from the menu");
			} else {
				System.out.println("ID not recognized. Please try again.");
			}
		}
	}

	// Boolean value above is in the if condition
	// (m.getId().equalsIgnoreCase(userInput)). If that condition is true, the ID is
	// validated. Below is a method that accomplishes the same thing, but returns a
	// Boolean value.
	public static boolean validateUserID2(String userInput, ArrayList<Employee> employees) {
		HashSet<String> hs = new HashSet<String>();
		for (Employee e : employees) {
			hs.add(e.getId());
		}
		if (hs.contains(userInput)) {
			return true;
		} else {
			return false;
		}
	}

	// In main method, first assign userNum = Validator.getInt(scnr, "Please select
	// an option (1, 2, or 3): ", 1, 3);
	// if (userNum == 1) {
	// Display current menu.
	// }
	// if (userNum == 2) {
	// validate string. ask user to enter the name, category, description, and price
	// of the new item (in that order, separated by a comma).
	// call method addItemToMenu.
	// }
	// if (userNum == 3) {
	// validate string. ask user to enter the name of the food item to remove (will
	// this be enough to delete the whole line?).
	// call method deleteFoodItem.
	public static void addItemToMenu(FoodItem newfoodItem) {

		Path writeFile = Paths.get("CompanyInfo/Menu");
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(newfoodItem);
			outW.close(); // flushes data closes the stream

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}
	}

	// Delete food item.
	public static void deleteItemFromMenu(String itemToRemove) {
		Path removeItemFromList = Paths.get("CompanyInfo/Menu");
		File file = removeItemFromList.toFile();
		Path writeFile = Paths.get("CompanyInfo/TempMenu");
		File tempFile = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(new FileOutputStream(tempFile));

			String line = null;

			while ((line = br.readLine()) != null) {
				if (!line.startsWith(itemToRemove)) {
					pw.println(line);
				}
			}

			pw.close();
			br.close();

			// Delete original file.
			if (!file.delete()) {
				System.out.println("Could not delete file.");
				return;
			}

			// Rename new file.
			if (!tempFile.renameTo(file)) {
				System.out.println("Could not rename ");
			}

		} catch (IOException e) {
			System.out.println("No need to panic but something's not right here.");
		}
	}

	// Print out a list of employees.
	public static void printEmployeeList() {
		ArrayList<Employee> employees = readFromFileToArrayList();
		int i = 0;

		for (Employee e : employees) {
			System.out.println(++i + ". " + e.getName());
		}
	}
		
	//Print out a list of food items.
	public static void printFoodItems() {
		ArrayList<FoodItem> foodItems = new ArrayList<>();
		foodItems = readFromFileToArrayListFoodItems();
		
		for (FoodItem f : foodItems) {
			System.out.println(f.getName());
		}
	}
	

	// Add employee to list.
	public static void writeToFile(Employee employee) {

		Path writeFile = Paths.get("CompanyInfo/Employees");
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(employee);
			outW.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}
	}

	// Delete employee.
	public static void deleteEmployeeFromFile(String employeeToRemove) {
		Path removeEmployeeFromList = Paths.get("CompanyInfo/Employees");
		File file = removeEmployeeFromList.toFile();
		Path writeFile = Paths.get("CompanyInfo/TempEmployees");
		File tempFile = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(new FileOutputStream(tempFile));

			String line = null;

			while ((line = br.readLine()) != null) {
				if (!line.endsWith(employeeToRemove)) {
					pw.println(line);
				}
			}

			pw.close();
			br.close();

			// Delete original file.
			if (!file.delete()) {
				System.out.println("Could not delete file.");
				return;
			}

			// Rename new file.
			if (!tempFile.renameTo(file)) {
				System.out.println("Could not rename file.");
			}

		} catch (IOException e) {
			System.out.println("No need to panic but something's not right here.");
		}
	}

}