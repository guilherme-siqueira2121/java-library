import Classes.*;
import Classes.Author;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;
        boolean executing = true;


        Author author1 = new Author(1, "George Orwell", LocalDate.of(1903, 6, 25));
        Author author2 = new Author(2, "Oscar Wilde", LocalDate.of(1854, 9, 16));
        Author author3 = new Author(3, "Franz Kafka", LocalDate.of(1883, 7, 3));
        Author author4 = new Author(4, "Albert Camus", LocalDate.of(1913, 10, 7));
        Author author5 = new Author(5, "Virginia Woolf", LocalDate.of(1883, 1, 25));
        Author author6 = new Author(6, "Fyodor Dostoiévski", LocalDate.of(1821, 10, 11));
        Author author7 = new Author(7, "Aldous Huxley", LocalDate.of(1894, 7, 26));
        Author author8 = new Author(8, "Jean-Paul Sartre", LocalDate.of(1905, 6, 21));
        Author author9 = new Author(9, "Ernest Hemingway", LocalDate.of(1899, 7, 21));
        Author author10 = new Author(10, "Oscar Wilde", LocalDate.of(1877, 7, 2));
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addAuthor(author4);
        library.addAuthor(author5);
        library.addAuthor(author6);
        library.addAuthor(author7);
        library.addAuthor(author8);
        library.addAuthor(author9);
        library.addAuthor(author10);

        Book book1 = new Book(1, "1984", author1, LocalDate.of(1949, 6, 8), true);
        Book book2 = new Book(2, "The Picture of Dorian Grey", author2, LocalDate.of(1890, 7, 20), true);
        Book book3 = new Book(3, "The Metamorphosis", author3, LocalDate.of(1915, 10, 15), true);
        Book book4 = new Book(4, "The Stranger", author4, LocalDate.of(1945, 5, 19), true);
        Book book5 = new Book(5, "Mrs. Dalloway", author5, LocalDate.of(1925, 5, 14), true);
        Book book6 = new Book(6, "Crime and Punishment", author6, LocalDate.of(1866, 1, 12), true);
        Book book7 = new Book(7, "Brave New World", author7, LocalDate.of(1932, 8, 30), true);
        Book book8 = new Book(8, "Nausea", author8, LocalDate.of(1938, 4, 5), true);
        Book book9 = new Book(9, "The Old Man and the Sea", author9, LocalDate.of(1952, 9, 1), true);
        Book book10 = new Book(10, "Steppenwolf", author10, LocalDate.of(1927, 6, 25), true);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);

        System.out.println("Bem-vindo à Livraria!");

        while (running) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Cliente");
            System.out.println("2 - Admin");
            System.out.println("3 - Sair");

            System.out.println("Opção: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    clientMenu(sc, library);
                    break;

                case "2":
                    adminMenu(sc, library);
                    break;

                case "3":
                    running = false;
                    System.out.println("Obrigado por utilizar a nossa Livraria. Volte sempre!");
                    break;

                default:
                    System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        sc.close();
    }

    private static void clientMenu (Scanner sc, Library library) {
        boolean executing = true;

        while (executing) {
            System.out.println("\n========== CLIENTE MENU ==========");
            System.out.println("1 - Listar livros disponíveis");
            System.out.println("2 - Procurar por título");
            System.out.println("3 - Pegar livro emprestado");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Sair");

            System.out.println("Escolha uma opção entre (1-5): ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    library.listAvailableBooks();
                    break;

                case"2":
                    System.out.println("Escreva o título: ");
                    String title = sc.nextLine();
                    library.searchBookByName(title);
                    break;

                case "3":
                    library.listAvailableBooks();
                    System.out.println("Insira um ID de um livro: ");
                    String bookIdStr = sc.nextLine();

                    try {
                        int bookId = Integer.parseInt(bookIdStr);
                        System.out.println("Seu nome: ");
                        String name = sc.nextLine();

                        library.takeOutLoan(bookId, name);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Insira um ID válido.");
                    }
                    break;

                case "4":
                    System.out.println("Insira o ID do livro que deseja devolver: ");
                    String returnIdStr = sc.nextLine();

                    try {
                        int returnId = Integer.parseInt(returnIdStr);
                        library.returnBook(returnId);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Insira o ID de um livro válido.");
                    }
                    break;

                case "5":
                    System.out.println("Obrigado por visitar a Livraria. Até logo!");
                    executing = false;
                    break;

                default:
                    System.out.println("Entrada inválida. Insira uma opção entre (1-4).");
                    break;
            }
        }
    }

    private static void adminMenu (Scanner sc, Library library) {
        boolean executing = true;

        while (executing) {
            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1 - Listar todos os livros");
            System.out.println("2 - Listar livros emprestados");
            System.out.println("3 - Cadastar novo livro");
            System.out.println("4 - Retornar");

            System.out.println("Opção: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    library.listAllBooks();
                    break;

                case "2":
                    library.listLoan();
                    break;

                case "3":
                    addNewBook(sc, library);
                    break;

                case "4":
                    executing = false;
                    break;
            }
        }
    }

    private static void addNewBook (Scanner sc, Library library) {
        System.out.println("Título do livro: ");
        String title = sc.nextLine();

        System.out.println("Nome do autor: ");
        String authorName = sc.nextLine();

        Author author = library.findOrCreateAuthor(authorName);

        Book newBook = new Book(
                library.getNextBookId(),
                title,
                author,
                LocalDate.now(),
                true
        );

        library.addBook(newBook);
        System.out.println("Livro adicionado com sucessso!");
    }
}