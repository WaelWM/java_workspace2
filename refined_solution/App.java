package refined_solution;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        // Create some books
        List<Book> books = new ArrayList<>();
        books.add(new Book("Atomic Habits", 10));
        books.add(new Book("Life 3.0", 5));
        books.add(new Book("The Passenger", 20));

        // Creating a Library object
        Library library = new Library(books);

        // Setting the BookSearcher to search by title
        library.setBookSearcher(new TitleSearcher());

        // Creating an AddBookAdmin object and perform the task
        LibraryAdmin addBookAdmin = new AddBookAdmin(library, "Life 3.0", 20);
        addBookAdmin.performTask();

        // Creating an UpdateStockAdmin object and perform the task
        LibraryAdmin updateStockAdmin = new UpdateStockAdmin(library, "Atomic Habits", 15);
        updateStockAdmin.performTask();

        // Searching for books by title
        List<Book> searchResult = library.search("Atomic Habits");
        if (searchResult == null) {
            System.out.println("Book not found");
        } else {
            System.out.println("Search result:");
            for (Book book : searchResult) {
                System.out.println(book.getTitle() + " - " + book.getStock());
            }
        }
    }
}