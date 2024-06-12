package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Registration extends JPanel {
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loadButton;

    public Registration() {
        setLayout(new GridBagLayout());
        setBackground(new Color(24, 70, 50)); // Forest green background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(createLabel("Email:"), gbc);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(createLabel("Username:"), gbc);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(createLabel("Password:"), gbc);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25)); // Set preferred size
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);

        registerButton = createButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(registerButton, gbc);

        loadButton = createButton("Load Data");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(loadButton, gbc);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE); // White text
        return label;
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

    public String getEmail() {
        return emailField.getText();
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addRegisterButtonListener(ActionListener listener) {
        registerButton.addActionListener(listener);
    }

    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }
}
