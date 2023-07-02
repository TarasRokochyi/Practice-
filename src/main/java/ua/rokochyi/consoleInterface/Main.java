package ua.rokochyi.consoleInterface;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.rokochyi.consoleInterface.actions.*;
import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.*;

import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        String fileName = "ContactBook.json";

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        JsonConverter gsonConverter = new GsonConverter(gson);
        ContactDataSource dataSource = new ContactDataSource(gsonConverter, fileName);

        List<Contact> contacts = dataSource.readJson();

        AppContactBook appContactBook = new AppContactBook(dataSource, contacts);

        Scanner scan = new Scanner(System.in);
        System.out.println("add / delete / update / list / search / sort / save / help / quit");
        while (true) {
            System.out.println("command: ");
            String command = scan.nextLine().toLowerCase().trim();
            try{
                getAction(command).Operate(appContactBook, scan);
            }
            catch(Exception e) {
                System.out.println("there is some troubles. Massage: " + e.getMessage());
            }
        }
    }

    public static Action getAction(String command) throws Exception {
       switch(command) {
           case "add": return new AddAction();
           case "delete": return new DeleteAction();
           case "update": return new UpdateAction();
           case "list": return new ListAction();
           case "search": return new SearchAction();
           case "sort": return new SortAction();
           case "save": return new SaveAction();
           case "help": return new HelpAction();
           case "quit": return new QuitAction();
           default:
               throw new Exception("Command not found! Try help!");
       }
    }

}