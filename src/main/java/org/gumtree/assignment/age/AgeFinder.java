package org.gumtree.assignment.age;

import org.apache.commons.collections4.CollectionUtils;
import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.name.PersonFinder;
import org.gumtree.assignment.name.PersonName;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

public final class AgeFinder {
    public PersonName findOldestPerson(List<AddressBook> addressBooks) {
        Comparator<AddressBook> dobComparator = Comparator.comparing(AddressBook::getDateOfBirth);
        addressBooks.sort(dobComparator);
        return addressBooks.get(0).getPersonName();
    }

    public Integer howManyDaysOlder(List<AddressBook> addressBooks, String nameOne, String nameTwo) throws DetailsNotFoundException {

        if (CollectionUtils.isEmpty(addressBooks)) {
            throw new DetailsNotFoundException(" addressBooks should not be empty ");
        }
        return ageDiff(addressBooks, nameOne, nameTwo);
    }

    private Integer ageDiff(List<AddressBook> addressBooks, String nameOne, String nameTwo) throws DetailsNotFoundException {
        PersonFinder personFinder = new PersonFinder();
        Optional<AddressBook> firstAddress = personFinder.findPersonByName(addressBooks, nameOne);
        Optional<AddressBook> secondAddress = personFinder.findPersonByName(addressBooks, nameTwo);

        if (firstAddress.isPresent() && secondAddress.isPresent()) {
            AgeFinder ageFinder = new AgeFinder();
            return ageFinder.calculateDays(firstAddress.get(), secondAddress.get());
        }
        throw new DetailsNotFoundException(" Details not found for given input name 1: " + nameOne + " input name 2: " + nameTwo);

    }

    private Integer calculateDays(AddressBook addressBookOne, AddressBook addressBookTwo) {
        return Math.toIntExact(DAYS.between(addressBookOne.getDateOfBirth().getDob(),
                addressBookTwo.getDateOfBirth().getDob()));
    }
}
