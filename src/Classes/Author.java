package Classes;

import java.time.LocalDate;

public class Author {

    private int id;
    private String name;
    private LocalDate dateOfBirth;

    public Author(int id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + id + "]" + name + " (nascido em " + dateOfBirth + ")";
    }
}