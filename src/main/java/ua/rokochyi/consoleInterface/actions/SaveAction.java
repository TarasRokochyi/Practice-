package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;

import java.util.Scanner;

public class SaveAction implements Action{

    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        appContactBook.saveContacts();
    }
}
