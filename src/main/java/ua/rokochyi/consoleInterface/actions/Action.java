package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;

import java.util.Scanner;

public interface Action {
    void Operate(AppContactBook appContactBook, Scanner scan);
}
