package org.gumtree.assignment.find;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.response.AddressBookResponse;

import java.util.List;

public interface Finder {
    AddressBookResponse find(List<AddressBook> addressBooks) throws DetailsNotFoundException;
}
