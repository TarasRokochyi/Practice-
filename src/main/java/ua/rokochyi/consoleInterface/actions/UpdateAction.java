package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.Person;
import ua.rokochyi.domain.data.Number;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateAction implements Action{
    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        System.out.println("enter name or second name or email or number of person you want to update: ");
        String initials = scan.nextLine().toLowerCase().trim();
        List<Contact> searchList = appContactBook.searchContact(initials);
        List<String> items = new ArrayList<>();
        if (searchList.isEmpty()){
            System.out.println("there are no persons with such initials");
        }
        else if (searchList.size() == 1){
            Helpers.printThisList(searchList);
            System.out.println("update this contact?(y/n): ");
            boolean choice = Helpers.choiceToDo(scan);
            if(choice) {
                examineUpdate(appContactBook, searchList, scan, items);
            }
        }
        else {
            items.clear();
            for(Contact contact: searchList){
                items.add(contact.toString());
            }
            System.out.println();
            int chosen_item = Helpers.chooseItem(items, scan);
            List<Contact> oneContact = new ArrayList<>();
            oneContact.add(searchList.get(chosen_item-1));
            Helpers.printThisList(oneContact);
            System.out.println("update this contact?(y/n): ");
            boolean choice = Helpers.choiceToDo(scan);
            if (choice) {
                examineUpdate(appContactBook, oneContact, scan, items);
            }
        }
    }

    public void examineUpdate(AppContactBook appContactBook, List<Contact> searchList, Scanner scan, List<String> items){

        while (true) {
            items.clear();
            items.add("person's name, second name, birthday");
            items.add("email");
            items.add("phone numbers");
            items.add("update all");
            items.add("done");

            int chosen_item = Helpers.chooseItem(items, scan);

            switch(chosen_item){
                case 1:
                    System.out.println("enter name: ");
                    String name = scan.nextLine().trim();

                    System.out.println("enter second name: ");
                    String second_name = scan.nextLine().trim();

                    LocalDate birthdayDate = Helpers.getLocalDate(scan);

                    appContactBook.updateContact(name, second_name, birthdayDate, searchList.get(0).email(), searchList.get(0).phoneNumbers(), searchList.get(0));
                    break;
                case 2:
                    System.out.println("enter email: ");
                    String email = scan.nextLine();

                    appContactBook.updateContact(searchList.get(0).person().name(), searchList.get(0).person().second_name(), searchList.get(0).person().birthday(), email, searchList.get(0).phoneNumbers(), searchList.get(0));
                    break;
                case 3:
                    Helpers.printNumbers(searchList.get(0).phoneNumbers());
                    System.out.println();


                    items.clear();
                    items.add("create new list of numbers");
                    items.add("change given list of numbers");

                    chosen_item = Helpers.chooseItem(items, scan);

                    if(chosen_item == 1){
                        List<Number> numbers = Helpers.getNumbers(scan);
                        appContactBook.updateContact(searchList.get(0).person().name(), searchList.get(0).person().second_name(), searchList.get(0).person().birthday(), searchList.get(0).email(), numbers, searchList.get(0));
                    }
                    else if(chosen_item == 2){
                        while (true) {
                            items.clear();
                            items.add("add new number");
                            items.add("delete number");
                            items.add("done");
                            chosen_item = Helpers.chooseItem(items, scan);
                            if (chosen_item == 1){
                                System.out.println("enter provider of number: ");
                                String provider = scan.nextLine().trim();

                                System.out.println("enter number of that provider: ");
                                String phoneNumber = scan.nextLine().trim();

                                searchList.get(0).phoneNumbers().add(new Number(provider, phoneNumber));
                            }
                            else if (chosen_item == 2){
                                System.out.println("which phone number you want to delete(number): ");
                                items.clear();
                                for(Number number: searchList.get(0).phoneNumbers()){
                                    items.add(number.provider()+": "+ number.phoneNumber());
                                }
                                chosen_item = Helpers.chooseItem(items, scan);
                                searchList.get(0).phoneNumbers().remove(chosen_item - 1);
                            }
                            else if (chosen_item == 3){
                                break;
                            }
                            Helpers.printNumbers(searchList.get(0).phoneNumbers());
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("enter name: ");
                    name = scan.nextLine().trim();

                    System.out.println("enter second name: ");
                    second_name = scan.nextLine().trim();

                    birthdayDate = Helpers.getLocalDate(scan);

                    System.out.println("enter email: ");
                    email = scan.nextLine().trim();

                    List<Number> phoneNumbers = Helpers.getNumbers(scan);

                    appContactBook.updateContact(name, second_name, birthdayDate, email, phoneNumbers, searchList.get(0));
                    break;
                case 5:
                    return;
            }
        }
    }

}
