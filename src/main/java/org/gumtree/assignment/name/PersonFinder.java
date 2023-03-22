package org.gumtree.assignment.name;

import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.find.Finder;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.response.AddressBookResponse;
import org.gumtree.assignment.response.SingleAddressResponse;

import java.util.List;
import java.util.Optional;

public final class PersonFinder implements Finder {

    private final String name;
    public PersonFinder(String name){
        this.name=name;
    }
    @Override
    public AddressBookResponse find(List<AddressBook> addressBooks) throws DetailsNotFoundException {
        Optional<AddressBook> addressBookResp = addressBooks.stream().filter(addressBook -> addressBook.getPersonName().getName().equalsIgnoreCase(name)).findFirst();

        if(addressBookResp.isEmpty()){
            throw new DetailsNotFoundException("response is empty");
        }
        return new SingleAddressResponse(addressBookResp.get());
    }
}
