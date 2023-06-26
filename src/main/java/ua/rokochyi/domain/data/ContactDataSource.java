package ua.rokochyi.domain.data;

import java.util.List;
public class ContactDataSource {
    private final JsonConverter jsonConverter;

    public ContactDataSource(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    public List<Contact> readJson(String fileName){
        //get json string from file
        return jsonConverter.fromJson("");
    }

    public void writeJson(List<Contact> contacts){
        String jsonContent = jsonConverter.toJson(contacts);
        //write json to file
    }
}
