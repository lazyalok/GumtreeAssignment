package org.gumtree.assignment.name;

import org.gumtree.assignment.addressbook.AddressBook;

import java.util.List;
import java.util.Optional;

public class PersonFinder {
    public Optional<AddressBook> findPersonByName(List<AddressBook> addressBooks, String name) {
        return addressBooks.stream().filter(addressBook -> addressBook.getPersonName().getName().equalsIgnoreCase(name)).findFirst();
    }
}
