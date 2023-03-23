package org.gumtree.assignment.finder;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.find.Finder;
import org.gumtree.assignment.addressbook.reader.AddressBookReader;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.find.GenderFinder;
import org.gumtree.assignment.gender.Gender;
import org.gumtree.assignment.response.GenderListResponse;
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
        Finder genderFinder = new GenderFinder();
        genderFinder.find(null);
    }

    @Test
    public void should_return_all_males_in_list() throws IOException, URISyntaxException, DetailsNotFoundException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();
        Finder genderFinder = new GenderFinder();
        GenderListResponse genderListResponse = (GenderListResponse)genderFinder.find(addressBooks);

        genderListResponse.getGenders().forEach(result -> {
            Assert.assertEquals(result.gender(), Gender.MALE);
        });
    }
}