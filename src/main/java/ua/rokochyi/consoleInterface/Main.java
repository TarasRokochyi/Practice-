package ua.rokochyi.consoleInterface;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.*;
import ua.rokochyi.domain.data.Number;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        JsonConverter gsonConverter = new GsonConverter(gson);
        ContactDataSource dataSource = new ContactDataSource(gsonConverter);
        List<Contact> contacts;

        String fileName = "ContactBook.json";
        try {
            Path path = Paths.get(fileName);
            contacts = dataSource.readJson(path);
        } catch (Exception e) {
            System.out.println("Error while reading from file " + fileName + "\nError message - " + e.getMessage());
            contacts = new ArrayList<>();
        }

        AppContactBook appContactBook = new AppContactBook(dataSource, contacts);

        Scanner scan = new Scanner(System.in);
        System.out.println("add / remove / update / list / search / sort / save / quit");
        String command;
        while (true) {
            System.out.println("command: ");
            command = scan.nextLine().trim();
            switch (command) {
                case "add":
                    appContactBook.addContact();
                    break;
                case "remove":
                    //todo
                    break;
                case "update":
                    //todo
                    break;
                case "list":
                    //todo
                    break;
                case "search":
                    //todo
                    break;
                case "sort":
                    //todo
                    break;
                case "save":
                    appContactBook.saveContacts(fileName);
                    break;
                case "quit":
                    System.exit(0);
                default:
                    System.out.println("enter command: add / remove / update / search / sort / quit");
            }
        }
    }
}