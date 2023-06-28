package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;

import java.util.Scanner;

public class QuitAction implements Action{

    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        boolean state = appContactBook.saveContacts();
        String choice;
        if (state){
            System.exit(0);
        }
        else{
            while(true) {
                System.out.println("your changes is not saved, do you want to quit?(y/n):  ");
                choice = scan.nextLine().toLowerCase().trim();
                if (choice.equals("y") || choice.equals("n")){
                    break;
                }
            }
            if (choice.equals("y")){
                System.exit(0);
            }
        }
    }
}
