package org.gumtree.assignment.age;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.find.Finder;
import org.gumtree.assignment.name.PersonName;
import org.gumtree.assignment.response.AddressBookResponse;
import org.gumtree.assignment.response.PersonNameResponse;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class OldestPersonFinder implements Finder {
    @Override
    public AddressBookResponse find(List<AddressBook> addressBooks) {
        Comparator<AddressBook> dobComparator = Comparator.comparing(AddressBook::getDateOfBirth);
        addressBooks.sort(dobComparator);
        Optional<PersonName> personName = Optional.of(addressBooks.get(0).getPersonName());
        return new PersonNameResponse(personName.get());
    }
}
