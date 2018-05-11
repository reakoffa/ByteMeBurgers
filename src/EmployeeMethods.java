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

	// Read from the employee text file to generate an ArrayList of employees.
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
	
	public static void validateUserID(String userInput, ArrayList<Employee> employees) {
		for (Employee e : employees) {
			if (e.getName().equalsIgnoreCase(userInput)) {
				System.out.println("\nOPTIONS\n1 - Add an item to the menu\n2 - Remove an item from the menu");
			} else {
				System.out.println("ID not recognized. Please try again.");
			}
		}
	}
	
	public static void addItemToMenu(FoodItem foodItem, String filePath) {

		Path writeFile = Paths.get(filePath);
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(employee);
			outW.close(); // flushes data closes the stream

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}
	}

	// ADMINISTRATOR FUNCTION: Print out a list of employees.
	public static void printEmployeeList() {
		ArrayList<Employee> employees = readFromFileToArrayList("resources/countries.txt");
		int i = 0;

		for (Employee e : employees) {
			System.out.println(++i + ". " + e.getName());
		}
	}

	// TODO: Add employee to list.
	public static void writeToFile(Employee employee, String dir, String fileName) {

		Path writeFile = Paths.get(dir, fileName);
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(employee);
			outW.close(); // flushes data closes the stream

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}
	}
}
