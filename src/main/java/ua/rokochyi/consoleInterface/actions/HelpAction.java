package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;

import java.util.Scanner;

public class HelpAction implements Action{
    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        System.out.println("add / delete / update / list / search / sort / save / help / quit");
    }
}
