package org.gumtree.assignment.age;

import org.apache.commons.collections4.CollectionUtils;
import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.find.Finder;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.name.PersonFinder;
import org.gumtree.assignment.response.AddressBookResponse;
import org.gumtree.assignment.response.AgeDiffResponse;
import org.gumtree.assignment.response.SingleAddressResponse;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public final class DaysOlderFinder implements Finder {

    private final String nameOne;
    private final String nameTwo;

    public DaysOlderFinder(String nameOne, String nameTwo) {
        this.nameOne = nameOne;
        this.nameTwo = nameTwo;
    }

    @Override
    public AddressBookResponse find(List<AddressBook> addressBooks) throws DetailsNotFoundException {

        if (CollectionUtils.isEmpty(addressBooks)) {
            throw new DetailsNotFoundException(" addressBooks should not be empty ");
        }
        return new AgeDiffResponse(ageDiff(addressBooks, nameOne, nameTwo) );
    }

    private Integer ageDiff(List<AddressBook> addressBooks, String nameOne, String nameTwo) throws DetailsNotFoundException {
        PersonFinder personFinderOne = new PersonFinder(nameOne);
        SingleAddressResponse firstAddress = (SingleAddressResponse)personFinderOne.find(addressBooks);

        PersonFinder personFinderTwo = new PersonFinder(nameTwo);
        SingleAddressResponse secondAddress =  (SingleAddressResponse)personFinderTwo.find(addressBooks);

        if (firstAddress.getAddressBook() != null && secondAddress.getAddressBook() != null) {
            return calculateDays(firstAddress.getAddressBook(), secondAddress.getAddressBook());
        }
        throw new DetailsNotFoundException(" Details not found for given input name 1: " + nameOne + " input name 2: " + nameTwo);

    }

    private Integer calculateDays(AddressBook addressBookOne, AddressBook addressBookTwo) {
        return Math.toIntExact(DAYS.between(addressBookOne.getDateOfBirth().getDob(),
                addressBookTwo.getDateOfBirth().getDob()));
    }

}
