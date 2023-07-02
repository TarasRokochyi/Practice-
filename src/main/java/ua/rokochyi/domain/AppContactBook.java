package ua.rokochyi.domain;

import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.ContactDataSource;
import ua.rokochyi.domain.data.Person;
import ua.rokochyi.domain.data.Number;

import java.time.LocalDate;
import java.util.*;

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
    public void updateContact(String name, String second_name, LocalDate birthdayDate, String email, List<Number> numbers, Contact contactToDelete) {
        for (int i = 0; i < contacts.size(); i++){
            if(contacts.get(i) == contactToDelete){
                contacts.remove(i);
            }
        }
        addContact(name, second_name, birthdayDate, email, numbers);
    }

    @Override
    public void listContact() {
        int count = 1;
        System.out.println();
        for (Contact contact: contacts){
            System.out.println(count);
            System.out.println(contact.toString());
            count++;
        }
    }

    @Override
    public List<Contact> searchContact(String initials) {
        List<Contact> searchList = new ArrayList<>();
        for (Contact contact: contacts){
            if (contact.person().name().toLowerCase().contains(initials) ||
                    contact.person().second_name().toLowerCase().contains(initials) ||
                    contact.email().toLowerCase().contains(initials)) {
                searchList.add(contact);
            }
            for (Number number: contact.phoneNumbers()){
                if (number.phoneNumber().contains(initials)){
                    searchList.add(contact);
                }
            }
        }
        return searchList;
    }

    @Override
    public void sortContacts(int chosen_item) {
        switch (chosen_item){
            case 1:
                contacts.sort(Comparator.comparing(o -> o.person().name()));
                break;
            case 2:
                contacts.sort(Comparator.comparing(o -> o.person().second_name()));
                break;
            case 3:
                contacts.sort(Comparator.comparing(o -> o.person().birthday()));
                break;
            case 4:
                contacts.sort(Comparator.comparing(o -> o.email()));
                break;
        }
    }

    @Override
    public boolean saveContacts() {
        return contactDataSource.writeJson(contacts);
    }
}
