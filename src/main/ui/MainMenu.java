package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private JButton createBudgetButton;
    private JButton addTransactionButton;
    private JButton setSavingsGoalButton;
    private JButton viewBudgetsButton;
    private JButton viewTransactionsButton;
    private JButton viewSavingsGoalsButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton exitButton;

    public MainMenu() {
        setLayout(new GridBagLayout());
        setBackground(new Color(24, 70, 50)); // Forest green background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        createBudgetButton = createButton("Create Budget");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(createBudgetButton, gbc);

        addTransactionButton = createButton("Add Transaction");
        gbc.gridy = 1;
        add(addTransactionButton, gbc);

        setSavingsGoalButton = createButton("Set Savings Goal");
        gbc.gridy = 2;
        add(setSavingsGoalButton, gbc);

        viewBudgetsButton = createButton("View Budgets");
        gbc.gridy = 3;
        add(viewBudgetsButton, gbc);

        viewTransactionsButton = createButton("View Transactions");
        gbc.gridy = 4;
        add(viewTransactionsButton, gbc);

        viewSavingsGoalsButton = createButton("View Savings Goals");
        gbc.gridy = 5;
        add(viewSavingsGoalsButton, gbc);

        saveButton = createButton("Save Data");
        gbc.gridy = 6;
        add(saveButton, gbc);

        loadButton = createButton("Load Data");
        gbc.gridy = 7;
        add(loadButton, gbc);

        exitButton = createButton("Exit");
        gbc.gridy = 8;
        add(exitButton, gbc);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(255, 215, 0)); // Gold background
        button.setForeground(Color.BLACK); // Black text
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Black border
        return button;
    }

    public void addCreateBudgetButtonListener(ActionListener listener) {
        createBudgetButton.addActionListener(listener);
    }

    public void addAddTransactionButtonListener(ActionListener listener) {
        addTransactionButton.addActionListener(listener);
    }

    public void addSetSavingsGoalButtonListener(ActionListener listener) {
        setSavingsGoalButton.addActionListener(listener);
    }

    public void addViewBudgetsButtonListener(ActionListener listener) {
        viewBudgetsButton.addActionListener(listener);
    }

    public void addViewTransactionsButtonListener(ActionListener listener) {
        viewTransactionsButton.addActionListener(listener);
    }

    public void addViewSavingsGoalsButtonListener(ActionListener listener) {
        viewSavingsGoalsButton.addActionListener(listener);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }

    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
