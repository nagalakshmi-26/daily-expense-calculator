# Daily Expense Calculator 💰

A clean, practical console application written in Java for tracking daily spending, viewing category distributions, and automatically persisting records into a CSV file.

![Java Version](https://img.shields.io/badge/Java-8%2B-orange.svg)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

---

## ✨ Features
- **Quick Logging**: Log expenses with categories (Food, Transport, Bills, Leisure, Other).
- **Auto CSV Persistence**: Saves expenses to `expenses.csv` so data is never lost when restarting the program.
- **Spending Analytics**: Displays total expenditure and percentage breakdown by category.
- **Formatted Table View**: Clean CLI layout showing IDs, categories, dates, and amounts.

---

## 🚀 How to Run

### Option 1: Quick Run (Windows)
Double-click `run.bat` or run:
```cmd
run.bat
```

### Option 2: Manual Compile & Run
```bash
# Compile
javac src/*.java

# Run
java src.Main
```

---

## 📋 Sample Output
```text
--------------------------------------------------------------------------------
ID     | Category     | Amount    | Date         | Description
--------------------------------------------------------------------------------
E1     | Food         | $12.50    | 2026-10-12   | Lunch sandwich & coffee
E2     | Transport    | $4.00     | 2026-10-12   | Bus ticket
--------------------------------------------------------------------------------

========= EXPENSE SUMMARY =========
Total Spent: $16.50

Category Breakdown:
 - Food         : $12.50    (75.8%)
 - Transport    : $4.00     (24.2%)
===================================
```

---

## 📤 Push this project to GitHub
Open a terminal inside this directory:
```bash
git init
git add .
git commit -m "Initial commit: Daily Expense Calculator"
git branch -M main
git remote add origin https://github.com/<YOUR_GITHUB_USERNAME>/daily-expense-calculator.git
git push -u origin main
```
