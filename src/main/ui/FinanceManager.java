package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FinanceManager {

    private User currentUser;
    private static final String JSON_STORE = "./data/userData.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public static void main(String[] args) {
        FinanceManager app = new FinanceManager();
        app.run();
    }

    public FinanceManager() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Budget Management System!");
        System.out.println("Please register a new user to begin.");

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        currentUser = new User(email, username, password);

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createBudget(scanner);
                    break;
                case 2:
                    addTransaction(scanner);
                    break;
                case 3:
                    setSavingsGoal(scanner);
                    break;
                case 4:
                    viewBudgets();
                    break;
                case 5:
                    viewTransactions();
                    break;
                case 6:
                    viewSavingsGoals();
                    break;
                case 7:
                    saveData();
                    break;
                case 8:
                    loadData();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Budget Management System. Goodbye!");
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Create Budget");
        System.out.println("2. Add Transaction");
        System.out.println("3. Set Savings Goal");
        System.out.println("4. View Budgets");
        System.out.println("5. View Transactions");
        System.out.println("6. View Savings Goals");
        System.out.println("7. Save");
        System.out.println("8. Load Data");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createBudget(Scanner scanner) {
        System.out.print("Enter budget name: ");
        String name = scanner.nextLine();
        System.out.print("Enter budget amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter budget category: ");
        String categoryStr = scanner.nextLine().toUpperCase();
        Category category;
        try {
            category = Category.valueOf(categoryStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category. Budget not created.");
            return;
        }

        Budget budget = new Budget(name, amount, category);
        currentUser.getBudgets().add(budget);
        System.out.println("Budget created successfully.");
    }

    private void addTransaction(Scanner scanner) {
        System.out.print("Enter transaction amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter transaction description: ");
        String description = scanner.nextLine();
        System.out.print("Enter date of transaction (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Transaction not added.");
            return;
        }
        System.out.print("Enter transaction type (Credit/Debit): ");
        String type = scanner.nextLine();

        Transaction transaction = new Transaction(amount, description, date, type);
        currentUser.getTransactions().add(transaction);
        System.out.println("Transaction added successfully.");
    }

    private void setSavingsGoal(Scanner scanner) {
        System.out.print("Enter savings goal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter current savings amount: ");
        double currentAmount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter target savings amount: ");
        double targetAmount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter deadline for savings goal (YYYY-MM-DD): ");
        String deadlineString = scanner.nextLine();
        Date deadline;
        try {
            deadline = new SimpleDateFormat("yyyy-MM-dd").parse(deadlineString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Savings goal not set.");
            return;
        }

        SavingsGoal goal = new SavingsGoal(name, currentAmount, targetAmount, deadline);
        currentUser.getGoals().add(goal);
        System.out.println("Savings goal set successfully.");
    }

    private void viewBudgets() {
        System.out.println("Budgets:");
        for (Budget budget : currentUser.getBudgets()) {
            System.out.println(budget);
        }
    }

    private void viewTransactions() {
        System.out.println("Transactions:");
        for (Transaction transaction : currentUser.getTransactions()) {
            System.out.println(transaction);
        }
    }

    private void viewSavingsGoals() {
        System.out.println("Savings Goals:");
        for (SavingsGoal goal : currentUser.getGoals()) {
            System.out.println(goal);
        }
    }

    private void saveData() {
        try {
            jsonWriter.open();
            jsonWriter.write(currentUser);
            jsonWriter.close();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Unable to save data: " + e.getMessage());
        }
    }

    private void loadData() {
        try {
            currentUser = jsonReader.read();
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Unable to load data: " + e.getMessage());
        }
    }
}
