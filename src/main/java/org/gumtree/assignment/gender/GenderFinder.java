package org.gumtree.assignment.gender;

import org.apache.commons.collections4.CollectionUtils;
import org.gumtree.assignment.addressbook.AddressBook;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.gumtree.assignment.gender.Gender.MALE;

public final class GenderFinder {
    private final Predicate<AddressBook> IS_MALE = addressBook -> MALE.equals(addressBook.getGender());

    public List<AddressBook> findMaleGenders(List<AddressBook> addressBooks) {
        if (CollectionUtils.isEmpty(addressBooks)) {

        }
        return addressBooks.stream().filter(IS_MALE).collect(Collectors.toList());
    }
}
