package simple_solution;

import java.util.ArrayList;

class Book {
    private String title;
    private int stock;

    public Book(String title, int stock) {
        this.title = title;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

class BookHorizon {
    private ArrayList<Book> books;

    public BookHorizon() {
        books = new ArrayList<>();
    }

    public void addBook(String title, int stock) {
        Book newBook = new Book(title, stock);
        books.add(newBook);
        System.out.println("Book added successfully.");
    }

    public void updateStock(String title, int newStock) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setStock(newStock);
                System.out.println("Stock updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book found: " + book.getTitle() 
                + ", Stock available: " + book.getStock());
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
