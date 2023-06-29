package ua.rokochyi.consoleInterface.actions;

import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.Number;

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

    public static boolean choiceToDelete(Scanner scan){
        String choice;
        while (true) {
            System.out.println("delete this contact?(y/n): ");
            choice = scan.nextLine().toLowerCase().trim();
            if (choice.equals("y") || choice.equals("n")) {
                break;
            }
        }
        if(choice.equals("y")){
            return true;
        }
        return false;
    }

}
