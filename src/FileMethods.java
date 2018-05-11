import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileMethods {

	public static void createDirectory(String name) {
		Path filePath = Paths.get(name);
		if (Files.notExists(filePath)) {
			try {
				Files.createDirectory(filePath);
				System.out.println("Your directory was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong!");
			}
		}
	}

	public static void createFile(String dir, String file) {
		Path filePath = Paths.get(dir, file);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong!");
			}
		}
	}

	public static void writeToFile(String filePath, String toWrite) {
		Path writeFile = Paths.get(filePath);
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(toWrite);
			outW.close();

		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
		}
	}

	public static void readFromFile(String dir) {
		Path read = Paths.get(dir);
		File file = read.toFile();

		FileReader fr;
		try {
			fr = new FileReader(file);

			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	

	} //end of method

	public static ArrayList<FoodItem> readFromFile2(String fileName) {
		Path read = Paths.get(fileName);
		File file = read.toFile();
		ArrayList<FoodItem> foodItems = new ArrayList<>();

		FileReader fr;
		try {
			fr = new FileReader(file);

			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null && line.isEmpty()== false) {
				System.out.println(line);
				String [] words = line.split("\t");
				foodItems.add(new FoodItem(words[0],Category.valueOf(words[1]), words[2], Double.parseDouble(words[3])));
				System.out.println(words[0]);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	
		return foodItems;
	}

	public static void addToFile(String fileName, ArrayList<FoodItem> foodItems) {
		ArrayList<FoodItem> data = readFromFile2(fileName);
		data.addAll(foodItems);
		writeToFile(fileName, data);
		
		
		return;
	}

	private static void writeToFile(String fileName, ArrayList<FoodItem> data) {
		Path writeFile = Paths.get(fileName);
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			
			for (FoodItem f: data) {
			outW.println(f);
			}
			outW.close();

		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
		}
		
	}
}
