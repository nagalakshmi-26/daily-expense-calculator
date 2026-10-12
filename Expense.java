package src;

import java.time.LocalDate;

public class Expense {
    private String id;
    private String category;
    private double amount;
    private String description;
    private LocalDate date;

    public Expense(String id, String category, double amount, String description, LocalDate date) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toCsvRow() {
        return String.format("%s,%s,%.2f,%s,%s", id, category, amount, description.replace(",", " "), date);
    }

    @Override
    public String toString() {
        return String.format("%-6s | %-12s | $%-8.2f | %-12s | %s", id, category, amount, date, description);
    }
}
