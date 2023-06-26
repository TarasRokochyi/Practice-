package ua.rokochyi.domain.data;

import java.util.List;

public interface JsonConverter {
    String toJson(List<Contact> contacts);

    List<Contact> fromJson(String contacts);
}