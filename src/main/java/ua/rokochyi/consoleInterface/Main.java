package ua.rokochyi.consoleInterface;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.ContactDataSource;
import ua.rokochyi.domain.data.GsonConverter;
import ua.rokochyi.domain.data.JsonConverter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        JsonConverter gsonConverter = new GsonConverter(gson);
        ContactDataSource dataSource = new ContactDataSource(gsonConverter);
        List<Contact> contacts = dataSource.readJson("ContactBook");
        AppContactBook contactBook = new AppContactBook(dataSource, contacts);
    }
}