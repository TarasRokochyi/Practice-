package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;

import java.util.Scanner;

public class QuitAction implements Action{

    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        boolean state = appContactBook.saveContacts();
        boolean choice;
        if (state){
            System.exit(0);
        }
        else{
            System.out.println("your changes is not saved, do you want to quit?(y/n):  ");
            choice = Helpers.choiceToDo(scan);
            if (choice){
                System.exit(0);
            }
        }
    }
}
