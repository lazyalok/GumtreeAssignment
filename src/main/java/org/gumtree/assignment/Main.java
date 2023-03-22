package org.gumtree.assignment;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.find.Finder;
import org.gumtree.assignment.addressbook.reader.AddressBookReader;
import org.gumtree.assignment.age.DaysOlderFinder;
import org.gumtree.assignment.age.OldestPersonFinder;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.gender.GenderFinder;
import org.gumtree.assignment.response.AgeDiffResponse;
import org.gumtree.assignment.response.GenderListResponse;
import org.gumtree.assignment.response.PersonNameResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, DetailsNotFoundException {

        AddressBookReader reader = new AddressBookReader("AddressBook.txt");
        List<AddressBook> addressBooks = reader.readAddress();

        howManyMalesInTheAddressBook(addressBooks);
        whoIsTheOldestPersonInAddressBook(addressBooks);
        howManyDaysOlderBillThanPaul(addressBooks);
    }

    private static void howManyMalesInTheAddressBook(List<AddressBook> addressBooks) throws DetailsNotFoundException {
        Finder finder = new GenderFinder();
        GenderListResponse maleGenders = (GenderListResponse) finder.find(addressBooks);
        System.out.println("There are " + maleGenders.getGenders().size() + " male gender in given list");
    }

    private static void whoIsTheOldestPersonInAddressBook(List<AddressBook> addressBooks) throws DetailsNotFoundException {
        Finder oldestPersonFinder = new OldestPersonFinder();
        PersonNameResponse personNameResponse = (PersonNameResponse) oldestPersonFinder.find(addressBooks);
        System.out.println("Oldest person in given address book list is : " + personNameResponse.getPersonName().getName());
    }

    private static void howManyDaysOlderBillThanPaul(List<AddressBook> addressBooks) throws DetailsNotFoundException {
        Finder daysOlderFinder = new DaysOlderFinder("Bill McKnight", "Paul Robinson");
        AgeDiffResponse daysOlder = (AgeDiffResponse) daysOlderFinder.find(addressBooks);

        if (daysOlder.getAgeDiff() > -1) {
            System.out.println("Bill is " + daysOlder.getAgeDiff() + " days older than Paul");
        } else {
            System.out.println("Bill is " + Math.abs(daysOlder.getAgeDiff()) + " days younger than Paul");
        }
    }
}
