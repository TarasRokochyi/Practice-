package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteAction implements Action{
    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        System.out.println("enter name or second name or email of person you want to delete: ");
        String initials = scan.nextLine().toLowerCase().trim();

        List<Contact> searchList = appContactBook.searchContact(initials);
        List<String> items = new ArrayList<>();
        if (searchList.isEmpty()){
            System.out.println("there are no persons with such initials");
        }
        else if (searchList.size() == 1){
            Helpers.printThisList(searchList);
            System.out.println("delete this contact?(y/n): ");
            boolean choice = Helpers.choiceToDo(scan);
            if(choice) {
                appContactBook.deleteContact(searchList.get(0));
            }
        }
        else {
            for(Contact contact: searchList){
                items.add(contact.toString());
            }
            System.out.println();
            int chosen_item = Helpers.chooseItem(items, scan);
            List<Contact> oneContact = new ArrayList<>();
            oneContact.add(searchList.get(chosen_item-1));
            Helpers.printThisList(oneContact);
            System.out.println("delete this contact?(y/n): ");
            boolean choice = Helpers.choiceToDo(scan);
            if (choice) {
                appContactBook.deleteContact(searchList.get(chosen_item - 1));
            }
        }
    }
}
