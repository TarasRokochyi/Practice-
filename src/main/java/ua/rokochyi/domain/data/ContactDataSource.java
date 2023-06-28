package ua.rokochyi.domain.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class ContactDataSource {
    private final JsonConverter jsonConverter;

    private final String fileName;

    public ContactDataSource(JsonConverter jsonConverter, String fileName) {
        this.jsonConverter = jsonConverter;
        this.fileName = fileName;
    }

    public List<Contact> readJson() {
        try {
            Path path = Paths.get(fileName);
            String jsonString = Files.readString(path);
            return jsonConverter.fromJson(jsonString);
        }
        catch (IOException e){
            System.out.println("Error while reading from file " + fileName + "\nError message - " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean writeJson(List<Contact> contacts) {
        try {
            Path path = Paths.get(fileName);
            String jsonContent = jsonConverter.toJson(contacts);
            Files.writeString(path, jsonContent);
            return true;
        }
        catch(IOException e){
            System.out.println("Error while writing to file "+ fileName + "\nError message - " + e.getMessage());
            return false;
        }
    }
}
