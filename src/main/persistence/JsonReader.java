package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    public User read() throws IOException {
        String jsonData = this.readFile(this.source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return this.parseUser(jsonObject);
    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8);

        try {
            stream.forEach((s) -> {
                contentBuilder.append(s);
            });
        } catch (Throwable var7) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }
            }

            throw var7;
        }

        if (stream != null) {
            stream.close();
        }

        return contentBuilder.toString();
    }

    private User parseUser(JSONObject jsonObject) {
        String email = jsonObject.getString("Email");
        String username = jsonObject.getString("Username");
        String password = jsonObject.getString("Password");
        User user = new User(email, username, password);
        this.addBudgets(user, jsonObject);
        this.addTransactions(user, jsonObject);
        this.addGoals(user, jsonObject);
        return user;
    }

    private void addBudgets(User user, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Budgets");
        for (Object json : jsonArray) {
            JSONObject nextBudget = (JSONObject) json;
            this.addBudget(user, nextBudget);
        }
    }

    private void addBudget(User user, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double amount = jsonObject.getDouble("amount");
        Category category = Category.valueOf(jsonObject.getString("category"));
        Budget budget = new Budget(name, amount, category);
        user.getBudgets().add(budget);
    }

    private void addTransactions(User user, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Transactions");
        for (Object json : jsonArray) {
            JSONObject nextTransaction = (JSONObject) json;
            this.addTransaction(user, nextTransaction);
        }
    }

    private void addTransaction(User user, JSONObject jsonObject) {
        double amount = jsonObject.getDouble("amount");
        String description = jsonObject.getString("description");
        String dateString = jsonObject.getString("date");
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Transaction not added.");
            return;
        }
        String type = jsonObject.getString("type");
        Transaction transaction = new Transaction(amount, description, date, type);
        user.getTransactions().add(transaction);
    }

    private void addGoals(User user, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Savings Goals");
        for (Object json : jsonArray) {
            JSONObject nextGoal = (JSONObject) json;
            this.addGoal(user, nextGoal);
        }
    }

    private void addGoal(User user, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double currentAmount = jsonObject.getDouble("currentAmount");
        double targetAmount = jsonObject.getDouble("targetAmount");
        String deadlineString = jsonObject.getString("deadline");
        Date deadline;
        try {
            deadline = new SimpleDateFormat("yyyy-MM-dd").parse(deadlineString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Savings goal not added.");
            return;
        }
        SavingsGoal goal = new SavingsGoal(name, currentAmount, targetAmount, deadline);
        user.getGoals().add(goal);
    }
}
