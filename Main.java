package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("   Welcome to Daily Expense Calculator   ");
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Category Breakdown & Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("\nSelect Category: (1) Food (2) Transport (3) Bills (4) Leisure (5) Other");
                    System.out.print("Choice: ");
                    String catChoice = scanner.nextLine().trim();
                    String category = "Other";
                    if (catChoice.equals("1")) category = "Food";
                    else if (catChoice.equals("2")) category = "Transport";
                    else if (catChoice.equals("3")) category = "Bills";
                    else if (catChoice.equals("4")) category = "Leisure";

                    System.out.print("Enter Amount ($): ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine().trim());
                        if (amount <= 0) {
                            System.out.println("Amount must be greater than 0.");
                            break;
                        }
                        System.out.print("Enter Description: ");
                        String desc = scanner.nextLine().trim();
                        if (desc.isEmpty()) desc = "N/A";

                        manager.addExpense(category, amount, desc);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount format. Please enter a valid number.");
                    }
                    break;

                case "2":
                    manager.listExpenses();
                    break;

                case "3":
                    manager.showSummary();
                    break;

                case "4":
                    System.out.println("Thank you for using Daily Expense Calculator! Expenses saved.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection. Please choose 1, 2, 3, or 4.");
            }
        }
        scanner.close();
    }
}
