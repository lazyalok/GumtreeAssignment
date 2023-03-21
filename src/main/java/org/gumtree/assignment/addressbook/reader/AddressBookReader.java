package org.gumtree.assignment.addressbook.reader;

import org.apache.commons.lang3.StringUtils;
import org.gumtree.assignment.addressbook.AddressBook;
import org.gumtree.assignment.age.DateOfBirth;
import org.gumtree.assignment.exception.DetailsNotFoundException;
import org.gumtree.assignment.gender.Gender;
import org.gumtree.assignment.name.PersonName;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AddressBookReader {

    private static final String DATE_FORMAT = "dd/MM/yy";
    private String fileName;

    public AddressBookReader(String fileName) throws DetailsNotFoundException {

        if(StringUtils.isEmpty(fileName)){
            throw new DetailsNotFoundException("File name must not be empty");
        }
        this.fileName = fileName;
    }

    private static AddressBook populateAddressBook(String line) {
        String[] addressDetail = line.split(",");
        String name = addressDetail[0];
        String gender = addressDetail[1];
        String dob = addressDetail[2];
        return new AddressBook(new PersonName(name), getGenderEnum(gender), new DateOfBirth(getDateOfBirth(dob)));
    }

    private static LocalDate getDateOfBirth(String dob) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd/MM/")
                .appendValueReduced(ChronoField.YEAR, 2, 2, 1900).toFormatter();
        return LocalDate.parse(dob.trim(), formatter);
    }

    private static Gender getGenderEnum(String gender) {
        return "Male".equalsIgnoreCase(gender.trim()) ? Gender.MALE : Gender.FEMALE;
    }

    public List<AddressBook> readAddress() throws IOException, URISyntaxException {
        List<AddressBook> addressBooks;
        Path path = Path.of(ClassLoader.getSystemResource(fileName).toURI());
        try (Stream<String> lines = Files.lines(path)) {
            addressBooks = lines.map(AddressBookReader::populateAddressBook).collect(Collectors.toList());
        }
        return addressBooks;
    }
}
