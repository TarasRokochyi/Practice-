package ua.rokochyi.consoleInterface;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.rokochyi.consoleInterface.actions.Action;
import ua.rokochyi.consoleInterface.actions.AddAction;
import ua.rokochyi.consoleInterface.actions.QuitAction;
import ua.rokochyi.consoleInterface.actions.SaveAction;
import ua.rokochyi.domain.AppContactBook;
import ua.rokochyi.domain.data.*;

import java.nio.file.Path;
import java.nio.file.Paths;
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
        System.out.println("add / remove / update / list / search / sort / save / help / quit");
        String command;
        while (true) {
            System.out.println("command: ");
            command = scan.nextLine().trim();
            try{
                getAction(command).Operate(appContactBook, scan);
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Action getAction(String command) throws Exception {
       switch(command) {
           case "add": return new AddAction();
           case "list": return new Action() {
               @Override
               public void Operate(AppContactBook contactBook, Scanner scanner) {
                   contactBook.listContact();
               }
           };
           case "save": return new SaveAction();
           case "quit": return new QuitAction();

           default:
               throw new Exception("Command not found!");
       }
    }

}