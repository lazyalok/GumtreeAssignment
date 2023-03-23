package org.gumtree.assignment.addressbook.reader;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class AddressBookReaderTest {

    private AddressBookReader addressBookReader;

    @Before
    public void setUp() throws DetailsNotFoundException {
        addressBookReader = new AddressBookReader("AddressBook.txt");
    }

    @Test
    public void should_parsed_all_fields_from_file_into_object() throws IOException, URISyntaxException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();

        Assert.assertEquals(5, addressBooks.size());
        Assert.assertEquals("Bill McKnight", addressBooks.get(0).personName().name());
    }


    @Test(expected = DetailsNotFoundException.class)
    public void should_throw_exception_when_file_name_null() throws IOException, URISyntaxException, DetailsNotFoundException {
        addressBookReader = new AddressBookReader("");
    }

}