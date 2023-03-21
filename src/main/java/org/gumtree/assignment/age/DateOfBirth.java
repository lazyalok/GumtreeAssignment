package org.gumtree.assignment.age;

import java.time.LocalDate;

public final class DateOfBirth implements Comparable<DateOfBirth> {
    private final LocalDate dob;

    public DateOfBirth(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public int compareTo(DateOfBirth dob) {
        return getDob().compareTo(dob.getDob());
    }
}
