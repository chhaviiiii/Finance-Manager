package model;

import java.util.Date;
import java.util.List;

public class Report {

    // Fields for Report class
    private String reportID; // Unique identifier for the report
    private String type; // Type of report (e.g., monthly, yearly, custom)
    private Date startDate; // Start date of the report period
    private Date endDate; // End date of the report period
    private List<Transaction> transactions; // List of transactions included in the report
    private Double totalIncome; // Total income in the report period
    private Double totalExpenses; // Total expenses in the report period
    private String userID; // Reference to the user associated with the report

    // Parameterized constructor to initialize Report object
    public Report(String reportID, String type, Date startDate, Date endDate, List<Transaction> transactions, Double totalIncome, Double totalExpenses, String userID) {
        this.reportID = reportID;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transactions = transactions;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.userID = userID;
    }

    // Getter method for reportID
    public String getReportID() {
        return reportID;
    }

    // Setter method for reportID
    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    // Getter method for type
    public String getType() {
        return type;
    }

    // Setter method for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter method for startDate
    public Date getStartDate() {
        return startDate;
    }

    // Setter method for startDate
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    // Getter method for endDate
    public Date getEndDate() {
        return endDate;
    }

    // Setter method for endDate
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // Getter method for transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Setter method for transactions
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // Getter method for totalIncome
    public Double getTotalIncome() {
        return totalIncome;
    }

    // Setter method for totalIncome
    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    // Getter method for totalExpenses
    public Double getTotalExpenses() {
        return totalExpenses;
    }

    // Setter method for totalExpenses
    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    // Getter method for userID
    public String getUserID() {
        return userID;
    }

    // Setter method for userID
    public void setUserID(String userID) {
        this.userID = userID;
    }
}
