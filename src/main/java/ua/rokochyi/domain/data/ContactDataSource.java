package ua.rokochyi.domain.data;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class ContactDataSource {
    private final JsonConverter jsonConverter;

    public ContactDataSource(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    public List<Contact> readJson(Path path) throws IOException {
        //get json string from file
        String jsonString = Files.readString(path);
        return jsonConverter.fromJson(jsonString);
    }

    public void writeJson(List<Contact> contacts, Path path) throws IOException {
        String jsonContent = jsonConverter.toJson(contacts);
        //write json to file
        Files.writeString(path, jsonContent);
    }
}
