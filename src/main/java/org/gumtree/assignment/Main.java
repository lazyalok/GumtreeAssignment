package org.gumtree.assignment;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.addressbook.reader.AddressBookReader;
import org.gumtree.assignment.age.AgeFinder;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.gender.GenderFinder;
import org.gumtree.assignment.name.PersonName;

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
        GenderFinder finder = new GenderFinder();
        List<AddressBook> maleGenders = finder.findMaleGenders(addressBooks);
        System.out.println("There are " + maleGenders.size() + " male gender in given list");
    }

    private static void whoIsTheOldestPersonInAddressBook(List<AddressBook> addressBooks) {
        AgeFinder ageFinder = new AgeFinder();
        PersonName personName = ageFinder.findOldestPerson(addressBooks);
        System.out.println("Oldest person in given address book list is : " + personName.getName());
    }

    private static void howManyDaysOlderBillThanPaul(List<AddressBook> addressBooks) throws DetailsNotFoundException {
        AgeFinder ageFinder = new AgeFinder();
        Integer daysOlder = ageFinder.howManyDaysOlder(addressBooks, "Bill McKnight", "Paul Robinson");

        if(daysOlder > -1){
            System.out.println("Bill is "+daysOlder+" days older than Paul");
        }else{
            System.out.println("Bill is "+Math.abs(daysOlder)+" days younger than Paul");
        }
    }
}
