package org.gumtree.assignment.response;

public final class AgeDiffResponse implements AddressBookResponse {

    public final Integer ageDiff;

    public AgeDiffResponse(Integer ageDiff) {
        this.ageDiff = ageDiff;
    }

    public Integer getAgeDiff() {
        return ageDiff;
    }
}
