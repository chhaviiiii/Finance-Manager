package model;

import java.util.Date;

public class SavingsGoal {

    // Fields for SavingsGoal class
    private String name; // Name of the savings goal
    private Double targetAmount; // Target amount to be saved
    private Double currentAmount; // Amount saved so far
    private Date deadline; // Deadline to achieve the savings goal
    private String userID; // Reference to the user associated with the savings goal

    // Parameterized constructor to initialize SavingsGoal object
    public SavingsGoal(String name, Double currentAmount,Double targetAmount, Date deadline) {

        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.deadline = deadline;
        this.userID = userID;
    }


    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for targetAmount
    public Double getTargetAmount() {
        return targetAmount;
    }

    // Setter method for targetAmount
    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    // Getter method for currentAmount
    public Double getCurrentAmount() {
        return currentAmount;
    }

    // Setter method for currentAmount
    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    // Getter method for deadline
    public Date getDeadline() {
        return deadline;
    }

    // Setter method for deadline
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

}
