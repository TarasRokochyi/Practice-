package ua.rokochyi.domain;

import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.ContactDataSource;
import ua.rokochyi.domain.data.Person;
import ua.rokochyi.domain.data.Number;

import java.time.LocalDate;
import java.util.List;

public class AppContactBook implements ContactBook{

    private final ContactDataSource contactDataSource;

    private List<Contact> contacts;

    public AppContactBook(ContactDataSource contactDataSource, List<Contact> contacts) {
        this.contactDataSource = contactDataSource;
        this.contacts = contacts;
    }

    @Override
    public void addContact(String name, String second_name, LocalDate birthdayDate, String email, List<Number> phoneNumbers) {
        Person person = new Person(name, second_name, birthdayDate);
        contacts.add(new Contact(person, email, phoneNumbers));
    }

    @Override
    public void deleteContact() {

    }

    @Override
    public void updateContact() {

    }

    @Override
    public void listContact() {
        for (Contact contact: contacts){
            System.out.println();
            System.out.println("initials: " + contact.person().name() + " " + contact.person().second_name() + "\n"+
                               "birthday: " + contact.person().birthday());
            for (Number number: contact.phoneNumbers()){
                System.out.println(number.provider()+": "+ number.phoneNumber());
            }
        }
        System.out.println();
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
    public boolean saveContacts() {
        return contactDataSource.writeJson(contacts);
    }
}
