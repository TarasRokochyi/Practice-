package ua.rokochyi.domain.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class GsonConverter implements JsonConverter{

    private final Gson gson;

    public GsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String toJson(List<Contact> contacts) {
        return gson.toJson(contacts);
    }

    @Override
    public List<Contact> fromJson(String contacts) {
        if (contacts.isEmpty()){
            return new ArrayList<Contact>();
        }
        TypeToken<List<Contact>> contactsType = new TypeToken<>(){};
        return gson.fromJson(contacts, contactsType);
    }
}
