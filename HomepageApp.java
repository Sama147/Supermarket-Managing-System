package ay_7aga;

import java.util.Scanner;

public class HomepageApp {
    private static final String MANAGER_PASSWORD = "superpass";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Supermarket App!");

        while (true) {
            System.out.println("\nChoose a mode:");
            System.out.println("1. Inventory Manager Mode");
            System.out.println("2. Cashier Mode");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the password for Inventory Manager Mode: ");
                    scanner.nextLine();
                    String enteredPassword = scanner.nextLine();
                    if (enteredPassword.equals(MANAGER_PASSWORD)) {
                        ManagerApp.main(args);
                    } else {
                        System.out.println("Incorrect password. Access denied to Inventory Manager Mode.");
                    }
                    break;
                case 2:
                    CashierApp.main(args);
                    break;
                case 3:
                    System.out.println("Exiting Supermarket App. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
