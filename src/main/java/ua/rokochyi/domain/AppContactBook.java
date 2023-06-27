package ua.rokochyi.domain;

import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.ContactDataSource;

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
    public void saveChanges(){
        contactDataSource.writeJson(contacts);
    }
}
