package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class User implements Writable {

    // Fields for User class
    private String username; // Username for the user
    private String password; // Password for the user (should be securely stored)
    private String email; // Email address of the user
    private List<Budget> budgets; // List of budgets associated with the user
    private List<Transaction> transactions; // List of transactions associated with the user
    private List<SavingsGoal> goals; // List of savings goals associated with the user


    // Parameterized constructor to initialize User object
    public User(String email, String username, String password) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.budgets = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Setter method for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Setter method for password
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    // Getter method for email
    public String getEmail() {
        return email;
    }

    // Setter method for email
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    // Getter method for budgets
    public List<Budget> getBudgets() {
        return budgets;
    }

    // Setter method for budgets
    public void setBudgets(List<Budget> newBudgets) {
        this.budgets = newBudgets;
    }

    // Getter method for transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Setter method for transactions
    public void setTransactions(List<Transaction> newTransactions) {
        this.transactions = newTransactions;
    }

    // Getter method for goals
    public List<SavingsGoal> getGoals() {
        return goals;
    }

    // Setter method for goals
    public void setGoals(List<SavingsGoal> newGoals) {
        this.goals = newGoals;
    }

    // EFFECTS: returns string representation of this thingy
    public String toString() {return "Username: " + username + "\n Email: " + email;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Username", username);
        json.put("Password", password);
        json.put("Email", email);
        json.put("Budgets", new JSONArray(budgets));
        json.put("Transactions", new JSONArray(transactions));
        json.put("Savings Goals", new JSONArray(goals));
        return json;
    }
}
