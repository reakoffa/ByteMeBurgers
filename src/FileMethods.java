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
	

	}
}
