package ua.rokochyi.domain.data;

import java.util.List;

public record Contact(Person person, String email, List<Number> phoneNumbers) {
}
