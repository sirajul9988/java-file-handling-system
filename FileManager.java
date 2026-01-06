import java.io.*;
import java.util.Scanner;

public class FileManager {

    private static final String FILE_NAME = "data.txt";

    public static void writeToFile(String content) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(content + System.lineSeparator());
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("File Contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Java File Handling System");
        System.out.println("1. Write to file");
        System.out.println("2. Read from file");
        System.out.print("Enter choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter text: ");
            String text = scanner.nextLine();
            writeToFile(text);
        } else if (choice == 2) {
            readFromFile();
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
