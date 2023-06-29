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
        System.out.println("enter name, second name or email of person you want to delete: ");
        String initials = scan.nextLine().toLowerCase().trim();

        List<Contact> searchList = appContactBook.searchContact(initials);
        if (searchList.isEmpty()){
            System.out.println("there are no persons with such initials");
        }
        else{
            Helpers.printThisList(searchList);
            if (searchList.size() == 1){
                boolean choice = Helpers.choiceToDelete(scan);
                if(choice) {
                    appContactBook.deleteContact(searchList.get(0));
                }
            }
            if (searchList.size() > 1){
                int number;
                while (true) {
                    System.out.println("which contact to delete?(number): ");
                    number = Integer.parseInt(scan.nextLine());
                    if (number >= 0 && number <= searchList.size()){
                        break;
                    }
                    System.out.println("invalid number");
                }
                List<Contact> oneContact = new ArrayList<>();
                oneContact.add(searchList.get(number-1));
                Helpers.printThisList(oneContact);
                boolean choice = Helpers.choiceToDelete(scan);
                if (choice) {
                    appContactBook.deleteContact(searchList.get(number - 1));
                }
            }
        }
    }
}
