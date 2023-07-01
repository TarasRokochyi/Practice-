package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.Number;

import java.util.List;
import java.util.Scanner;

public class SearchAction implements Action{
    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        System.out.println("enter name or second name or email of person you want to search: ");
        String initials = scan.nextLine().toLowerCase().trim();
        List<Contact> searchList = appContactBook.searchContact(initials);
        if (searchList.isEmpty()){
            System.out.println("there are no persons with such initials");
        }
        else{
            Helpers.printThisList(searchList);
        }
    }
}
