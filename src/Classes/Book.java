package Classes;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private Author author;
    private LocalDate publicationDate;
    private boolean available;

    public Book(int id, String title, Author author, LocalDate publicationDate, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return " | ID: " + id + " | " + title +
                " | Autor: " + author.getName() +
                " | Publicado em: " + publicationDate +
                " | Disponível? " + (available ? "Sim" : "Não");
    }
}