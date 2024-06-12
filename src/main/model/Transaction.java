package model;

import java.util.Date;

public class Transaction {

    // Fields for Transaction class
    private String transactionId; // Unique identifier for the transaction
    private Date date; // Date of the transaction
    private Double amount; // Amount of money involved in the transaction
    private Category category; // Category of the transaction (e.g., groceries, rent)
    private String description; // Description or note about the transaction
    private String type; // Type of transaction (income or expense)
    private String userId; // Reference to the user associated with the transaction

    // Parameterized constructor to initialize Transaction object
    public Transaction( Double amount, String description, Date date, String type) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.type = type;
    }


    // Getter method for date
    public Date getDate() {
        return date;
    }

    // Setter method for date
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter method for amount
    public Double getAmount() {
        return amount;
    }

    // Setter method for amount
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // Getter method for category
    public Category getCategory() {
        return category;
    }

    // Setter method for category
    public void setCategory(Category category) {
        this.category = category;
    }

    // Getter method for description
    public String getDescription() {
        return description;
    }

    // Setter method for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter method for type
    public String getType() {
        return type;
    }

    // Setter method for type
    public void setType(String type) {
        this.type = type;
    }

}
