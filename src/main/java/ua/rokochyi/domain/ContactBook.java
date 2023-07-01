package ua.rokochyi.domain;

import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.Number;
import ua.rokochyi.domain.data.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface ContactBook {

    void addContact(String name, String second_name, LocalDate birthdayDate, String email, List<Number> numbers);
    void deleteContact(Contact contact);
    void updateContact(String name, String second_name, LocalDate birthdayDate, String email, List<Number> numbers, Contact contactToDelete);
    void listContact();
    List<Contact> searchContact(String initials);
    List<Contact> sortContacts();
    boolean saveContacts();

}
