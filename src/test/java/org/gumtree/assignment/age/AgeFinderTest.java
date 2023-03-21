package org.gumtree.assignment.age;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.addressbook.reader.AddressBookReader;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.name.PersonName;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class AgeFinderTest {

    AddressBookReader addressBookReader = new AddressBookReader("AddressBook.txt");

    @Test
    public void should_return_oldest_person_in_address_book() throws IOException, URISyntaxException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        AgeFinder ageFinder = new AgeFinder();
        PersonName personName = ageFinder.findOldestPerson(addressBooks);


        Assert.assertEquals("Wes Jackson", personName.getName());
    }

    @Test
    public void should_age_difference_between_two_object_when_first_is_small_second_is_big() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        AgeFinder ageFinder = new AgeFinder();
        Integer daysOlder = ageFinder.howManyDaysOlder(addressBooks, "Sarah Stone", "Bill McKnight");

        Assert.assertEquals(daysOlder.intValue(),1284);
    }

    @Test
    public void should_age_difference_between_two_object_when_second_is_small_first_is_big() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        AgeFinder ageFinder = new AgeFinder();
        Integer daysOlder = ageFinder.howManyDaysOlder(addressBooks, "Bill McKnight", "Paul Robinson");

        Assert.assertEquals(daysOlder.intValue(),2862);
    }

    @Test(expected = DetailsNotFoundException.class)
    public void should_throw_DetailsNotFoundException_when_both_input_null() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        AgeFinder ageFinder = new AgeFinder();
         ageFinder.howManyDaysOlder(addressBooks, null, null);
    }

}