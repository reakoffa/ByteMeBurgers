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

public class EmployeeMethods {

	// Read from the managers text file to generate an ArrayList of managers (who
	// will have permission to add/delete menu items and to add/delete employees).
	public static ArrayList<Employee> readFromFileToArrayList(String filePath) {
		ArrayList<Employee> employees = new ArrayList<>();
		Path readFile = Paths.get(filePath);

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
	public static void addItemToMenu(FoodItem newfoodItem, String filePath) {

		Path writeFile = Paths.get(filePath);
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(newfoodItem);
			outW.close(); // flushes data closes the stream

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}
	}

	// Delete food item or delete employee.
	// This method should work for deleting food items from a menu file and for
	// deleting employees from a list.
	public static void deleteFromFile(String itemToRemove, String dir, String originalFileName, String tempFileName) {
		Path removeItemFromList = Paths.get(dir, originalFileName);
		File file = removeItemFromList.toFile();
		Path writeFile = Paths.get(dir, tempFileName);
		File tempFile = writeFile.toFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileOutputStream(tempFile, true));

			String line = null;

			while ((line = br.readLine()) != null) {
				if (!line.equalsIgnoreCase(itemToRemove)) {
					pw.println(line);
				}
			}

			pw.close();
			br.close();

			// Delete original file.
			if (!file.delete()) {
				System.out.println("Could not delete file.");
			}

			// Rename new file.
			if (tempFile.renameTo(file)) {
				System.out.println("Could not rename ");
			}

		} catch (IOException e) {
			System.out.println("No need to panic but something's not right here.");
		}
	}

	// Print out a list of employees.
	public static void printEmployeeList() {
		ArrayList<Employee> employees = readFromFileToArrayList("resources/countries.txt");
		int i = 0;

		for (Employee e : employees) {
			System.out.println(++i + ". " + e.getName());
		}
	}

	// Add employee to list.
	public static void writeToFile(Employee employee, String filePath) {

		Path writeFile = Paths.get(filePath);
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(employee);
			outW.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}
	}
}
