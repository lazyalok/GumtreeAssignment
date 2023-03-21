package org.gumtree.assignment.addressbook;

import org.gumtree.assignment.age.DateOfBirth;
import org.gumtree.assignment.gender.Gender;
import org.gumtree.assignment.name.PersonName;

public final class AddressBook {
    private final PersonName personName;
    private final Gender gender;
    private final DateOfBirth dateOfBirth;

    public AddressBook(PersonName personName, Gender gender, DateOfBirth dateOfBirth) {
        this.personName = personName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public PersonName getPersonName() {
        return personName;
    }

    public Gender getGender() {
        return gender;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }
}
