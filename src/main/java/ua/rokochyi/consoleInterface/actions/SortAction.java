package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortAction implements Action{
    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        System.out.println("by which criterion you want to sort? ");
        List<String> items = new ArrayList<>();
        items.add("by name");
        items.add("by second name");
        items.add("by age");
        items.add("by email");
        int chosen_item = Helpers.chooseItem(items, scan);
        appContactBook.sortContacts(chosen_item);
    }
}
