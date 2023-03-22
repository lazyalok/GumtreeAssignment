package org.gumtree.assignment.response;

import org.gumtree.assignment.addressbook.AddressBook;

import java.util.List;

public class GenderListResponse implements AddressBookResponse {
    private final List<AddressBook>  genders;

    public GenderListResponse(List<AddressBook> genders) {
        this.genders = genders;
    }

    public List<AddressBook> getGenders() {
        return genders;
    }
}
