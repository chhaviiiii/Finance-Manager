package model;

public class Budget {

    // Fields for Budget class
    private String name; // Name of the budget
    private Double amount; // Total amount allocated for the budget
    private Category category; // Category of expenses covered by the budget

    // Parameterized constructor to initialize Budget object
    public Budget(String name, Double amount, Category category) {

        this.name = name;
        this.amount = amount;
        this.category = category;

    }


    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
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

}
