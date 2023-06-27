package ua.rokochyi.domain;

import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.ContactDataSource;
import ua.rokochyi.domain.data.Person;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AppContactBook implements ContactBook{

    private final ContactDataSource contactDataSource;

    private List<Contact> contacts;

    public AppContactBook(ContactDataSource contactDataSource, List<Contact> contacts) {
        this.contactDataSource = contactDataSource;
        this.contacts = contacts;
    }

    @Override
    public void addContact() {

    }

    @Override
    public void deleteContact() {

    }

    @Override
    public void updateContact() {

    }

    @Override
    public List<Contact> searchContact() {
        return null;
    }

    @Override
    public List<Contact> sortContacts() {
        return null;
    }

    @Override
    public void saveContacts(String fileName) {
        try {
            Path path = Paths.get(fileName);
            contactDataSource.writeJson(contacts, path);
        }catch(IOException e){
            System.out.println("Error while writing to file "+ fileName + "\nError message - " + e.getMessage());
            System.exit(1);
        }
    }
}
