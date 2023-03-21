package org.gumtree.assignment.age;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.name.PersonName;

import java.util.Comparator;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class AgeFinder {
    public PersonName findOldestPerson(List<AddressBook> addressBooks) {
        Comparator<AddressBook> dobComparator = Comparator.comparing(AddressBook::getDateOfBirth);
        addressBooks.sort(dobComparator);
        return addressBooks.get(0).getPersonName();
    }
    public Integer findAgeDifference(AddressBook addressBookOne , AddressBook addressBookTwo){
        return Math.toIntExact(DAYS.between(addressBookOne.getDateOfBirth().getDob(),
                addressBookTwo.getDateOfBirth().getDob()));
    }
}
