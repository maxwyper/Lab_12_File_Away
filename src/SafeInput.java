import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString;
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.trim().length() == 0);
        return retString;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean done = false;
        do {
            System.out.print(prompt + " (" + low + " - " + high + "): ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                if (value >= low && value <= high) {
                    done = true;
                } else {
                    System.out.println("Number not in range.");
                }
            } else {
                System.out.println("Invalid input.");
            }
            pipe.nextLine(); // Clear input buffer
        } while (!done);
        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
        } while (!response.equals("Y") && !response.equals("N"));
        return response.equals("Y");
    }
}

