package org.gumtree.assignment.response;

import org.gumtree.assignment.name.PersonName;

public class PersonNameResponse implements AddressBookResponse{

    private final PersonName personName;

    public PersonNameResponse(PersonName personName) {
        this.personName = personName;
    }

    public PersonName getPersonName() {
        return personName;
    }
}
