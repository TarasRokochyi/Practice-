package ua.rokochyi.domain;

import ua.rokochyi.domain.data.Contact;

import java.io.IOException;
import java.util.List;

public interface ContactBook {

    void addContact();
    void deleteContact();
    void updateContact();
    List<Contact> searchContact();
    List<Contact> sortContacts();
    void saveContacts(String fileName);

}
