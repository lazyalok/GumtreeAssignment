package org.gumtree.assignment.age;

import java.time.LocalDate;
public record DateOfBirth(LocalDate dob) implements Comparable<DateOfBirth> {
    public LocalDate getDob() {
        return dob;
    }
    @Override
    public int compareTo(DateOfBirth dob) {
        return getDob().compareTo(dob.getDob());
    }

}
