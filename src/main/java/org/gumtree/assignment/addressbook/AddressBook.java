package org.gumtree.assignment.addressbook;

import org.gumtree.assignment.age.DateOfBirth;
import org.gumtree.assignment.gender.Gender;
import org.gumtree.assignment.name.PersonName;

public record AddressBook(PersonName personName,Gender gender,DateOfBirth dateOfBirth) {
}
