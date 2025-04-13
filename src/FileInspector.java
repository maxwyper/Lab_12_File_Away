import javax.swing.*;
import java.io.*;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser("src"); // Opens in src directory
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("Reading file...\n");

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    lineCount++;

                    String[] words = line.trim().split("\\s+");
                    if (!line.isBlank()) {
                        wordCount += words.length;
                    }

                    charCount += line.length();
                }

                // Summary Report
                System.out.println("\n--- Summary Report ---");
                System.out.println("File name: " + selectedFile.getName());
                System.out.println("Number of lines: " + lineCount);
                System.out.println("Number of words: " + wordCount);
                System.out.println("Number of characters: " + charCount);

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File selection cancelled.");
        }
    }
}
