package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;

import java.util.Scanner;

public class SaveAction implements Action{

    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        boolean success = appContactBook.saveContacts();
        if (success) {
            System.out.println("you have saved all the changes");
        }
        else{
            System.out.println("THERE IS SOME TROUBLE!!! YOU HAVEN'T SAVED ALL THE CHANGES!!!");
        }
    }
}
