package org.gumtree.assignment.age;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.find.Finder;
import org.gumtree.assignment.addressbook.reader.AddressBookReader;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.response.AgeDiffResponse;
import org.gumtree.assignment.response.PersonNameResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class OldestPersonFinderTest {

    private AddressBookReader addressBookReader;

    @Before
    public void setUp() throws DetailsNotFoundException {
        addressBookReader = new AddressBookReader("AddressBook.txt");
    }

    @Test
    public void should_return_oldest_person_in_address_book() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        Finder oldestPersonFinder = new OldestPersonFinder();
        PersonNameResponse oldestPersonName = (PersonNameResponse) oldestPersonFinder.find(addressBooks);
        Assert.assertEquals("Wes Jackson", oldestPersonName.getPersonName().getName());
    }

    @Test
    public void should_return_age_difference_between_two_object_when_first_age_is_small_second_age_is_big() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        Finder daysOlderFinder = new DaysOlderFinder("Sarah Stone", "Bill McKnight");
        AgeDiffResponse addressBookResponse = (AgeDiffResponse) daysOlderFinder.find(addressBooks);

        Assert.assertEquals(Math.abs(addressBookResponse.getAgeDiff()), 1284);
    }

    @Test
    public void should_age_difference_between_two_object_when_second_i_age_is_small_first_age_is_big() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        Finder daysOlderFinder = new DaysOlderFinder("Bill McKnight", "Paul Robinson");
        AgeDiffResponse addressBookResponse = (AgeDiffResponse) daysOlderFinder.find(addressBooks);

        Assert.assertEquals(addressBookResponse.getAgeDiff().intValue(), 2862);
    }

    @Test(expected = DetailsNotFoundException.class)
    public void should_throw_DetailsNotFoundException_when_both_input_null() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        Finder daysOlderFinder = new DaysOlderFinder(null, null);
        daysOlderFinder.find(addressBooks);
    }

}