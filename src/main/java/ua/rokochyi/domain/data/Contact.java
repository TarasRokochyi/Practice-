package ua.rokochyi.domain.data;

import java.util.List;

public record Contact(Person person, String email, List<Number> phoneNumbers) {
    @Override
    public String toString(){
        String string = "";
        for (Number number: this.phoneNumbers()){
            string = string + number.provider()+": "+ number.phoneNumber()+"\n";
        }
        return "initials: " + this.person().name() + " " + this.person().second_name() +"\n"+
                "birthday: " + this.person().birthday()+"\n"+
                "email: " + this.email()+"\n"+
                string;

    }
}
