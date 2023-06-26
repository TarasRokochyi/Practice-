package ua.rokochyi.domain.data;

import java.time.LocalDate;

public record Person(String name, String second_name, LocalDate birthday) {
}
