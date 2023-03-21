package org.gumtree.assignment.gender;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.addressbook.reader.AddressBookReader;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class GenderFinderTest {

    private AddressBookReader addressBookReader;

    @Before
    public void setUp() throws DetailsNotFoundException {
        addressBookReader = new AddressBookReader("AddressBook.txt");
    }

    @Test(expected = DetailsNotFoundException.class)
    public void should_throw_DetailsNotFoundException_when_address_book_is_empty() throws DetailsNotFoundException, IOException, URISyntaxException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        GenderFinder genderFinder = new GenderFinder();
        genderFinder.findMaleGenders(null);
    }

    @Test
    public void should_return_all_males_in_list() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        GenderFinder genderFinder = new GenderFinder();
        List<AddressBook> results = genderFinder.findMaleGenders(addressBooks);

        results.forEach(result -> {
            Assert.assertEquals(result.getGender(), Gender.MALE);
        });
    }
}