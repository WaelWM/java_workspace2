package simple_solution;


public class App {
    public static void main(String[] args) {
        BookHorizon bookHorizon = new BookHorizon();
        
        // Adding books
        bookHorizon.addBook("Life 3.0", 10);
        bookHorizon.addBook("Atomic Habits", 5);
        bookHorizon.addBook("The Passenger", 60);

        // updating the stock of a book
        bookHorizon.updateStock("Atomic Habits", 10);

        // Searching for a book
        bookHorizon.searchBook("Life 3.0");

        // Searching for a book that does not exist
        bookHorizon.searchBook("Lost in the Dessert");

    }
}