package org.gumtree.assignment.find;

import org.apache.commons.collections4.CollectionUtils;
import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.find.Finder;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.response.AddressBookResponse;
import org.gumtree.assignment.response.GenderListResponse;

import java.util.List;
import java.util.function.Predicate;

import static org.gumtree.assignment.gender.Gender.MALE;

public final class GenderFinder implements Finder {
    private final Predicate<AddressBook> IS_MALE = addressBook -> MALE.equals(addressBook.gender());

    @Override
    public AddressBookResponse find(List<AddressBook> addressBooks) throws DetailsNotFoundException {
        if (CollectionUtils.isEmpty(addressBooks)) {
            throw new DetailsNotFoundException(" addressBooks can not be empty or null");
        }
        List<AddressBook>  maleAddressList =  addressBooks.stream().filter(IS_MALE).toList();
        return new GenderListResponse(maleAddressList);
    }
}
