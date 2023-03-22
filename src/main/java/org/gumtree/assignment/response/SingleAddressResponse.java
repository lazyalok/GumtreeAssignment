package org.gumtree.assignment.response;

import org.gumtree.assignment.addressbook.AddressBook;

public class SingleAddressResponse implements AddressBookResponse{

    private AddressBook addressBook;

    public SingleAddressResponse(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }
}
