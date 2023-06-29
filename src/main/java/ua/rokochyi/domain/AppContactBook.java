package ua.rokochyi.domain;

import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.ContactDataSource;
import ua.rokochyi.domain.data.Person;
import ua.rokochyi.domain.data.Number;

import java.time.LocalDate;
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
    public void addContact(String name, String second_name, LocalDate birthdayDate, String email, List<Number> phoneNumbers) {
        Person person = new Person(name, second_name, birthdayDate);
        contacts.add(new Contact(person, email, phoneNumbers));
    }

    @Override
    public void deleteContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++){
            if (contact == contacts.get(i)){
                contacts.remove(i);
            }
        }
        System.out.println("this contact has been deleted");
    }

    @Override
    public void updateContact() {

    }

    @Override
    public void listContact() {
        int count = 1;
        for (Contact contact: contacts){
            System.out.println();
            System.out.println(count);
            System.out.println("initials: " + contact.person().name() + " " + contact.person().second_name() +"\n"+
                               "birthday: " + contact.person().birthday()+"\n"+
                               "email: " + contact.email());
            for (Number number: contact.phoneNumbers()){
                System.out.println(number.provider()+": "+ number.phoneNumber());
            }
            count++;
        }
        System.out.println();
    }

    @Override
    public List<Contact> searchContact(String initials) {
        List<Contact> searchList = new ArrayList<>();
        for (Contact contact: contacts){
            if (initials.contains(contact.person().name().toLowerCase()) ||
                    initials.contains(contact.person().second_name().toLowerCase()) ||
                    initials.contains(contact.email().toLowerCase()) ||
                    contact.person().name().toLowerCase().contains(initials) ||
                    contact.person().second_name().toLowerCase().contains(initials) ||
                    contact.email().toLowerCase().contains(initials)) {
                searchList.add(contact);
            }
        }
        return searchList;
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
