package persistence;

import model.User;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonWriter {
    private PrintWriter writer;
    private String destination;

    public JsonWriter(String destination) {
        this.destination = destination;
    }

    public void open() throws IOException {
        writer = new PrintWriter(new FileWriter(destination));
    }

    public void write(User user) {
        JSONObject json = user.toJson();
        saveToFile(json.toString(4));
    }

    public void close() {
        writer.close();
    }

    private void saveToFile(String json) {
        writer.print(json);
    }
}
