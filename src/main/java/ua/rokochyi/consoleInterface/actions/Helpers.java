package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.Number;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helpers {
    public static List<Number> getNumbers(Scanner scan){

        List<Number> phoneNumbers = new ArrayList<>();

        while (true) {
            System.out.println("enter provider of number: ");
            String provider = scan.nextLine().trim();
            System.out.println("enter number of that provider: ");
            String phoneNumber = scan.nextLine().trim();
            phoneNumbers.add(new Number(provider, phoneNumber));
            String choice;
            while (true) {
                System.out.println("do you want to add one more number phone of that person?(y/n): ");
                choice = scan.nextLine().toLowerCase().trim();
                if (choice.equals("y") || choice.equals("n")){
                    break;
                }
            }
            if (choice.equals("n")){
                break;
            }
        }
        return phoneNumbers;
    }

    public static void printThisList (List<Contact> contacts){
        if(contacts.size() == 1){
            System.out.println();
            System.out.println(contacts.get(0).toString());
            return;
        }
        int count = 1;
        for (Contact contact: contacts){
            System.out.println();
            System.out.println(count);
            System.out.println("initials: " + contact.person().name() + " " + contact.person().second_name() + "\n"+
                    "birthday: " + contact.person().birthday());
            for (Number number: contact.phoneNumbers()){
                System.out.println(number.provider()+": "+ number.phoneNumber());
            }
            count++;
        }
        System.out.println();
    }

    public static boolean choiceToDo(Scanner scan){
        String choice;
        while (true) {
            choice = scan.nextLine().toLowerCase().trim();
            if (choice.equals("y") || choice.equals("n")) {
                break;
            }
            System.out.println("enter 'y' or 'n': ");
        }
        if(choice.equals("y")){
            return true;
        }
        return false;
    }

    public static void printNumbers (List<Number> phoneNumbers){
        for (Number number: phoneNumbers){
            System.out.println(number.provider() +": "+ number.phoneNumber());
        }
    }

    public static int chooseItem (List<String> items, Scanner scan){
        int num;
        while (true) {
            int count = 1;
            for(String item: items){
                System.out.println(count + " - " + item);
                count++;
            }
            System.out.println("enter number: ");

            try {
                num = Integer.parseInt(scan.nextLine().trim());
                if(num < 1 || num > items.size()){
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("invalid input");
                continue;
            }
            return num;
        }
    }

    public static LocalDate getLocalDate (Scanner scan) {
        while (true) {
            System.out.println("enter birthday(yyyy-mm-dd): ");
            String date = scan.nextLine().trim();
            try {
                LocalDate birthdayDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
                return birthdayDate;
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        }
    }

}
