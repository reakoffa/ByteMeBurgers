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
	public static ArrayList<Employee> readFromFile(String dir, String fileName) {
		Path readFile = Paths.get(dir, fileName);
		File file = readFile.toFile();
		String[] temp = new String[2];
		ArrayList<Employee> employees = new ArrayList<>();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				temp = line.split(",");
				employees.add(new Employee(temp[0], temp[1]));

				line = reader.readLine();
			}
			reader.close();
			
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
		return employees;
	}

	// Print out a list of employees.
	public static void printEmployeeList() {
		ArrayList<Employee> employeeList = readFromFile("CompanyInfo", "Employees");
		int i = 0;

		for (Employee e : employeeList) {
			System.out.println(++i + ". " + e.getName());
		}
	}

	// Add employee to list.
	public static void writeToFile(Employee employee) {

		Path writeFile = Paths.get("resources/emplist.txt");
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
