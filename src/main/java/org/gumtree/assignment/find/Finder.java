package org.gumtree.assignment.find;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.response.AddressBookResponse;

import java.util.List;

public sealed interface Finder permits GenderFinder, DaysOlderFinder, OldestPersonFinder, PersonFinder {
    AddressBookResponse find(List<AddressBook> addressBooks) throws DetailsNotFoundException;
}
