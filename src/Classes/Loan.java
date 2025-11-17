package Classes;

import java.time.LocalDate;

public class Loan {

    private int id;
    private Book book;
    private String customerName;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(int id, Book book, String customerName) {
        this.id = id;
        this.book = book;
        this.customerName = customerName;
        this.loanDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean itWasReturned() {
        return returnDate != null;
    }

    @Override
    public String toString() {
        return "Loan #" + id +
                " | Livro: " + book.getTitle() +
                " | Cliente: " + customerName +
                " | Data: " + loanDate +
                " | Retornado: " + (itWasReturned() ? "Sim (" + returnDate + ")" : "Não");
    }
}