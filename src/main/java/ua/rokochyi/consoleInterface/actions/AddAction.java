package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.Number;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AddAction implements Action {
    @Override
    public void Operate(AppContactBook appContactBook, Scanner scan) {
        System.out.println("enter name: ");
        String name = scan.nextLine().trim();
        System.out.println("enter second name: ");
        String second_name = scan.nextLine().trim();
        System.out.println("enter birthday(yyyy-mm-dd): ");
        String date = scan.nextLine().trim();
        LocalDate birthdayDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("enter email: ");
        String email = scan.nextLine().trim();

        List<Number> phoneNumbers = Helpers.getNumbers(scan);
        appContactBook.addContact(name, second_name, birthdayDate, email, phoneNumbers);
    }
}
