package main.java.com.app.database;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Provider {
    private String path;

    public Provider(String path) {
        this.path = path;
    }

    public String readContent() throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
