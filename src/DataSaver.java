import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int recordId = 1;

        System.out.println("=== Data Entry Program ===");

        do {
            String id = String.format("%06d", recordId);
            System.out.println("\nCreating Record with ID Number: " + id);

            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int year = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2025);

            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, id, email, year);
            records.add(record);
            recordId++;
        } while (SafeInput.getYNConfirm(in, "Do you want to add another record?"));

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name to save (no extension)") + ".csv";
        String filePath = "src/" + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("\n✅ Records saved successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }

        in.close();
    }
}




