package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    private static final String JSON_STORE = ".data/userData.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private User currentUser;

    private JFrame frame;
    private Registration registration;
    private MainMenu mainMenu;

    public Controller() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        frame = new JFrame("Finance Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);  // Center the application window

        registration = new Registration();
        mainMenu = new MainMenu();

        frame.add(registration, BorderLayout.CENTER);
        frame.setVisible(true);

        registration.addRegisterButtonListener(new RegisterButtonListener());
        registration.addLoadButtonListener(new LoadButtonListener());
    }

    private void showMainMenu() {
        frame.getContentPane().removeAll();
        frame.add(mainMenu, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        mainMenu.addCreateBudgetButtonListener(new CreateBudgetButtonListener());
        mainMenu.addAddTransactionButtonListener(new AddTransactionButtonListener());
        mainMenu.addSetSavingsGoalButtonListener(new SetSavingsGoalButtonListener());
        mainMenu.addViewBudgetsButtonListener(new ViewBudgetsButtonListener());
        mainMenu.addViewTransactionsButtonListener(new ViewTransactionsButtonListener());
        mainMenu.addViewSavingsGoalsButtonListener(new ViewSavingsGoalsButtonListener());
        mainMenu.addSaveButtonListener(new SaveButtonListener());
        mainMenu.addLoadButtonListener(new LoadButtonListener());
        mainMenu.addExitButtonListener(e -> System.exit(0));
    }

    private String showInputDialog(String message) {
        return JOptionPane.showInputDialog(frame, message);
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    private class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = registration.getEmail();
            String username = registration.getUsername();
            String password = registration.getPassword();
            currentUser = new User(email, username, password);
            showMessageDialog("User registered successfully!");
            showMainMenu();
        }
    }

    private class CreateBudgetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = showInputDialog("Enter budget name:");
            String amountStr = showInputDialog("Enter budget amount:");

            try {
                double amount = Double.parseDouble(amountStr);
                JComboBox<Category> categoryComboBox = new JComboBox<>(Category.values());
                int result = JOptionPane.showConfirmDialog(frame, categoryComboBox, "Select Budget Category", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    Category category = (Category) categoryComboBox.getSelectedItem();
                    Budget budget = new Budget(name, amount, category);
                    currentUser.getBudgets().add(budget);
                    showMessageDialog("Budget created successfully.");
                } else {
                    showMessageDialog("Budget creation cancelled.");
                }
            } catch (NumberFormatException ex) {
                showMessageDialog("Invalid amount. Budget not created.");
            }
        }
    }

    private class AddTransactionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(showInputDialog("Enter transaction amount:"));
                String description = showInputDialog("Enter transaction description:");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(showInputDialog("Enter date of transaction (YYYY-MM-DD):"));
                String type = showInputDialog("Enter transaction type (Credit/Debit):");

                Transaction transaction = new Transaction(amount, description, date, type);
                currentUser.getTransactions().add(transaction);
                showMessageDialog("Transaction added successfully.");
            } catch (NumberFormatException | ParseException ex) {
                showMessageDialog("Invalid input. Transaction not added.");
            }
        }
    }

    private class SetSavingsGoalButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = showInputDialog("Enter savings goal name:");
                double currentAmount = Double.parseDouble(showInputDialog("Enter current savings amount:"));
                double targetAmount = Double.parseDouble(showInputDialog("Enter target savings amount:"));
                Date deadline = new SimpleDateFormat("yyyy-MM-dd").parse(showInputDialog("Enter deadline for savings goal (YYYY-MM-DD):"));

                SavingsGoal goal = new SavingsGoal(name, currentAmount, targetAmount, deadline);
                currentUser.getGoals().add(goal);
                showMessageDialog("Savings goal set successfully.");
            } catch (NumberFormatException | ParseException ex) {
                showMessageDialog("Invalid input. Savings goal not set.");
            }
        }
    }

    private class ViewBudgetsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder budgets = new StringBuilder("Budgets:\n");
            for (Budget budget : currentUser.getBudgets()) {
                budgets.append(budget).append("\n");
            }
            showMessageDialog(budgets.toString());
        }
    }

    private class ViewTransactionsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder transactions = new StringBuilder("Transactions:\n");
            for (Transaction transaction : currentUser.getTransactions()) {
                transactions.append(transaction).append("\n");
            }
            showMessageDialog(transactions.toString());
        }
    }

    private class ViewSavingsGoalsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder goals = new StringBuilder("Savings Goals:\n");
            for (SavingsGoal goal : currentUser.getGoals()) {
                goals.append(goal).append("\n");
            }
            showMessageDialog(goals.toString());
        }
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                jsonWriter.open();
                jsonWriter.write(currentUser);
                jsonWriter.close();
                showMessageDialog("Data saved successfully.");
            } catch (IOException ex) {
                showMessageDialog("Unable to save data: " + ex.getMessage());
            }
        }
    }

    private class LoadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                currentUser = jsonReader.read();
                showMessageDialog("Data loaded successfully!");
            } catch (IOException ex) {
                showMessageDialog("Unable to load data: " + ex.getMessage());
            }
        }
    }

    public static void showSplashScreen(Runnable onCompletion) {
        JWindow splashScreen = new JWindow();
        ImageIcon imageIcon = new ImageIcon("./data/image.png");
        JLabel label = new JLabel(imageIcon);
        splashScreen.getContentPane().add(label);
        splashScreen.setSize(600,600);
        splashScreen.setLocationRelativeTo(null); // Center the splash screen
        splashScreen.setVisible(true);

        Timer timer = new Timer(3000, e -> {
            splashScreen.setVisible(false);
            splashScreen.dispose();
            onCompletion.run();
        });
        timer.setRepeats(false);
        timer.start();
    }
}
