package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listAvailableBooks() {
        boolean isAvailable = false;

        System.out.println("Livros disponíveis:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                isAvailable = true;
            }
        }

        if (!isAvailable) {
            System.out.println("Nenhum livro disdponível no momento.");
        }
    }

    public void listAllBooks() {
        System.out.println("\nTodos os livros da Livraria: ");

        for (Book book : books) {
            System.out.println(" | ID: " + book.getId() + " | " + book.getTitle() +
                    " | Autor: " + book.getAuthor().getName() +
                    " | Disponível: " + (book.isAvailable() ? "Sim" : "Não"));
        }
    }

    public void listLoan() {
        System.out.println("Histórico de livros emprestados: ");

        if (loans.isEmpty()) {
            System.out.println("Nenhum livro emprestado.");
            return;
        }

        for (Loan loa : loans) {
            System.out.println(loa);
        }
    }

    public void takeOutLoan(int idBook, String customerName) {
        Book selectedBook = null;

        for (Book book : books) {
            if (book.getId() == idBook && book.isAvailable()) {
                selectedBook = book;
                break;
            }
        }

        int newId = loans.size() + 1;
        Loan loan = new Loan(newId, selectedBook, customerName);

        selectedBook.setAvailable(false);

        loans.add(loan);

        System.out.println("Sucesso!");
        System.out.println(loan);
    }

    public void returnBook(int idBook) {
        for (Loan loan : loans) {
            if (loan.getBook().getId() == idBook && loan.getBook().isAvailable() == false) {
                loan.getBook().setAvailable(true);
                loan.setReturnDate(java.time.LocalDate.now());
                System.out.println("O livro '" + loan.getBook().getTitle() + "' foi devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Este livro não está atualmente emprestado ou não existe.");
    }

    public void searchBookByName(String title) {
        boolean found = false;

        System.out.println("Procurando por livros: " + title);
        System.out.println("--------------------");

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(" | " + book.getTitle() + " | Autor: " + book.getAuthor().getName() +
                        " | Disponível: " + (book.isAvailable() ? "Sim" : "Não"));

                found = true;
            }
        }

        if (!found) {
            System.out.println("Nenhum livro foi encontrado por esse título.");
        }
    }


    public Author findOrCreateAuthor(String name) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }

        Author newAuthor = new Author(authors.size() + 1, name, LocalDate.now());
        authors.add(newAuthor);
        return newAuthor;
    }

    public int getNextBookId() {
        return books.size() + 1;
    }
}