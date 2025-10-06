package lab1;

import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("********************");
            System.out.println(" 1. Add Items");
            System.out.println(" 2. Edit Items");
            System.out.println(" 3. Delete Items");
            System.out.println(" 4. Sell item(s)");
            System.out.println(" 5. List items");
            System.out.println("99. Quit");
            System.out.println("********************");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> MenuItem();
                case "2" -> System.out.println("... Edit Items functionality will be implemented here ...");
                case "3" -> System.out.println("... Delete Items functionality will be implemented here ...");
                case "4" -> System.out.println("... Sell items functionality will be implemented here ...");
                case "5" -> System.out.println("... List items functionality will be implemented here ...");
                case "99" -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid choice, (valid options are 1 to 5 and 99 to quit)");
            }
        }
    }

    private void MenuItem() {
        boolean flag = false;
        while (!flag) {
            System.out.println("\nAdd an item");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Magazine");
            System.out.println("3. Add a DiscMag");
            System.out.println("4. Add a Ticket");
            System.out.println("99. Exit app");
            System.out.print("Enter choice: ");
            String c = scanner.nextLine().trim();
            switch (c) {
                case "1" -> System.out.println("....Add Book functionality will be implemented here....");
                case "2" -> System.out.println("....Add Magazine functionality will be implemented here....");
                case "3" -> System.out.println("....Add DiscMag functionality will be implemented here....");
                case "4" -> System.out.println("....Add Ticket functionality will be implemented here....");
                case "99" -> {
                    System.out.println("Redirecting to main menu...");
                    flag = true;
                }
                default -> System.out.println("Invalid choice (valid options are 1 to 4 and 99 to exit)");
            }
        }
    }
}
