package ua.rokochyi.consoleInterface;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.Contact;
import ua.rokochyi.domain.data.ContactDataSource;
import ua.rokochyi.domain.data.GsonConverter;
import ua.rokochyi.domain.data.JsonConverter;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        JsonConverter gsonConverter = new GsonConverter(gson);
        ContactDataSource dataSource = new ContactDataSource(gsonConverter);
        List<Contact> contacts = dataSource.readJson("ContactBook");
        AppContactBook contactBook = new AppContactBook(dataSource, contacts);

        Scanner scan = new Scanner(System.in);
        System.out.println("add / remove / update / list / search / sort / quit");
        String command;
        while (true){
            System.out.println("command: ");
            command = scan.nextLine().trim();
            switch (command){
                case "add":
                    //todo
                case "remove":
                    //todo
                case "update":
                    //todo
                case "list":
                    //todo
                case "search":
                    //todo
                case "sort":
                    //todo
                case "quit":
                    //save changes and close the program
                    break;
                default:
                    System.out.println("enter command: add / remove / update / search / sort / quit");

            }
        }
    }
}