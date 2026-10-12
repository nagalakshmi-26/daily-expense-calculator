package src;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();
    private final String dataFile = "expenses.csv";

    public ExpenseManager() {
        loadExpenses();
    }

    public void addExpense(String category, double amount, String description) {
        String id = "E" + (expenses.size() + 1);
        Expense expense = new Expense(id, category, amount, description, LocalDate.now());
        expenses.add(expense);
        saveExpenses();
        System.out.println("Expense logged successfully! (ID: " + id + ")");
    }

    public void listExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-6s | %-12s | %-9s | %-12s | %s\n", "ID", "Category", "Amount", "Date", "Description");
        System.out.println("--------------------------------------------------------------------------------");
        for (Expense e : expenses) {
            System.out.println(e);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public void showSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to summarize.");
            return;
        }

        double total = 0.0;
        Map<String, Double> categoryTotals = new HashMap<>();

        for (Expense e : expenses) {
            total += e.getAmount();
            categoryTotals.put(e.getCategory(), categoryTotals.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        System.out.println("\n========= EXPENSE SUMMARY =========");
        System.out.printf("Total Spent: $%.2f\n", total);
        System.out.println("\nCategory Breakdown:");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            double percent = (entry.getValue() / total) * 100;
            System.out.printf(" - %-12s : $%-8.2f (%.1f%%)\n", entry.getKey(), entry.getValue(), percent);
        }
        System.out.println("===================================");
    }

    private void saveExpenses() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dataFile))) {
            for (Expense e : expenses) {
                writer.println(e.toCsvRow());
            }
        } catch (IOException e) {
            System.out.println("Could not save to file: " + e.getMessage());
        }
    }

    private void loadExpenses() {
        Path path = Paths.get(dataFile);
        if (!Files.exists(path)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String id = parts[0];
                    String cat = parts[1];
                    double amt = Double.parseDouble(parts[2]);
                    String desc = parts[3];
                    LocalDate date = LocalDate.parse(parts[4]);
                    expenses.add(new Expense(id, cat, amt, desc, date));
                }
            }
        } catch (Exception e) {
            System.out.println("Note: Starting with fresh expense data.");
        }
    }
}
