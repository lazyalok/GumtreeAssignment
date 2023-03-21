package org.gumtree.assignment.addressbook.reader;

import org.gumtree.assignment.addressbook.AddressBook;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class AddressBookReaderTest {

    AddressBookReader addressBookReader = new AddressBookReader("AddressBook.txt");

    @Test
    public void should_parsed_all_fields_from_file_into_object() throws IOException, URISyntaxException {

        List<AddressBook> addressBooks = addressBookReader.readAddress();

        Assert.assertEquals(5, addressBooks.size());
        Assert.assertEquals("Bill McKnight", addressBooks.get(0).getPersonName().getName());
    }

}