package com.codve;

import lombok.Data;

import java.time.Instant;
import java.time.MonthDay;

@Data
public class Contact implements Comparable<Contact>{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private MonthDay birthday;

    public Contact(String firstName, String lastName,
                   String phoneNumber, String address,
                   MonthDay birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Contact other) {
        int rs = lastName.compareTo(other.lastName);
        if (rs == 0) {
            rs = firstName.compareTo(other.firstName);
        }
        return rs;
    }

}
